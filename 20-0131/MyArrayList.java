import java.util.Arrays;

class MyArrayList {
    //属性---私有的
    private int[] elem;//数组
    private int usedSize;//有效数据个数
    private final int CAPACITY = 10;//初始容量

    public MyArrayList() {
        this.elem = new int[CAPACITY];
        this.usedSize = 0;
    }
    //方法
    // 打印顺序表
    public void display() {
        for (int i = 0; i < this.usedSize; i++) {
            System.out.println(this.elem[i]+" ");
        }
    }
    private boolean isFull(){
        /*if(this.usedSize == this.elem.length){
            return true;
        }
        return false;*/
        return this.usedSize == this.elem.length;
    }
    // 在 pos 位置新增元素
    public void add(int pos, int data) {
        if(pos < 0 || pos >this.usedSize){
            System.out.println("该位置不合法");
            return;
        }
        if(isFull()){
            //扩容：长度变为两倍+拷贝数值
            this.elem = Arrays.copyOf(this.elem,this.elem.length*2);
        }
        for (int i = usedSize-1; i >= pos; i--) {
            elem[i+1] = elem[i];
        }
        this.elem[pos] = data;
        this.usedSize++;
    }
    // 判定是否包含某个元素----注意顺序表放的什么类型数据，数据比较的的方法不同
    public boolean contains(int toFind) {
        for (int i = 0; i < this.usedSize; i++) {
            if(this.elem[i] == toFind){
                return true;
            }
        }
        return false;
    }
    // 查找某个元素对应的位置
    public int search(int toFind) {
        for (int i = 0; i < usedSize; i++) {
            if(toFind == this.elem[i]){
                return i;
            }
        }
        return -1;
    }
    // 获取 pos 位置的元素
    public int getPos(int pos) {
        if(pos<0 || pos >= this.usedSize){
            System.out.println("POS位置不合法");
            return -1;
        }
        return this.elem[pos];
    }
    // 给 pos 位置的元素设为 value
    public void setPos(int pos, int value) {
        if(pos<0 || pos >= this.usedSize){
            System.out.println("POS位置不合法");
        }
        this.elem[pos] = value;
    }
    //删除第一次出现的关键字key
    public void remove(int toRemove) {
        int index = search(toRemove);
        if(index == -1){
            System.out.println("找不到要被删除的数");
            return;
        }
        for (int i = index; i < this.usedSize-1; i++) {
            this.elem[i] = this.elem[i+1];
        }
        this.usedSize--;//记得！！
    }
    // 获取顺序表长度
    public int size() {
        return this.usedSize;
    }
    // 清空顺序表
    public void clear() {
        this.usedSize = 0;
    }

}
