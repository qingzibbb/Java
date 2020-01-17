public class TestDemo {
    public static void main(String[] args) {
        String str = "bjyx";
        str = str +"szd";
        str += "!!";
        System.out.println(str);

    }
    public static void main3(String[] args) {
        String str1 = "bjyx";//直接赋值
        String str2 = new String("bjyx").intern();
        System.out.println(str1 == str2);//true
    }
    public static void main2(String[] args) {
        String str1 = "bjyxszd";//直接赋值
        String str2 = new String("bjyxszd");
        String str3 = "bjyx"+"szd";
        String str4 = "bjyx"+new String("szd");
        String str5 = "bjyx";
        String str6 = "szd";
        String str7 = str5+str6;
        String str8 = str5+new String("szd");
        System.out.println(str1 == str2);//false
        System.out.println(str1 == str3);
        System.out.println(str1 == str4);
        System.out.println(str1 == str7);
        System.out.println(str1 == str8);
    }
    public static void main1(String[] args) {
        String str1 = "bjyx";//直接赋值
        String str2 = new String("bjyx");//系统建议str1
        char[] array = {'b','j','y','x'};
        String str3 = new String(array);
        System.out.println(str1);
        System.out.println(str2);
        System.out.println(str3);
    }
}
