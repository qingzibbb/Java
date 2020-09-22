public class UnsafeBuyLicket {
    public static void main(String[] args) {
        BuyTicket station = new BuyTicket();
        new Thread(station,"我").start();
        new Thread(station,"你").start();
        new Thread(station,"黄牛").start();
    }

}
class BuyTicket implements Runnable{
    //票
    private int ticketNums = 10;
    boolean flag = true;
    @Override
    public void run() {
        //买票
        while (flag){
            buy();
        }
    }
    private void buy(){
        //判断是否有票
        if(ticketNums<0){
            flag = false;
            return;
        }

        //模拟延时
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"拿到"+ticketNums--);

    }
}
