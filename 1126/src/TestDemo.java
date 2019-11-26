public class TestDemo {
    public static void main(String[] args) {
        String str = "1a23456";
        //char[] array = str.toCharArray();
        boolean a = isNumber(str);
        System.out.println(a);
    }
    //判断字符串是否全部为数字组成
    public static boolean isNumber(String str){
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) < '0' || str.charAt(i) > '9') {
                return false;
            }
        }
        return true;
    }
}
