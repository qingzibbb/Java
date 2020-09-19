public class TestThread1 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 2000; i++) {
            System.out.println("我在吃饭");
        }
    }

    public static void main1(String[] args) {

        TestThread1 testThread1 = new TestThread1();
        //开启线程
        testThread1.start();
        //主线程
        for (int i = 0; i < 2000; i++) {
            System.out.println("我在学习");
        }
    }
}
