import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = sum(n);
        System.out.println(sum);
    }

    private static int sum(int n) {
        int ret = 0;
        if(n==1||n==2||n==3){
            return 1;
        }else {
            for (int i = 2; i <=n/2 ; i++) {
                if(n%i==0){
                    n = n/i;
                    i = 2;
                    ret++;
                }
            }
        }
        return ret;
    }
}
