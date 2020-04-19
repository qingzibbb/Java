import java.util.Scanner;

public class 通知线程停止 {
    public static class 写作业 implements Runnable{
        @Override
        public void run() {
            Thread current  = Thread.currentThread();
            while (!current.isInterrupted()){
                System.out.println("小权是一只猪");

                System.out.println("小权是二只猪");

                System.out.println("小权是三只猪");

                System.out.println("小权是四只猪");

                System.out.println("小权是五只猪");

            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new 写作业());
        t.start();

        Scanner sc = new Scanner(System.in);
        sc.nextLine();

        System.out.println("准备通知小权停止");
        t.interrupt();
        System.out.println("已经通知");
        t.join();
        System.out.println("已经停止");
    }
}
