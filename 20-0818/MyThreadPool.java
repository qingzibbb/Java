import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class MyThreadPool {
    private int nThreads;//记录允许创建的最大线程数
    private List<Thread> threads;//保存创建的线程
    private BlockingQueue<Runnable> workQueue;//任务阻塞队列

    private static class Worker extends Thread{
        private BlockingQueue<Runnable> workQueue;

        Worker(BlockingQueue<Runnable> workQueue){
            this.workQueue = workQueue;
        }

        //员工干的事
        @Override
        public void run() {
            while(true){
                try {
                    Runnable target = workQueue.take();//阻塞队列为空时不会返回，有任务时其中一个线程会被唤醒
                    target.run();//执行任务
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    MyThreadPool(int nThreads){
        this.nThreads = nThreads;

        //创建阻塞队列
        workQueue = new LinkedBlockingQueue<>();//所有线程共享一个阻塞队列

        //提交创建线程
        threads  = new ArrayList<>();
        for (int i = 0; i < nThreads; i++) {
            Thread thread = new Worker(workQueue);
            thread.start();
            threads.add(thread);
        }

    }

    //提交任务给队列---生产者
    void execute(Runnable target) throws InterruptedException {
        workQueue.put(target);
    }
}
