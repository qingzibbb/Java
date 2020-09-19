public class TestThread3  implements Runnable{
    //买火车票
    private int ticket = 10;
    @Override
    public void run() {
        while (true){
            if(ticket<=0){
                break;
            }
            //模拟延时
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"拿到第"+ticket--);
        }
    }

    public static void main(String[] args) {
        TestThread3 ticket = new TestThread3();
        new Thread(ticket,"小晴").start();
        new Thread(ticket,"小楠").start();
        new Thread(ticket,"小权").start();

    }
}
