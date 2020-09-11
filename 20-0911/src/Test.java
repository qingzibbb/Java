import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s= sc.nextLine();
        String ret = func(s);
        System.out.println(ret);
    }

    private static String func(String s) {
        if(s.length()<8) {
            return "Irregular password";
        }
        int[] arr = new int[4];
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)>'0'&&s.charAt(i)<'9'){
                arr[0]++;
            }
            if(s.charAt(i)>='a'&&s.charAt(i)<'z'){
                arr[1]++;
            }
            if(s.charAt(i)>'A'&&s.charAt(i)<'Z'){
                arr[2]++;
            }
            if(s.charAt(i)>'['&&s.charAt(i)<'`'){
                arr[3]++;
            }
        }
        if(arr[0]>0&&arr[1]>0&&arr[2]>0&&arr[3]>0){
            return "Ok";
        }else {
            return "Irregular password";
        }
    }

}
