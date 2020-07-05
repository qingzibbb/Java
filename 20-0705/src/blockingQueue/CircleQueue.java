package blockingQueue;

public class CircleQueue {
    private static final int CAPACITY = 16;
    private int[] queue = new int[CAPACITY];
    private int size = 0;
    private int frontIndex = 0;
    private int rearIndex = 0;

    //放入队列
    public synchronized void put(int element) throws InterruptedException {
        //判断队列是否已满
        if(size == queue.length){
            this.wait();
            //throw new RuntimeException("队列已满");
        }

        //队列中还有空间
        queue[rearIndex] = element;
        rearIndex = rearIndex+1;
        if(rearIndex>=queue.length){
            rearIndex = 0;
        }
        size++;
        notify();
    }

    //从队列中取出
    public synchronized int take() throws InterruptedException {
        //判断队列是否为空
        if(size ==0){
            this.wait();
            // throw new RuntimeException("队列为空");
        }
            //不为空
            int element  = queue[frontIndex];
            frontIndex += 1;
            if(frontIndex == queue.length){
                frontIndex = 0;
            }
        size--;
        return element;
    }
}
