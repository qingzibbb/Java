
class Node{
    public int data;
    public Node next;

    public Node(int data){
        this.data = data;
    }
}

public class MyLinkedList {

    public Node head;//头结点

    //头插法
    public void addFirst(int data){
        Node node = new Node(data);
        if(this.head == null){
            this.head = node;
        }else {
            node.next = this.head;
            this.head = node;
        }
    }

    public void display(){
        Node cur = this.head;
        while (cur!=null){
            System.out.print(cur.data+" ");
            cur = cur.next;
        }
        System.out.println();
    }

    public void addLast(int data){
        Node node = new Node(data);
        Node cur = this.head;
        if(this.head == null){
            this.head = node;
        }else {
            while (cur.next!= null){
                cur = cur.next;
            }
            cur.next = node;
        }
    }

    public boolean contains(int key){
        Node cur = this.head;
        while (cur!=null){
            if(cur.data == key) return true;
            cur = cur.next;
        }
        return false;
    }

    public int size(){
        int len = 0;
        Node cur = this.head;
        while (cur!=null){
            len++;
            cur = cur.next;
        }
        return len;
    }

    public void addIndex(int index,int data){
        Node node = new Node(data);
        if(index == 0){
            this.addFirst(data);
        }else if(index == this.size()){
            this.addLast(data);
        }else {
            if(index<0||index>this.size()){
                throw new RuntimeException("下标不合法");
            }
            Node cur = this.head;
            while (index>1){
                cur = cur.next;
                index--;
            }
            node.next = cur.next;
            cur.next = node;
        }
    }

    private Node searchPrev(int key){
        Node prev = this.head;
        while (prev.next!=null){
            if(prev.next.data==key){
                return prev;
            }
            prev = prev.next;
        }
        return null;
    }
    //删除第一次出现关键字为key的节点
    public void remove(int key){
        if(this.head==null){
            return;
        }
        if (this.head.data==key) {
            this.head = this.head.next;
            return;
        }
        Node prev = searchPrev(key);
        if(prev==null){
            System.out.println("没有此节点");
            return;
        }
        prev.next = prev.next.next;
    }

    public void removeAll(int key){
        //只遍历一遍
        //最后删除头，如果前面的节点都是key，那么会漏掉头节点
        Node prev = this.head;
        Node cur = prev.next;
        while (cur!=null){
            if(cur.data==key){
                prev = cur.next;
                cur = cur.next;
            }else {
                prev = cur;
                cur = cur.next;
            }
            if(this.head.data == key){
                this.head = this.head.next;
            }
        }
    }

    //释放内存
    public void clear(){
        this.head = null;
    }

    public Node reverse(){
        Node prev = null;
        Node cur = this.head;
        Node newHead = null;
        while (cur!=null){
            Node curNext = cur.next;
            if(curNext==null){
                newHead = cur;
            }
            cur.next = prev;
            prev = cur;
            cur = curNext;
        }
        return newHead;
    }
}
