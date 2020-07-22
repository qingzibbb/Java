class ListNode{
    public int data;
    public ListNode prev;
    public ListNode next;
    public ListNode(int data){
        this.data = data;
    }
}
public class DoubleList {
    public ListNode head;
    public ListNode last;
    //头插法
    public void addFirst(int data){
        ListNode node = new ListNode(data);
        if(this.head == null){
            this.head = node;
            this.last = node;
        }else {
            //不用管last 第一次插入的node就是last
            node.next = this.head;
            this.head.prev = node;
            this.head = node;
        }
    }
    public void addLast(int data){
        ListNode node = new ListNode(data);
        if(this.head == null){
            this.head = node;
            this.last = node;
        }else {
            node.prev = this.last;
            this.last.next = node;
            this.last = node;
        }
    }
    public void display(){
        ListNode cur = this.head;
        while (cur != null){
            System.out.print(cur.data+" ");
            cur = cur.next;
        }
        System.out.print("\n");
    }

    private ListNode searchIndex(int index){
        ListNode cur = this.head;
        while (index > 0){
            cur = cur.next;
            index--;
        }
        return cur;
    }
    //任意地方插入，首节点下标为1
    public boolean addIndex(int index,int data){
        if(index == 0){
            addFirst(data);
            return true;
        }
        if(index == getLength()){
            addLast(data);
            return true;
        }
        if(index < 0 || index > getLength()){
            return false;
        }
        ListNode node = new ListNode(data);
        ListNode cur = searchIndex(index);
        cur.prev.next = node;
        node.prev = cur.prev;
        node.next = cur;
        cur.prev = node;
        return true;
    }
    public int getLength(){
        int count = 0;
        ListNode cur = this.head;
        while (cur != null){
            count++;
            cur = cur.next;
        }
        return count;
    }
    public boolean contains(int k){
        ListNode cur = this.head;
        while (cur != null){
            if(cur.data == k){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }
    public void clear(){

        while (this.head != null){
            ListNode cur = this.head.next;
            this.head.next = null;
            this.head.prev = null;
            this.head = cur;
        }
        this.last = null;
    }
    public int remove(int key){
        ListNode cur = this.head;
        while (cur != null){
            if(cur.data == key){
                if(cur == this.head){
                    this.head.next.prev = null;
                    this.head = this.head.next;
                }else {
                    cur.prev.next = cur.next;
                    if(cur.next != null){
                        cur.next.prev = cur.prev;
                    }else {
                        this.last = cur.prev;
                    }
                }
                return cur.data;
            }
            cur = cur.next;
        }
        return -1;
    }

    public void removeAllKey(int key){
        ListNode cur = this.head;
        while (cur != null){
            if(cur.data == key){
                if(cur == this.head){
                    this.head.next.prev = null;
                    this.head = this.head.next;
                }else {
                    cur.prev.next = cur.next;
                    if(cur.next != null){
                        cur.next.prev = cur.prev;
                    }else {
                        this.last = cur.prev;
                    }
                }
            }
            cur = cur.next;
        }
    }
}
