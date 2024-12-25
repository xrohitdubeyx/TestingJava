import java.util.Stack;

public class nxtGreater {
    public static void main(String args[]){
        Stack<Integer> s = new Stack<>();
        int arr[] = {6,8,0,1,3};
        int nxtGreaterRight[] = new int[arr.length];

        for(int i=0; i<=arr.length-1; i++){

            while( !s.isEmpty() && arr[s.peek()] >= arr[i]){
                s.pop();
            }

            if( s.isEmpty()){
                nxtGreaterRight[i] = -1;
            }else{
                nxtGreaterRight[i] = arr[s.peek()];
            }

            s.push(i);
        }

        for(int i=0; i<nxtGreaterRight.length; i++){
            System.out.println(nxtGreaterRight[i] + " ");
        }
    }    
}
