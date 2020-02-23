import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Test {
    public static void main(String[] args) {
            Scanner scan = new Scanner(System.in);
            String str = null;
            Set<String> set = new HashSet<>();
            while(scan.hasNext()){
                str = scan.nextLine();
                String[] str2 = str.split(" ");
                for(String s:str2){
                    set.add(str);
                }
            }
        System.out.println(set.size());
    }

}
