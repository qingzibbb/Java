public class TestThread2 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 200; i++) {
            System.out.println("aa");
        }
    }

    public static void main2(String[] args) {
        TestThread2 testThread2 = new TestThread2();
        /*Thread thread = new Thread(testThread2);
        thread.start();*/
        new Thread(testThread2).start();
        for (int i = 0; i < 1000; i++) {
            System.out.println("bb");
        }
    }
}
