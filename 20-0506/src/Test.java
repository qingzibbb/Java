public class Test {
    private static long n = 0;
    private static long count = 10000000;
    static Object 利用这个引用指向的对象作为锁 = new Object();

    static class Adder extends Thread{
        @Override
        public void run() {
            for (int i = 0; i < count; i++) {
                synchronized (利用这个引用指向的对象作为锁){
                    n++;
                }

            }
        }
    }
    static class Subber extends Thread{
        @Override
        public void run() {
            for (int i = 0; i < count; i++) {
                synchronized (利用这个引用指向的对象作为锁){
                    n--;
                }
            }
        }
    }
    public static void main(String[] args) throws InterruptedException {
        Adder adder = new Adder();
        Subber subber = new Subber();
        adder.start();
        subber.start();
        adder.join();
        subber.join();
        System.out.println(n);
    }
}
