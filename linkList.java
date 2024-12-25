public class linkList {
    public static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    // adding element to a linklist in start 
    public void addFirst(int data){
        //create a new node
        Node newNode = new Node(data);
        size++;
        // this condition means if there no node 
        if( head == null ){
            head = tail = newNode;
            return;
        }

        // newNode will point to next 
        newNode.next = head;

        // newNode will be the head 
        head = newNode;
    }

    // adding element to a linklist in end 
    public void addLast(int data){
        Node newNode = new Node(data);
        size++;
        if(head == null){
            // in LL if head is null, we assume LL is empty 
            head = tail = newNode;
            return;
        }

        tail.next = newNode;
        tail = newNode;
    }

    // print a linkList
    public void printLL(){
        Node temp = head;
        while( temp != null){
            System.out.print(temp.data+ "->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // adding element to a linklist in middle 
    public void addMiddle(int idx, int data){
        if(idx == 0){
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        size++;
        Node temp = head;
        int i = 0;

        while( i < idx-1){
            temp = temp.next;
            i++;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }

    // remove element to a linklist in start 
    public int removeFirst(){
        if(size == 0){
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        }else if(size == 1){
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        int val = head.data;
        head = head.next;
        size--;
        return val;
    }

    // remove element to a linklist in end 
    public int removeLast(){
        if(size == 0){
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        }else if(size == 1){
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        // to get prev of tail
        Node prev = head;
        for(int i=0; i<size-2; i++){
            prev = prev.next;
        }
        int val = prev.next.data; // nothig but tail;
        prev.next = null;
        tail = prev;
        size--;
        return val;
    }

    // linear search in Linklist
    public int itrSearch(int key){
        Node temp = head;
        int i = 0;
        while( temp != null){
            if(temp.data == key){
                return i;
            }

            temp = temp.next;
            i++;
        }
        return -1;
    }

    public int helper(Node head, int key){
        if(head == null){
            return -1;
        }

        if(head.data == key){
            return 0;
        }

        int idx = helper(head.next, key);
        if(idx == -1){
            return -1;
        }else{
            return idx +1;
        }

    }
    // search using recursion
    public int recursiveSearch(int key){
        return helper(head, key);
    }

    // reverse a linklist 
    public void reverse(){
        Node prev = null;
        Node curr = tail = head;
        Node next;

        while (curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    // delete Nth node from LL
    public void deleteK(int n){
        //size of LL
        int sz = 0;
        Node temp = head;
        while( temp != null){
            temp = temp.next;
            sz++;
        }

        //if delete head 
        if( n == sz){
            head = head.next;
            return;
        }

        // to delete Nth
        int i =1;
        int iToFind = sz-n;
        Node prev = head;
        while( i < iToFind){
            prev = prev.next;
            i++;
        }
        prev.next = prev.next.next;
        return;
    }

    public Node findMid(Node head){
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public boolean checkPalindrome(){
        //edge case , if only single or No node available
        if(head == null || head.next == null){
            return true;
        }
        // find middle
        Node midNode = findMid(head);

        // reverse linklist 
        Node prev = null;
        Node curr = midNode;
        Node next;
        while( curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node right = prev;
        Node left = head;

        // compare left and right LL 
        while( right != null){
            if(left.data != right.data){
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }

    //detect cycle in a LL , Floyd's Algorithm
    public static boolean isCycle(){
        Node slow = head, fast = head;
        while( fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if( slow == fast ){
                return true;
            }
        }
        return false;
    }

    // remove the cycle from ll
    public static void removeCycle(){
        Node slow = head, fast = head;
        boolean cycle = false;
        while ( fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if( slow == fast){
                cycle = true;
                break;
            }
        }
        if( cycle == false){
            return;
        }

        slow = head;
        Node prev = null;
        while ( slow != fast ){
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }

        prev.next = null; // making the last node points to null 
    }
    
    public Node getMid(Node head){
        Node slow = head;
        Node fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public Node merge(Node head1, Node head2){
        Node mergeLL = new Node(-1);
        Node temp = mergeLL;

        while( head1 != null && head2 != null){
            if(head1.data <= head2.data){
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;
            }else{
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }
        }

        while( head1 != null){
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }

        while ( head2 != null ){
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }

        return mergeLL.next;
    }
    public Node mergeSort(Node head){

        //base case 
        if( head == null || head.next == null){
            return head;
        }
        //find mid
        Node mid = getMid(head);
        // left and right MS
        Node rightHead = mid.next;
        mid.next = null;
        Node newLeft = mergeSort(head);
        Node newRight = mergeSort(rightHead);

        return merge(newLeft, newRight);

    }

    public void zigZag(){
        //find mid 
        Node slow = head;
        Node fast = head.next;
        while(fast != null && fast.next != null ){
            slow = slow.next;
            fast = fast.next.next;
        }
        Node mid = slow;

        //reverse 2nd half
        Node curr = mid.next;
        mid.next = null;

        Node prev = null;
        Node next;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node left = head;
        Node right = prev;
        Node nextL, nextR;

        while(left != null && right != null){
            nextL = left.next;
            left.next = right;
            nextR = right.next;
            right.next = nextL;

            //update
            left = nextL;
            right = nextR;
        }
    }
    public static void main(String args[]){
        linkList ll = new linkList();
        // ll.addFirst(2);
        // ll.addFirst(1);
        // ll.addLast(2);
        // ll.addLast(1);
        // ll.addMiddle(2, 77);
        // ll.printLL();
        // System.out.println("size of LL is "+ll.size);
        // System.out.println("removed first node from LL " + ll.removeFirst());
        // ll.printLL();
        // System.out.println(" removed last from LL "+ll.removeLast());
        // ll.printLL();
        // System.out.println("size of LL is "+ll.size);
        // System.out.println(ll.itrSearch(3));
        // System.out.println(ll.recursiveSearch(30));
        // ll.reverse();
        // ll.printLL();
        // ll.deleteK(2);
        // ll.printLL();
        // System.out.println(ll.checkPalindrome());

        // testing for flyod's algo 
        // head = new Node(1);
        // head.next = new Node(2);
        // head.next.next = new Node(3);
        // head.next.next = head;
        // System.out.println(isCycle());

        // testing for cycle in a loop and remove it 
        // head = new Node(5);
        // Node temp = new Node(3);
        // head.next = temp;
        // head.next.next = new Node(7);
        // head.next.next.next = temp;

        // System.out.println(isCycle());
        // removeCycle(); 
        // System.out.println(isCycle());

        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);
        ll.addLast(6);

        ll.printLL();
        ll.zigZag();
        // ll.head = ll.mergeSort(ll.head);
        ll.printLL();

    }
}
