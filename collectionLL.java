import java.util.LinkedList;

public class collectionLL {
    
    public static void main(String args[]){
        LinkedList<Integer> ll = new LinkedList<>();

        //add 
        ll.addFirst(1);
        ll.addLast(2);
        ll.addLast(3);

        //print ll
        System.out.println(ll);

        ll.removeFirst();
        ll.removeLast();

        System.out.println(ll);
    }
}
