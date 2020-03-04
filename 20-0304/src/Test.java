
import java.util.Scanner;
import java.util.Stack;

public class Test {
    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int i = 0;
        int max = 0;
        int maxi = 0;
        int flag = 0;
        while (i<s.length()){
            while (i<s.length()&&(s.charAt(i)<='0'||s.charAt(i)>='9')){
                i++;
            }
            int count = 0;
            flag = i;
            while (i<s.length()&&(s.charAt(i)>='0'&&s.charAt(i)<='9')){
                i++;
                count++;
            }
            if(count>max){
                maxi = flag;
                max = count;
            }
        }
        StringBuilder sb = new StringBuilder();
        while (s.charAt(maxi)>='0'&&s.charAt(maxi)<='9'){
            sb.append(s.charAt(maxi));
            maxi++;
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String A = sc.nextLine();
        boolean b = chkParenthesis(A,A.length());
        System.out.println(b);
    }
    public static boolean chkParenthesis(String A, int n) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            if(A.isEmpty()){
                return true;
            }
            if(A.charAt(i)=='('){
                stack.push(A.charAt(i));
            } else if (A.charAt(i)==')') {
                if(stack.peek()=='('){
                    stack.pop();
                }else {
                    return false;
                }
            } else {
                return false;
            }
        }
        if(stack.empty()){
            return true;
        }
        return false;
    }
}
