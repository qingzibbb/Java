public class 线程的属性 {
    private static void printCurrentThread(){
        Thread t = Thread.currentThread();
        System.out.println(t.getName());
    }
    public static void main(String[] args) {
        //printCurrentThread();  //打印main
        Thread t = new Thread(() -> {  //打印Thread-0
            printCurrentThread();
        });
        t.start();
    }
}
