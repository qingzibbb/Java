import java.util.Stack;

public class Solution {

    Stack<Integer> data = new Stack<Integer>();
    Stack<Integer> min = new Stack<Integer>();
    Integer tmp = null;
    public void push(int node) {
        if(tmp!=null){
            if(tmp<=node){
                data.push(node);
            }else{
                tmp = node;
                data.push(node);
                min.push(node);
            }
        }else{
            tmp = node;
            data.push(node);
            min.push(node);
        }
    }
    
    public void pop() {
        int num1 = data.pop();
        int num2 = min.pop();
        if(num1!=num2){
            min.push(num2);
        }
    }
    
    public int top() {
        int num = data.pop();
        data.push(num);
        return num;
    }
    
    public int min() {
        int num = min.pop();
        min.push(num);
        return num;
    }
}