import java.util.LinkedList;
import java.util.Queue;

public class MyStack {
    //两个队列实现栈
    public Queue<Integer> queue1 = new LinkedList<>();
    public Queue<Integer> queue2 = new LinkedList<>();

    public MyStack(){

    }

    public void push(int x){
        if(!queue1.isEmpty()){
            queue1.offer(x);
        }else if(!queue2.isEmpty()){
            queue2.offer(x);
        }else {
            queue1.offer(x);
        }
    }

    public int pop(){
        if(!queue1.isEmpty()){
            int size1 = queue1.size();
            int tmp = 0;
            for (int i = 0; i < size1-1; i++) {
                tmp = queue1.poll();
                queue2.offer(tmp);
            }
            return queue1.poll();
        }
        if(!queue2.isEmpty()) {
            int size2 = queue2.size();
            int tmp = 0;
            for (int i = 0; i < size2 - 1; i++) {
                tmp = queue2.poll();
                queue1.offer(tmp);
            }
            return queue2.poll();
        }
        return -1;
    }

    public int top(){
        if(!queue1.isEmpty()){
            int size1 = queue1.size();
            int tmp = 0;
            for (int i = 0; i < size1; i++) {
                tmp = queue1.poll();
                queue2.offer(tmp);
            }
            return tmp;
        }
        if(!queue2.isEmpty()) {
            int size2 = queue2.size();
            int tmp = 0;
            for (int i = 0; i < size2; i++) {
                tmp = queue2.poll();
                queue1.offer(tmp);
            }
            return tmp;
        }
        return -1;
    }

    public boolean empty(){
        if(queue1.isEmpty() && queue2.isEmpty()){
            return true;
        }
        return false;
    }
}
