public class 线程状态的变化 {
    static class MyThread extends Thread{
        @Override
        public void run() {
            for (long i = 0; i < 10000000000L; i++) {
                
            }
        }
    }
    public static void main(String[] args) throws InterruptedException {
        /*MyThread t = new MyThread();
        System.out.println(t.getState());  //状态new
        t.start();
        System.out.println(t.getState());  //runnable
        while (t.isAlive());   //只要线程活着一直循环
        System.out.println(t.getState());  //terminated*/


        /*MyThread2 t = new MyThread2();
        t.start();
        //还是runnable，因为大概率，t还没抢到CPU
        System.out.println(t.getState());
        Thread.sleep(1000);//主线程放弃CPU，使得t大概率能抢到CPU
        System.out.println(t.getState());*/


        Thread xq = new 小权();
        Thread zxq = new 猪小权();
        xq.start();
        zxq.start();
    }

    static class 小权 extends Thread{
        @Override
        public void run() {
            while (true){
                System.out.println("小权气呼呼");
                //Thread.yield();//执行状态-》就绪状态  猪小权就会变多
            }
        }
    }

    static class 猪小权 extends Thread{
        @Override
        public void run() {
            while (true){
                System.out.println("小权是臭猪");
            }
        }
    }
    static class MyThread2 extends Thread{
        @Override
        public void run() {
            try {
                Thread.sleep(100*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
