import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class MyException extends Exception{
    public MyException(String s){
        super(s);
    }
}
public class Test {
    public static void func() throws MyException {
        int a = 10;
        if (a == 10) {
            throw new MyException("MyException异常");
        }
    }

    public static void main(String[] args) {
        try {
            func();
        } catch (MyException e) {
            e.printStackTrace();
        }
    }

    public static void main3(String[] args) {
        try {
            String str = null;
            str.length();
        }catch (NullPointerException e){
            e.printStackTrace();
        }
    }
    public static void main2(String[] args) {
        int a = 10;
        try {
            if(a==10){
                throw new Exception("异常");
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            System.out.println("finally");
        }
    }
    public static String readFile(){
        //尝试打开文件，并读其中一行
        File file = new File("d:/123.txt");
        try{
            //使用文件对象构造Scanner对象
            Scanner sc = new Scanner(file);
            return sc.nextLine();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
        return null;
    }
    public static void main1(String[] args) {
        System.out.println(readFile());
    }
}
