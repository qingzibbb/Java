import java.util.Date;

class ListNode{
    public int data;
    public ListNode prev;
    public ListNode next;

    public ListNode(int data){
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}
public class DoubleList {
    public ListNode head;
    public ListNode last;


    public void addFirst(int data){
        ListNode node = new ListNode(data);
        if(this.head == null){
            this.head = node;
            this.last = node;
        }else {
            node.next = this.head;
            this.head = node;
        }
    }

    public void addLast(int data){
        ListNode node = new ListNode(data);
        if(this.head == null){
            this.head= node;
            this.last = node;
        }else {
            this.last.next = node;
            node.prev = this.last;
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
    private ListNode searchIndex(int index){
        ListNode cur = this.head;
        while (index > 0){
            cur = cur.next;
            index--;
        }
        return cur;
    }
    public void addIndex(int index,int data){
        if(index == 0){
            addFirst(data);
            return ;
        }
        if(index == getLength()){
            addLast(data);
            return ;
        }
        if(index < 0 || index > getLength()){
            return ;
        }
        ListNode node = new ListNode(data);
        ListNode cur = searchIndex(index);
        node.next = cur;
        cur.prev.next = node;
        node.prev = cur.prev;
        cur.prev = node;
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
    public void remove(int key){
        ListNode cur = this.head;
        while (cur != null){
            if(cur.data == key){
                if(cur == this.head){
                    this.head = this.head.next;
                    this.head.prev = null;
                }else {
                    cur.prev.next = cur.next;
                    if(cur.next != null){
                        cur.next.prev = cur.prev;
                    }else {
                        this.last = cur.prev;
                    }
                }
                return;
            }
            cur = cur.next;
        }
    }

    public void removeAllKey(int key){
        ListNode cur = this.head;
        while (cur != null){
            if(cur.data == key){
                if(cur == this.head){
                    this.head = this.head.next;
                    this.head.prev = null;
                }else {
                    cur.prev.next = cur.next;
                    if(cur == this.last){
                        this.last = this.last.prev;
                    }else {
                        cur.next.prev = cur.prev;
                    }
                }
            }
            cur = cur.next;
        }
    }
}
