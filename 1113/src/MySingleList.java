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
    public void addLast(int data){
        ListNode node = new ListNode(data);
        ListNode cur = this.head;
        if(this.head == null){
            this.head = node;
        }else {

            while (cur.next != null){
                cur = cur.next;
            }
            cur.next = node;
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

    public int getLength(){
        int count = 0;
        ListNode cur = this.head;
        while (cur != null){
            cur = cur.next;
            count++;
        }
        return count;
    }

    //打印单链表数据
    public void display(){
        ListNode cur = this.head;
        if(cur == null){
            return;
        }
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

    public void removeAllKey(int key){
        ListNode prev= this.head;
        ListNode cur = this.head.next;
        while(cur != null){
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
    //逆序单链表
    public ListNode reverseList1(){
        ListNode prev = null;//手动置空
        ListNode newHead = null;
        ListNode cur = this.head;
        while (cur != null){
            ListNode curNext = cur.next;
            if(curNext == null){
                newHead = cur;
            }
            cur.next = prev;//直接把尾巴的next置为空
            prev = cur;
            cur = curNext;
        }
        return newHead;
    }
    public ListNode reverseList2(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode p = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

    public ListNode middleNode(){
        ListNode fast = this.head;
        ListNode slow = this.head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return  slow;
    }
    //找到倒数第k个节点
    public ListNode findKthToTail(int k){
        if(k <= 0 || this.head == null){
            return null;
        }
        ListNode fast = this.head;
        ListNode slow = this.head;
        while (k -1 > 0){
            if(fast.next != null){
                fast = fast.next;
                k--;
            }else {
                System.out.println("没有这个节点");
                return null;
            }
        }
        while (fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
    //以x分割链表
    public ListNode partition(int x){
        ListNode bs = null;
        ListNode be = null;
        ListNode as = null;
        ListNode ae = null;
        ListNode cur = this.head;
        while (cur != null){
            if(cur.data < x){
                if(bs == null){
                    bs = cur;
                    be = cur;
                }else {
                    be.next = cur;
                    be = cur;
                }
                cur = cur.next;
            }else {
                if(as == null){
                    as = cur;
                    ae = cur;
                }else {
                    ae.next = cur;
                    be = cur;
                }
                cur = cur.next;
            }
        }
        //第一个区间没有数据
        if(bs == null){
            return as;
        }
        be.next = as;
        if(as != null){
            as.next = null;
        }
        return bs;
    }
    //删除有序链表中重复节点
    public ListNode deleteDuplication(){
        ListNode cur = this.head;
        ListNode newHead = new ListNode(-1);
        ListNode tmp = newHead;
        while (cur != null){
            if(cur.next != null && cur.data == cur.next.data) {
                while (cur.next != null && cur.data == cur.next.data){
                    cur = cur.next;
                }
                cur = cur.next;
            }else {
                tmp.next = cur;
                tmp = tmp.next;
                cur = cur.next;
            }
        }
        tmp.next = null;
        return newHead.next;
    }
    //两辆交换单链表中的数
    public ListNode swapPairs(ListNode head) {
        ListNode newHead = new ListNode(-1);
        newHead.next = this.head;
        ListNode tmp = newHead;
        if(this.head == null ||this.head.next == null){
            return this.head;
        }
        while (tmp.next != null && tmp.next.next != null){
            ListNode cur = tmp.next;
            ListNode curNext = cur.next;
            tmp.next = curNext;
            cur.next = curNext.next;
            curNext.next = cur;
            tmp = cur;
        }
        return newHead.next;
    }
}
