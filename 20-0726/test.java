import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int end = 0;
        int len = 0;
        int max = 0;
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i)>='1'&&s.charAt(i)<='9'){
                len++;
                if(len>max){
                    max = len;
                    end = i;
                }
            }
            else{
                len = 0;
            }
        }
        System.out.println(s.substring(end-max+1,end+1));
    }
}