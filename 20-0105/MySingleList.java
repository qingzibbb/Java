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
}


