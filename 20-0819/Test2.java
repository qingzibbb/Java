import java.sql.SQLOutput;

public class Test2 {
    private static class MyThread extends Thread{
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println(i);
            }
        }
    }
    private static class MyRunnable implements Runnable{
        @Override
        public void run() {
            for (int i = 100; i < 110; i++) {
                System.out.println(i);
            }
        }
    }
    public static void main(String[] args) throws InterruptedException {
        Thread a = new MyThread();
        a.start();
        a.join();
        System.out.println("a结束");
        Thread b = new Thread(new MyRunnable());
        b.start();
        b.join();
        System.out.println("b结束");
    }
}


