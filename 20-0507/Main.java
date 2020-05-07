import java.util.*;
public class Main{
    public static void main(String[] arge){
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        String b = sc.nextLine();
        int count = 0;
        for(int i = 0;i<a.length()+1;i++){
            String tmp = a.substring(0,i)+b+a.substring(i,a.length());
            if(isHuiWen(tmp)){
                count++;
            }
        }
        System.out.println(count);
    }
    public static boolean isHuiWen(String s){
        int left = 0;
        int right = s.length()-1;
        while(left<right){
            if(s.charAt(left)!=s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}