import java.util.*;

public class Main{
    public static void main(String[] agrs){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int max = 0;
        int tmp = 0;
        int end = 0;
        int endtmp = 0;
        String n = null;
        for(int i = 0;i<s.length();i++){
            while(i<s.length()&&s.charAt(i)>='0'&&s.charAt(i)<='9'){
                endtmp = i;
                tmp++;
                i++;
            }
            if(tmp>max){
                max = tmp;
                end = endtmp;
            }

            tmp = 0;
        }
        System.out.println(s.substring(end-max+1,end+1));
    }
}
