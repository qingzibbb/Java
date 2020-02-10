public class Test {
    public static void main(String[] args) {
        String name = "abc";
        String typed = "aabcd";
        boolean ret1 = isLongPressedName(name,typed);
        System.out.println(ret1);
    }
    public static boolean isLongPressedName(String name, String typed) {
        int j = 0;
        for (char c:name.toCharArray()) {
            if(j==typed.length()){
                return false;
            }
            if(typed.charAt(j)!= c){
                if(j==0||typed.charAt(j)!= typed.charAt(j-1))return false;
                char cur = typed.charAt(j);
                while (j<typed.length()&&typed.charAt(j)==cur){
                    j++;
                }
                if(j==typed.length()||typed.charAt(j)!=c){
                    return false;
                }
            }
            j++;
        }
        return true;
    }
}
