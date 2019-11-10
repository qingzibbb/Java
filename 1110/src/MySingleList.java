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
        if(this.head == null){                         //!!!!!!!!!!!!!!!!!!!!!!!!
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
    private ListNode searchIndex(int index){
        ListNode prev = this.head;
        for (int i = 0; i < index-1 ; i++) {           //!!!!!!!!!!!!!!!
            prev = prev.next;
        }
        return prev;
    }
    public boolean addIndex(int index,int data){
        if(index == 0){
            addFirst(data);
            return true;
        }
        if(index < 0 || index >= getLenght()){
            System.out.println("该位置不合法");
            return false;
        }
        ListNode cur = new ListNode(data);
        ListNode prev = searchIndex(index);
        cur.next = prev.next;
        prev.next = cur;
        return false;
    }

    public int getLenght(){
        int count = 0;
        ListNode node = this.head;
        while(node != null){
            node = node.next;
            count++;
        }
        return count;
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

    //查找是否包含关键字key是否在单链表当中
    public boolean contains(int key){
        ListNode cur = this.head;
        while (cur != null){
            if(cur.data == key){
                return true;
            }
            cur = cur.next;
        }
        return false;
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
            System.out.println("没有要删的数");
            return;
        }
        ListNode del = prev.next;
        prev.next = del.next;
    }

    //删除所有关键字key
    public void removeAllKey(int key){
        ListNode prev = this.head;
        ListNode cur = this.head.next;
        while(cur != null){
            if(cur.data == key){
                prev.next = cur.next;
                cur = cur.next;
            }else{
                prev = prev.next;
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


    public ListNode reverseList(){
        ListNode prev = null;
        ListNode cur = this.head;
        ListNode newHead = null;
        while(cur != null){
            ListNode curNext = cur.next;
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
    public ListNode partition(int x){
        ListNode bs  = null;//beforestart
        ListNode be  = null;
        ListNode as  = null;
        ListNode ae  = null;//afterend
        ListNode cur = this.head;
        while (cur != null){
            if(cur.data < x){
                //是不是第一次插入
                if(bs == null){
                    bs = cur;
                    be = cur;
                }else {
                    be.next = cur;
                    be = cur;
                }
            }else {
                //是不是第一次插入
                if(as == null){
                    as = cur;
                    ae = cur;
                }else {
                    ae.next = cur;
                    ae = cur;
                }
            }
            cur = cur.next;
        }
        //第一个区间没有数据
        if(bs == null){
            return as;
        }
        //最后一个大于k的节点不在单链表最后，要手动把其next置为空
        if(as != null){
            ae.next = null;
        }
        be.next = as;
        return bs;
    }
    //删除所有重复节点
    public ListNode deleteDuplication(){
        if(this.head == null){
            return null;
        }
        ListNode cur = this.head;
        ListNode newHead = new ListNode(-1);
        ListNode tmp = newHead;
        while (cur != null){
            //重复的节点
            if(cur.next != null && cur.data == cur.next.data){//cur.next不能为空 前后顺序不能变 否则空指针异常
                while (cur.next != null && cur.data == cur.next.data){//循环多次都要判断cur.next!=null
                    cur = cur.next;
                }
                cur = cur.next;
            }else {
                tmp.next = cur;
                tmp = tmp.next;
                cur = cur.next;
            }
        }
        tmp.next = null;//最后一个数也是重复的  要将tmp保存的节点置位空
        return newHead.next;
    }

    //判断回文结构
    public boolean chkPalindrome() {
        if(this.head == null){//为空--false
            return false;
        }
        if(this.head.next == null){//只有一个节点--true
            return true;
        }
        //1、找单链表中间节点
        ListNode fast = this.head;
        ListNode slow = this.head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        //2、反转单链表
        ListNode cur = slow.next;
        while(cur != null){
            ListNode curNext = cur.next;
            cur.next = slow;
            slow = cur;
            cur = curNext;
        }
        //3、fast/slow往前 head往后----用slow 开始时fast可能为空
        while(this.head != slow){//用地址判断
            if (this.head.data != slow.data){
                return false;
            }
            if(this.head.next == slow){//偶数个数情况
                return true;
            }
            this.head = this.head.next;
            slow = slow.next;
        }
        return true;
    }

    //判断是否有环
    public void creteLoop(){
        ListNode cur = this.head;
        while (cur.next!= null){
            cur = cur.next;
        }
        cur = this.head.next.next;
    }
    public boolean hasCycle(){
        ListNode fast = this.head;
        ListNode slow = this.head;
        while (fast!=null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                return true;
            }
        }
        return false;
    }


}
