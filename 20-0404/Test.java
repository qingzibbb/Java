import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        while(sc.hasNextInt()){
            int n = sc.nextInt();
            int s = n*n;
            int f = 100;
            if(s<100){
                f = 10;
            }
            
                if(s%f==n){
                    System.out.println("Yes!");
                }else{
                    System.out.println("No!");
                }
            
        }
    }
}