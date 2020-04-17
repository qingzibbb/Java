public class Test {
    private  static  class A extends Thread{
        @Override
        public void run() {
            System.out.println("A");
        }
    }
    private  static  class B extends Thread{
        public void run(){
            System.out.println("B");
        }
    }
    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        b.setPriority(Thread.MAX_PRIORITY);//设置优先级
        a.start();
        b.start();
        System.out.println("main");
    }
}
