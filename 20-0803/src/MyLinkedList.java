
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
}
