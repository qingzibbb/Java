class ListNode{
    public int data;
    public ListNode next;
    public ListNode(int data){
        this.data = data;
        this.next = null;
    }
}
class MySingleList {
    ListNode head;
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

    public boolean chkPalindrome(){
        if(this.head == null){
            return false;
        }
        if(this.head.next == null){
            return  true;
        }
        //找中间节点
        ListNode fast = this.head;
        ListNode slow = this.head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        //反转后半部分
        ListNode cur = slow.next;
        while (cur != null){
            ListNode curNext = cur.next;
            cur.next = slow;
            slow = cur;
            cur = curNext;
        }
        //前后比较
        while (this.head != slow ){
            if(this.head.data != slow.data ){
                return false;
            }
            if(this.head.next == slow){
                return true;
            }
            this.head = this.head.next;
            slow = slow.next;
            }
        return true;
    }

    public boolean hasCycle(){
        if(this.head == null || this.head.next == null){
            return false;
        }
        ListNode fast = this.head;
        ListNode slow = this.head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                return true;
            }
        }
        return false;
    }

    public ListNode deleteCycle(){
        ListNode fast = this.head;
        ListNode slow = this.head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                break;
            }
        }
        if(fast == null || fast.next == null){
            return null;
        }
        slow = this.head;
        while (slow != fast){
            slow = slow.next;
            fast =fast.next;
        }
        return  slow;
    }
}
