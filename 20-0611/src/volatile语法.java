import java.util.Scanner;

public class volatile语法 {
    /*//修饰变量
    volatile int a;
    static volatile int b;*/

    static volatile boolean flag = true;
    static class MyThread extends Thread {
        @Override
        public void run() {
            int n = 0;
            while(flag){
                n++;
            }
            System.out.println(n);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyThread t = new MyThread();
        t.start();
        //子线程死循环
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入，让线程停止");
        sc.nextLine();
        //通过输入结束子线程  区别有无用volatile 修饰，子线程中的flag有无被修改
        flag = false;
        //确保子线程结束
        Thread.sleep(5*1000);
        //查看是否结束
        System.out.println(t.isAlive());
    }
}
