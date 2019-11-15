class ListNode{
    public int data;
    public ListNode next;
    public ListNode(int data){
        this.data = data;
        this.next = null;
    }
}
class MySingleList {
    public ListNode head;
    public MySingleList(){
        this.head = null;
    }
    //头插法
    public void addFirst(int data){
        ListNode node = new ListNode(data);
        if(this.head == null){
            this.head = node;
        }else{
            node.next = this.head;
            this.head = node;
        }
    }

    //尾插法
    public void addLast(int data){
        ListNode node = new ListNode(data);
        if(this.head == null){
            this.head = node;
        }
        //找尾巴
        else{
            ListNode cur = this.head;
            while(cur.next != null){
                cur = cur.next;
            }
            cur.next = node;
        }
    }
    //任意位置插入,第一个数据节点为0号下标
    public boolean searchIndex(int x,int data){
        if(this.head == null){
            addFirst(data);
            return true;
        }
        if(x < 0 || x >= getLength()){
            System.out.println("输入位置非法");
            return false;
        }
        ListNode prev = this.head;
        while (x-1 > 0){
            prev = prev.next;
            x--;
        }
        ListNode cur = new ListNode(data);
        cur.next = prev.next;
        prev.next = cur;
        return false;
    }
    public int getLength(){
        int count = 0;
        ListNode cur = this.head;
        while (cur != null){
            cur = cur.next;
            count++;
        }
        return count;
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
        return null;
    }
    public void remove(int key){
        if(this.head == null){
            return;
        }
        if(this.head.data == key){
            this.head = this.head.next;
            return;
        }
        ListNode prev = searchPrev(key);
        if(prev != null){
            ListNode del = prev.next;
            prev.next = del.next;
        }else {
            System.out.println("没有要删的数");
            return;
        }
    }

    public void removeAllKey(int key){
        ListNode prev= this.head;
        ListNode cur = this.head.next;
        while (cur!= null){
            if(cur.data == key){
                prev.next = cur.next;
            }else {
                prev = prev.next;
                cur = cur.next;
            }
        }
        if(this.head.data == key){
            this.head = this.head.next;
        }
    }
    //打印单链表数据
    public void display(){
        if(this.head == null){
            return;
        }
        ListNode cur = this.head;
        while (cur != null){
            System.out.print(cur.data+" ");
            cur = cur.next;
        }
        System.out.print("\n");
    }
}

