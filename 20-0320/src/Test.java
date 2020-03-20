import java.io.File;

public class Test {
    public static void main(String[] args) {
        String path = "E:\\javacode\\我是一个文件.txt";
        File file = new File(path);
        System.out.println(file);

        String parent = "E:\\javacode" ;
        String path2 = "我不是一个文件.txt";
        File file1 = new File(parent,path2);
        System.out.println(file1);
        System.out.println(file1.exists());
    }
}
