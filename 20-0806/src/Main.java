public class Main {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addFirst(30);
        myLinkedList.addFirst(50);
        myLinkedList.addFirst(6);
        myLinkedList.addLast(60);
        myLinkedList.display();
        System.out.println(myLinkedList.contains(6));
        System.out.println(myLinkedList.size());
        myLinkedList.addIndex(2,99);
        myLinkedList.display();
        myLinkedList.remove(6);
        myLinkedList.display();
        myLinkedList.clear();
    }
}
