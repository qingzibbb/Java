import java.sql.Connection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int bbb = sc.nextInt();
        int n = sc.nextInt();
        String s = String.valueOf(bbb);
        if(n>s.length()||s.length()!=8){
            System.out.println("error");
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)<='0'||s.charAt(i)>='9'){
                System.out.println("error");
                return;
            }
        }
        ArrayList<Character> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if(i!=n-1){
                list.add(s.charAt(i));
            }
        }
        Collections.sort(list);
        for (int i = list.size()-1; i >= 0; i--) {
            System.out.print(list.get(i));
        }
        System.out.println();
        /*char[] cf = new char[list.size()];
        for (int i = 0; i <cf.length; i++) {
            cf[i] = list.get(i);
        }
        Arrays.sort(cf);
        for (int i = cf.length-1; i >=0; i--) {
            System.out.print(cf[i]);
        }*/
        /*char[] c = s.toCharArray();
        for (int i = n-1; i < c.length-1; i++) {
            c[i] = c[i+1];
        }
        char[] cf = new char[c.length-1];
        for (int i = 0; i < cf.length; i++) {
            cf[i] = c[i];
        }
        Arrays.sort(cf);
        for (int i = cf.length-1; i >=0; i--) {
            System.out.print(cf[i]);
        }*/
    }
}
