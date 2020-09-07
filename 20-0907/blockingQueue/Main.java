package blockingQueue;

import java.util.Scanner;

public class Main {
    private static CircleQueue queue = new CircleQueue();

    private static class 生产者 extends Thread{

        @Override
        public void run() {
            Scanner sc = new Scanner(System.in);
            try {
                while (true){
                    System.out.println("请输入下一个数字：");
                    int element = sc.nextInt();
                    queue.put(element);
                }
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
