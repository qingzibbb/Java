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
        }else {
            node.next = this.head;
            this.head = node;
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
        return null;
    }
    public void remove(int key){
        if(this.head.data == key){
            this.head = this.head.next;
            return;
        }
        ListNode prev = searchPrev(key);
        if(prev == null){
            System.out.println("没有要删除的数");
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
        ListNode cur = this.head.next;
        while (this.head.next != null){
            this.head = this.head.next;
            this.head.next = cur.next;
        }
        this.head = null;
    }

    //反转单链表
    public ListNode reverseList(){
        ListNode prev = null;
        ListNode cur = this.head;
        ListNode newHead = null;
        while (cur != null){
            ListNode curNext = cur.next;
            //放前面
            if(curNext == null){
                newHead = cur;
            }
            cur.next = prev;
            prev = cur;
            cur = curNext;

        }
        return newHead;
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

    //返回链表的中间结点
    //方法1：遍历两遍  getlength()/2
    public ListNode middleNode1(){
        ListNode cur = this.head;
        for(int i = 1;i <= getLength()/2;i++){
            cur = cur.next;
        }
        return cur;
    }
    //方法2：遍历一遍  fast走2步 +slow走1步
    public ListNode middleNode2(){
        ListNode fast = this.head;
        ListNode slow = this.head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    //输入一个链表，输出该链表中倒数第k个结点  fast比slow多走k-1步
    public ListNode findKthToTail(int k){
        if(k <= 0 ){
            return null;
        }
        ListNode slow = this.head;
        ListNode fast = this.head;
        while (k-1 > 0){
            if(fast.next != null){
                fast = fast.next;
                k--;
            }else {
                return null;
            }

        }
        while (fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
