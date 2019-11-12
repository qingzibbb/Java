class ListNode {
    public int data;
    public ListNode next;

    public ListNode(int data) {
        this.data = data;
        this.next = null;
    }
}
class MySingleList {
    public ListNode head;
    public void MySingleList(){
        this.head = null;
    }

    public void addFirst(int k){
        ListNode cur = new ListNode(k);
        if(this.head == null){
            this.head = cur;
        }else {
            this.head = this.head.next;
            this.head = cur;
        }
    }

    //尾插法
    //找尾巴
    private ListNode searchCur(int data){
        ListNode cur = this.head;
        while (cur.next != null){
            cur = cur.next;
        }
        return cur;
    }
    public void addLast(int data){
        ListNode node = new ListNode(data);
        if(this.head == null){
            this.head = node;
        }else {
            //找尾巴
            ListNode cur = searchCur(data);
            cur.next =node;
        }
    }

    //任意位置插入,第一个数据节点为0号下标
    private ListNode searchIndex(int index){
        int i = 0;
        ListNode prev = this.head;
        while (i < index-1){
            prev = prev.next;
            i++;
        }
        return prev;
    }
    public boolean addIndex(int index,int data){
        if(index < 0 ||index >= getLength()){
            System.out.println("该位置不合法");
            return false;
        }
        if(index == 0){
            addFirst(data);
            return true;
        }
        ListNode node = new ListNode(data);
        ListNode prev = searchIndex(index);
        node.next = prev.next;
        prev.next = node;
        return  false;
    }

    //获取链表长度
    public int getLength(){
        int count = 0;
        ListNode node = this.head;
        while (node != null){
            count++;
            node = node.next;
        }
        return count;
    }

    //打印单链表数据
    public void display(){
        if (this.head == null){
            return;
        }
        ListNode cur = this.head;
        while (cur != null){
            System.out.print(cur.data+" ");
            cur = cur.next;
        }
        System.out.print("\n");
    }
    public void displayNew(ListNode newHead){
        if (newHead == null){
            return;
        }
        ListNode cur = newHead;
        while (cur != null){
            System.out.print(cur.data+" ");
            cur = cur.next;
        }
        System.out.print("\n");
    }

    //给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
    public ListNode swapPairs() {
        //定义一个newHead tmp方便打印及交换
        ListNode newHead = new ListNode(-1);
        ListNode tmp = newHead;
        newHead.next = this.head;
        if(this.head == null){
            return null;
        }
        while (tmp.next != null && tmp.next.next != null){
            ListNode cur = tmp.next;
            ListNode curNext = tmp.next.next;
            //注意交换的顺序
            tmp.next = curNext;
            //后交换curNext.next = cur  以防curNext.next丢失
            cur.next = curNext.next;
            curNext.next = cur;
            tmp = cur;
        }
        return newHead.next;
    }

}
