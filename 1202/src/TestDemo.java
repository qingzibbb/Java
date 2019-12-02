import java.util.Arrays;
import java.util.*;
public class TestDemo {
    //输入3，abcdef  =>  defabc
    public static String reverseStr(String str,int start,int end){
        char[] arr = str.toCharArray();
        while (start<end){
            char tmp = arr[start];
            arr[start] = arr[end];
            arr[end] = tmp;
            start++;
            end--;
        }
        String string = new String(arr);
        return string;
    }
    public static String func(String str,int k){
        if(str == null||k <= 0 || str.length() == 0){
            return null;
        }
        String str2 = reverseStr(str,0,k-1);
        str2 = reverseStr(str2,k,str.length()-1);
        str2 = reverseStr(str2,0,str2.length()-1);
        return str2;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        String str = scanner.next();//不能用nextLine
        String ret = func(str,k);
        System.out.println(ret);
    }
    //逆序字符串

    /*public static String reverseStr(String str){
        char[] arr = str.toCharArray();
        int left = 0;
        int right = arr.length-1;
        while (left<right){
            char tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;
            left++;
            right--;
        }
        String string = new String(arr);
        return string;
    }
    public static void main11(String[] args) {
        String str = "abcde";
        String str2 = reverseStr(str);
        System.out.println(str2);
    }*/
    public static void main10(String[] args) {
        String str = "bjyxszd";
        System.out.println(str.toUpperCase());//BJYXSZD
        String str1 = "BJYXSZD";
        System.out.println(str1.toLowerCase());//bjyxszd
        System.out.println(str.concat(str1));//bjyxszdBJYXSZD
        String str2 = "";
        System.out.println(str2.isEmpty());//true
        System.out.println(str.substring(3));//xszd
        System.out.println(str.substring(3,6));
        //xsz，[3,6)
    }
    //输入字符串，并无冗余拼接字符串 bjyx szd  =>  bjyxszd
    public static String func(String str){
        String[] strs = str.split(" ");
        String ret = "";
        for(String str1 : strs){
            ret += str1;
        }
        return ret;
    }
    public static void main9(String[] args){
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        String ret = func(str);
        System.out.println(ret);
    }
    public static void main8(String[] args) {
        String str = "bjyx#szd#!!";
        String[] strings1 = str.split("#");//以#拆分字符串
        System.out.println(Arrays.toString(strings1));//[bjyx, szd，!!]

        //先以“ ”分割，再以“，”分割
        String str2 = "a,bc ab,c b,a";
        String[] strings2 = str2.split(" ");
        System.out.println(Arrays.toString(strings2));
        //[a,bc, ab,c, b,a]
        for (int i = 0; i < strings2.length; i++) {
            String[] strings3 = strings2[i].split(",");
            System.out.println(Arrays.toString(strings3));
        }//[a, bc] [ab, c] [b, a]

        String str3 = "bj yx szd";
        String[] strings = str3.split(" ",2);
        System.out.println(Arrays.toString(strings));
        //[bj, yx szd],以“ ”划分，最多分2组
        String str4 = "192.168.1.1";
        String[] strings3 = str4.split("\\.");
        System.out.println(Arrays.toString(strings3));//[192, 168, 1, 1]
    }
    public static void main7(String[] args) {
        String str = "bjyxszd";//主串
        System.out.println(str.contains("bjyx"));
        //true，底层调用indexOf

        System.out.println(str.indexOf("szd"));
        //查找子串，返回下标--4
        System.out.println(str.indexOf("szd",3));
        //从3号位置开始找--4

        System.out.println(str.lastIndexOf("yx"));
        //从后往前找，字符串还是正着看
        System.out.println(str.lastIndexOf("yx",6));
        //从6号位置开始从后往前找

        System.out.println(str.startsWith("bjyx"));
        //true,查找str是否以bjyx开头
        System.out.println(str.startsWith("b",2));
        //false,判断2号位置是否以b开头
        System.out.println(str.endsWith("zd"));
        //true,是否以zd结尾

        String str2 = "  bjyx  szd  ";
        System.out.println(str2.trim());
        //bjyx  szd，去掉字符串首尾的空格，中间的空格保留
        String str3 = "abccbab";
        System.out.println(str3.replace('a','d'));
        //dbccbd，是一个新对象
        System.out.println(str3.replace("ab","#"));
        System.out.println(str3.replaceAll("ab","#"));
        //#ccb#

        System.out.println(str3.replaceFirst("ab","*"));
        //*ccbab
    }
    public static void main6(String[] args) {
        String str1 = "Hello";
        String str2 = "hello";
        System.out.println(str1.equals(str2));//false
        System.out.println(str1.equalsIgnoreCase(str2));//true
        System.out.println(str1.compareTo(str2));//>0  =0  <0
        //-32   ASCII表 H与h相差32
    }
    public static void main5(String[] args) {
        String str = "abcd";
        byte[] bytes = str.getBytes();
        System.out.println(Arrays.toString(bytes));//[97,98,99,100]
    }
    public static void main4(String[] args) {
        byte[] bytes = {97,98,99,100};
        //String str = new String(bytes);
        String str = new String(bytes,1,2);
        System.out.println(str);//bc
    }
    //判断字符串是否全部由数字组成
    public static boolean isNumber(String str){
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) > '9'||str.charAt(i) < '0'){
                return false;
            }
        }
        return true;
    }
    public static void main3(String[] args) {
        String str = "bjyxszd1314";
        boolean a = isNumber(str);
        System.out.println(a);
    }
    public static void main2(String[] args) {
        char[] array = {'b','j','y','x'};
        String str1 = new String(array);
        System.out.println(str1);//bjyx
        String str2 = new String(array,1,2);
        System.out.println(str2);//jy
        char ch = str1.charAt(0);
        System.out.println(ch);//b
    }
    public static void main1(String[] args) {
        String str = "bjyx";
        char[] arr = str.toCharArray();
        System.out.println(Arrays.toString(arr));//[b,j,y,x]
    }
}
