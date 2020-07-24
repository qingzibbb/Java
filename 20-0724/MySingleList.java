//节点类
class  ListNode{
    public int data;
    public ListNode next;
    public ListNode(int data){
        this.data = data;
        this.next = null;
    }
}
class MySingleLise {
    public ListNode head;

    public MySingleLise() {
        this.head = null;
    }

    //头插法
    public void addFirst(int data) {
        ListNode node = new ListNode(data);
        if (this.head == null) {
            this.head = node;
        } else {
            node.next = this.head;
            this.head = node;
        }
    }

    //尾插法
    public void addLast(int data) {
        ListNode node = new ListNode(data);
        ListNode cur = this.head;
        if (this.head == null) {
            this.head = node;
        } else {
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = node;
        }
    }

    //任意位置插入,第一个数据节点为0号下标
    //找index-1的位置
    private ListNode searchIndex(int index) {
        ListNode prev = this.head;
        int count = 0;
        while (count < index - 1) {
            prev = prev.next;
            count++;
        }
        return prev;
    }

    public boolean addIndex(int index, int data) {
        if (index < 0 || index >= getLength()) {
            System.out.println("该位置不合法");
            return false;
        }
        if (index == 0) {
            addFirst(index);
            return true;
        }
        ListNode prev = searchIndex(index);
        ListNode node = new ListNode(data);
        node.next = prev.next;
        prev.next = node;
        return true;
    }

    //得到单链表长度
    public int getLength() {
        int count = 0;
        ListNode cur = this.head;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }

    //展示链表
    public void display() {
        if (this.head == null) {
            return;
        }
        ListNode cur = this.head;
        while (cur != null) {
            System.out.println(cur.data + " ");
            cur = cur.next;
        }
    }

    //查找是否包含关键字key是否在单链表当中
    public boolean contains1(int key){
        ListNode cur = this.head;
        while (cur != null){
            if(cur.data == key){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }
    public ListNode contains2(int key){
        ListNode cur = this.head;
        while (cur != null){
            if(cur.data == key){
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }

    //删除第一次出现关键字为key的节点
    private ListNode searchPrev(int key){
        ListNode prev = this.head;
        while (prev.next != null){
            if(prev.next.data == key){
                return prev;
            }
            prev = prev.next;
        }
        return  null;
    }
    public void remove(int key){
        if(this.head.data ==key){
            this.head = this.head.next;
            return;
        }
        ListNode prev = searchPrev(key);
        if(prev == null){
            System.out.println("没有你删除的数");
            return;
        }
        ListNode del = prev.next;
        prev.next = del.next;
    }

    //删除所有值为key的节点
    public void removeAllKey(int key){
        ListNode prev = this.head;
        ListNode cur = this.head.next;
        while (cur != null){
            if(cur.data == key){
                prev.next = cur.next;
                cur = cur.next;
            }else {
                prev = cur;
                cur = cur.next;
            }
        }
        if(this.head.data == key){
            this.head = this.head.next;
        }
    }

    //清空
    public void clear(){
        while (this.head.next != null){
            ListNode cur = this.head;
            this.head.next = cur.next;
        }
        this.head = null;
    }
}


