import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        s = s.toLowerCase();
        String[] bbb = s.split(" ");
        HashMap<String,Integer> map = new HashMap<>();
        for (String a:bbb) {
            if(!map.containsKey(a)){
                map.put(a,1);
            }else {
                int tmp = map.get(a)+1;
                map.put(a,tmp);
            }
        }
        int max = 0;
        String maxVal = "";
        for (Map.Entry<String,Integer> entry:map.entrySet()){
            if(entry.getValue()>max){
                max = entry.getValue();
                maxVal = entry.getKey();
            }
        }
        System.out.println(maxVal+" "+max);
    }
}
