import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int count = 0;
        if(s.length()<=1){
            System.out.println(count);
        }else{
            for (int i = 0; i < s.length(); i++) {
                for (int j = i+2; j <= s.length(); j++) {
                    String str = s.substring(i,j);
                    int ret = isHuiWen(str);
                    if(ret==1){
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }

    private static int isHuiWen(String str) {
        StringBuilder sb = new StringBuilder(str);
        sb.reverse();
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i)==sb.charAt(i)){
                count++;
            }
        }
        if(count==str.length()){
            return 1;
        }else {
            return 0;
        }
    }

}
