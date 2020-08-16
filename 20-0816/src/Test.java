import java.util.*;

public class Test {
    public static void main(String[] args) {
        /*
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] s = str.split(" ");
        Integer[] arr = new Integer[s.length];
        for (int i = 0; i < s.length; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }
        int len = arr.length/2;
        int[] a = new int[100];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < a.length; j++) {
                if(arr[i]==j){
                    a[j]++;
                }
            }
        }
        int ret = 0;
        for (int i = 0; i < a.length; i++) {
            if(len<=arr[i]){
                ret = i;
            }
        }
        System.out.println(ret);*/
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] book = new int[m];
        int[] reader = new int[n];
        for(int i = 0;i<n;i++){
            reader[i] = in.nextInt();
            book[reader[i]]++;
        }
        for(int i = 0;i<n;i++){
            if(book[reader[i]] == 1){
                System.out.println("BeiJu");
            }else{
                System.out.println(book[reader[i]]-1);
            }
        }
    }
}
