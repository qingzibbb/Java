/*
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            list.add(scanner.nextLine());
        }
        String flagTmp = list.get(list.size()-2);
        int flag = Integer.parseInt(flagTmp);
        List<String> list1 = new ArrayList<>();
        for (int i = 0; i < list.size()-2; i++) {
            String str = find(list.get(i),flag);
            list1.add(str);
        }
        String s = find(list.get(list.size()-1),flag);
        for (int i = 0; i < list1.size(); i++) {
            String tmp = list1.get(i);
            if(tmp.contains(s)) {
                System.out.println(list.get(i));
            }
        }
    }
    public static String find(String str,int flag){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i)-'0'<flag){
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }
}
*/

import java.util.Scanner;

public class Test{
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        String s = sc.nextLine();
        String[] arr = s.split(";");

        String[] a1 = arr[0].split(" ");
        String[] a2 = arr[1].split(" ");
        int m=0;
        int n=a1.length;
        for (int i = 0; i < a1.length; i++) {
            String s1 = String.valueOf(a1[i]);
            String s2 = String.valueOf(a2[i]);
            if(!s1.equals(s2)){
                m++;
            }
        }
        System.out.println("("+m+","+n+")");
    }
}