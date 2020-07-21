//年会抽奖
import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()){
            int n = sc.nextInt();
            double sum1 = jieCheng(n);
            double sum2 = cuoPai(n);
            double result = (sum2/sum1)*100;
            System.out.println(String.format("%.2f",result)+"%");
        }
    }
    
    public static double jieCheng(int n){
        if(n ==1||n==0){
            return 1;
        }
        return n*jieCheng(n-1);
    }
    
    public static double cuoPai(int n){
        if(n==1){
            return 0;
        }
        if(n==2){
            return 1;
        }
        return (n-1)*(cuoPai(n-1)+cuoPai(n-2));
    }
}