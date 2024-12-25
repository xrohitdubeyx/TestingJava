import java.util.*;

public class function {
    //function with no paramter
    public static void printName(){
        System.out.println("rohit");
    }

    //function with paramter 
    public static int printSum(int num1, int num2){
        int sum = num1 + num2;
        return sum;
    }
    //function to swap values 
    public static void swap(int s1, int s2){
        int temp = s1;
        s1 = s2;
        s2 = temp;
        System.out.println("s1 is : "+ s1);
        System.out.println("s2 is : " + s2);
    }
    // sum of 2 nums ,, thisis called function overloading
    public static int sum(int a, int b){
        return a+b;
    }
    //sum of 3 nums 
    public static int sum(int a, int b, int c){
        return a+b+c;
    }
    //check prime number 
    public static boolean prime(int n){
        if(n == 2){
            return true;
        }
        for(int i=2;i<n;i++){
            if( n % i == 0){
                return false;
            }
        }
        return true;
    }
    //optimize way to calculate prime 
    public static boolean prime2(int n){
        if(n ==2){
            return true;
        }
        for(int i=2; i<Math.sqrt(n); i++){
            if( n % i == 0){
                return false;
            }
        }
        return true;
    }
    //print prime in range 
    public static void primeRange(int n){
        for(int i=2; i<=n; i++){
            if(prime(i)){
                System.out.print(i + " ");
            }
        }
    }
    //print binary to decimal
    public static void binaryToDecimal(int num){
        int myNum = num;
        int pow = 0;
        int dec = 0;
        
        while(num > 0){
            int lastDigit = num % 10;
            dec = dec + (lastDigit * (int)Math.pow(2, pow));

            pow++;
            num = num/10;
        }
        System.out.println("Binary of "+myNum + " to decimal is "+dec);
    }
    //print decimal to binary
    public static void decToBin(int n){
        int pow = 0;
        int binNum = 0;

        while (n > 0) {
            int rem = n % 2;
            binNum = binNum + (rem * (int)Math.pow(10, pow));
            pow++;
            n=n/2;
        }
        System.out.println("decimal to binary is "+binNum);
    }
    public static void main (String args[]){
        // printName();

        // Scanner sc = new Scanner(System.in);
        // int a = sc.nextInt();
        // int b = sc.nextInt();
        // System.out.println("the sum is : " + printSum(a, b)); // passing arguments in function

        // int s1 = 5;
        // int s2 = 10;
        // swap(s1, s2);

        System.out.println(sum(3,3));
        System.out.println(sum(3,5,9));

        System.out.println(prime(18));
        System.err.println(prime2(3));
        primeRange(100);
        binaryToDecimal(1110);
        decToBin(14);
    }
}

/*
 * Note:- functions in java is always is call by value means if value get changed in the function and you try to print from main function it will return same value 
 */