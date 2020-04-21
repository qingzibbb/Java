public class 线程不安全 {
    static long n = 0;
    static final long COUNT = 100000000L;
    static class 小权 extends Thread{
        @Override
        public void run() {
            for (int i = 0; i < COUNT; i++) {
                n++;
            }
        }
    }

    static class 小晴 extends Thread{
        @Override
        public void run() {
            for (int i = 0; i < COUNT; i++) {
                n--;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        小权 czxq = new 小权();
        小晴 kaxq = new 小晴();
        czxq.start();
        kaxq.start();

        czxq.join();
        kaxq.join();

        System.out.println(n);
    }
}
