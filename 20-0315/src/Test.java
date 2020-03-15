import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        int[] arr = new int[10];
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            arr[c-'0']++;
        }
        for (int i = 0; i < 10; i++) {
            if(arr[i]!=0){
                System.out.println(i+":"+arr[i]);
            }
        }
    }
}
