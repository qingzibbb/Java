public class Test {
    public static void main(String[] args) {
        StringBuffer stringBuffer = new StringBuffer();

    }
    public static void main1(String[] args) {
        StringBuilder sb = new StringBuilder("abcd");
        System.out.println(sb);
        sb.append("java");
        //字符串拼接，不会产生新对象，直接在原来对象上修改
        System.out.println(sb);//abcdjava
    }
    public static void main2(String[] args) {
        /*String str = "abc";
        String str2 = str+"def";
        //String的拼接底层会优化为StringBuilder
        System.out.println(str2);*/

        String str = "abc";
        StringBuilder sb = new StringBuilder("abc");
        sb.append(str);
        sb.append("def");
        String str2 = sb.toString();
        System.out.println(str2);
    }
}
