public class 属性 {
    private static void printFields(){
        Thread t = Thread.currentThread();
        System.out.println(t.getId());
        System.out.println(t.getName());
        System.out.println(t.getState());
        System.out.println(t.getPriority());
        System.out.println(t.isDaemon());
        System.out.println(t.isAlive());
        System.out.println(t.isInterrupted());
    }

    public static void main(String[] args) {
        Thread.currentThread().setName("小权是个猪");
        Thread t = new Thread(() -> {
            printFields();
            try {
                //主动放弃CPU10000000毫秒
                Thread.sleep(10000000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t.setName("小权宝贝");
        t.start();

        printFields();
    }
}
