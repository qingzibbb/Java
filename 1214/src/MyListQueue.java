public class MyListQueue {
    static class Node{
        public int data;
        public Node next;
        public Node(int data){
            this.data = data;
        }
    }
    public Node front;
    public Node rear;
    public int usedSize;

    private boolean isEmpty(){
        return usedSize == 0;
    }
    //入队
    public void offer(int data){
        Node node = new Node(data);
        if(isEmpty()){
            this.front = node;
            this.rear = node;
        }else {
            this.rear.next = node;
            this.rear = this.rear.next;
        }
        this.usedSize++;
    }

    //出队
    public int poll(){
        if(isEmpty()){
            throw new UnsupportedOperationException("操作异常");
        }
        int val = this.front.data;
        this.front = this.front.next;
        this.usedSize--;
        return val;
    }

    //返回栈头元素
    public int peek(){
        if(isEmpty()){
            throw new UnsupportedOperationException("操作异常");
        }
        return this.front.data;
    }
}
