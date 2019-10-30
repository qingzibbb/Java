import java.util.Arrays;

class MyArrayList {
    private int[] elem;
    private int usedSize;//有效数据
    private final int CAPACITY = 10;//初始容量
    public MyArrayList(){
        this.elem = new int[CAPACITY];
        this.usedSize = 0;
    }
    //打印顺序表
    public void dispaly(){
        for (int i = 0; i < this.usedSize; i++) {
            System.out.println(elem[i]);
        }
    }

    //在POS位置新增元素
    private boolean isfull(){
        /*if(usedSize == elem.length){
            return true;
        }
        return false;*/
        return usedSize == elem.length;
    }
    public void add(int pos,int data){
        if(pos > this.usedSize || pos < 0){
            System.out.println("该位置不合法");
        }
        //满了，扩容为两倍+拷贝源数组
        if(isfull()){
            this.elem = Arrays.copyOf(this.elem,this.elem.length*2);
        }
        for (int i = usedSize-1; i >= pos; i--) {
            elem[i+1] = elem[i];
        }
        this.elem[pos] = data;
        this.usedSize++;
    }

    //判定是否包含某个元素
    public boolean contains(int toFind){
        for (int i = 0; i < this.usedSize; i++) {
            if(toFind == this.elem[i]){
                return true;
            }
        }
        return false;
    }

    //查找某个元素对应位置
    public int search(int toFind){
        for (int i = 0; i < this.usedSize; i++) {
            if(toFind == this.elem[i]){
                return i;
            }
        }
        return -1;
    }

    //获取pos位置元素
    public int getPos(int pos){
        if(pos >= this.usedSize || pos < 0){
            System.out.println("该位置不合法");
            return -1;
        }
        return elem[pos];
    }

    //给POS位置的元素设为value
    public void setPos(int pos,int value){
        if(pos >= this.usedSize || pos < 0){
            System.out.println("该位置不合法");
        }
        elem[pos] = value;
    }

    //删除第一次出现的关键字key
    public void remove(int toRemove){
        int index = getPos(toRemove);
        if(index == -1){
            System.out.println("找不到要删的数");
        }
        for (int i = index; i < usedSize-1; i++) {
            elem[i] = elem[i+1];
        }
        this.usedSize--;
    }

    //获取顺序表长度
    public int size(){
        return this.usedSize;
    }

    //清空顺序表
    public void clear(){
        this.usedSize = 0;
    }
}
