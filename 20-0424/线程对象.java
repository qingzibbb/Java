public class 线程对象 {
    public static class MyThread extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println(i);
            }
        }
    }
    private static class MuRunnable implements Runnable {

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
        a.join(); //主线程放弃CPU 直到A结束前  不再抢CPU
                  //主线程会堵塞在这，直到a 执行完成
        Thread b = new Thread(new MuRunnable());
        b.start();
        b.join();
        System.out.println("b结束");

        Runnable target = new MyThread();
        Thread c = new Thread(target);
        c.start();
        c.join();
    }

    private static void 使用匿名类创建对象(){
        //等同于直接创建线程对象
        Thread a = new Thread(){
            @Override
            public void run() {

            }
        };

        Thread b = new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });
    }
}
