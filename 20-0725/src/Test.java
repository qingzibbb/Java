import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc=  new Scanner(System.in);
        String a = sc.nextLine();
        String[] s = a.split("\\.");
        boolean n = isIP(s);
        System.out.println(n);
    }

    private static boolean isIP(String[] s) {
        if(s.length==4){
            for (String str:s) {
                if(Integer.parseInt(str)<0||Integer.parseInt(str)>255){
                    return false;
                }
            }
            return true;
        }else {
            return false;
        }
    }
}
