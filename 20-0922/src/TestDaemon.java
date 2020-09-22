public class TestDaemon {
    public static void main(String[] args) {
        God god = new God();
        You you = new You();
        Thread thread = new Thread(god);
        thread.setDaemon(true);//默认false，用户线程

        thread.start();

        new Thread(you).start();
    }
}
//上帝
class God implements Runnable{

    @Override
    public void run() {
        while (true){
            System.out.println("守护我");
        }
    }
}
//
class You implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 36500; i++) {
            System.out.println("活着");
        }
        System.out.println("goodbye");
    }
}