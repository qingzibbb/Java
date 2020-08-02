import java.util.Arrays;

public class MyArrayList {
    public int[] elem;
    public int usedSize;
    public static final int capacity = 10;//初始容量
    //初始化
    public MyArrayList(){
        this.elem = new int[capacity];
        this.usedSize = 0;
    }

    //打印顺序表
    public void display(){
        for (int i = 0; i < usedSize; i++) {
            System.out.print(elem[i]+" ");
        }

    }

    private boolean isFull(){
        /*if(this.usedSize==this.elem.length) return true;
        return false;*/
        return this.usedSize==this.elem.length;
    }

    //在pos位置新增元素
    public void add(int pos,int data){
        //已满，数组二倍扩容
        if(isFull()){
            this.elem = Arrays.copyOf(this.elem,2*this.elem.length);
        }
        if(pos<0||pos>this.usedSize) return;
        for (int i = this.usedSize-1; i >= pos; i--) {
            this.elem[i+1] = this.elem[i];
        }
        this.elem[pos] = data;
        this.usedSize++;
    }
    public boolean contains(int toFind){
        for (int i = 0; i < this.usedSize; i++) {
            if(this.elem[i] == toFind){
                return true;
            }
        }
        return false;
    }

    public int search(int toFind){
        for (int i = 0; i < this.usedSize; i++) {
            if(this.elem[i] == toFind){
                return i;
            }
        }
        return -1;
    }

    private boolean isEmpty(){
        if(usedSize==0) return true;
        return false;
    }
    public int getPos(int pos){
        if(isEmpty()){
            throw new RuntimeException("顺序表为空");
        }
        if(pos<0||pos>=this.usedSize) return -1;
        return this.elem[pos];
    }

    public int size(){
        return this.usedSize;
    }

    public void remove(int toRemove){
        int index = search(toRemove);
        if(index==-1){
            System.out.println("没有需要删除数字");
            return;
        }
        for (int i = index; i <usedSize-1; i++) {
            this.elem[i] = this.elem[i+1];
        }
        this.usedSize--;
    }

    public void clear(){
        this.usedSize=0;
    }

}
