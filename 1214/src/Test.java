import java.util.Stack;

public class Test {
    public static void main(String[] args) {
        MyListQueue myListQueue = new MyListQueue();
        myListQueue.offer(1);
        myListQueue.offer(2);
        myListQueue.offer(3);
        System.out.println(myListQueue.poll());
        System.out.println(myListQueue.peek());
    }
    public static void main1(String[] args) {
        MyStack<Integer> myStack = new MyStack<>();
        myStack.push(10);
        myStack.push(20);
        myStack.push(30);
        myStack.push(40);
        System.out.println(myStack.pop());//40
        System.out.println(myStack.getTop());//30

        MyStack<String> myStack2 = new MyStack<>();
        myStack2.push("java");
        myStack2.push("bjyx");
        myStack2.push("szd");
        myStack2.push("zzz");
        System.out.println(myStack2.pop());//40
        System.out.println(myStack2.getTop());//30

        //库里的栈
        Stack<Integer> stack3 = new Stack<>();
    }
}
