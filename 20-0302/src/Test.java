import java.util.Arrays;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String A = in.nextLine();
        String B = in.nextLine();
        int count  = 0;
        for (int i = 0; i < A.length(); i++) {
            huiwen()
        }
        System.out.println(count);
    }
    public static int huiwen(String A,String B){
        if(A.isEmpty()){
            return B.length();
        }
        char[] arr = A.toCharArray();
        int left = 0;
        int right  = arr.length;
        for (int i = 0; i < arr.length; i++) {
            
        }
    }
}
