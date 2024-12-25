public class doubleLL {

    public class Node{
        int data;
        Node next;
        Node prev;

        public Node(int data){
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size;

    public void addFirst(int data){
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    public void addLast(int data){
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head = tail = newNode;
            return;
        }
        newNode.prev = tail;
        tail.next = newNode;
        tail = newNode;
    }

    public void printDLL(){
        Node temp = head;
        while( temp != null ){
            System.out.print(temp.data+"<->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public int removeFirst(){
        if( head == null ){
            System.out.print("DLL is empty");
            return Integer.MIN_VALUE;
        }
        if( size == 1){
            int val = head.data;
            head = tail = null;
            size--;
            return val;
        }
        int val = head.data;
        head = head.next;
        head.prev = null;
        size--;
        return val;
    }

    public int removeLast(){
        if(head == null){
            System.out.println(" DLL is empty");
            return Integer.MIN_VALUE;
        }

        if(size == 1){
            int val = tail.data;
            head = tail = null;
            size = 0;
            return val;
        }
        Node prev = head;
        for(int i=0; i<size-2; i++){
            prev = prev.next; 
        }
        int val = prev.next.data;
        prev.next = null;
        tail = prev;
        size--;
        return val;
    }

    public void reverseDLL(){
        Node curr = head;
        Node prev = null;
        Node next;

        while( curr != null ){
            next = curr.next;
            curr.next = prev;
            curr.prev = next;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    public static void main(String args[]){
        doubleLL dLL = new doubleLL();
        dLL.addLast(3);
        dLL.addLast(2);
        dLL.addLast(1);
        dLL.printDLL();
        // dLL.removeFirst();d
        // dLL.printDLL();
        // System.out.println(dLL.size);
        // System.out.println();
        // dLL.addFirst(3);
        // dLL.addFirst(2);
        // dLL.addFirst(1);
        // dLL.removeLast();
        dLL.reverseDLL();
        dLL.printDLL();
    }
}
