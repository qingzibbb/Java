import java.util.LinkedList;

public class TestDemo {
    public static ListNode mergoTwoList(ListNode headA,ListNode headB){
        if(headA == null && headB == null){
            return null;
        }
        ListNode newHead = new ListNode(-1);
        ListNode tmp = newHead;
        while(headA != null && headB != null){
            if(headA.data < headB.data){
                tmp.next = headA;
                tmp = tmp.next;
                headA = headA.next;
            }else {
                tmp.next = headB;
                tmp = tmp.next;
                headB = headB.next;
            }
        }
        if(headA != null){
            tmp.next = headA;
        }
        if(headB != null){
            tmp.next = headB;
        }
        return newHead.next;
    }
    public static void main(String[] args) {
        DoubleList doubleList = new DoubleList();
        doubleList.addFirst(1);
        doubleList.addLast(2);
        doubleList.addLast(2);
        doubleList.addLast(2);
        doubleList.addIndex(1,3);
        doubleList.display();
        boolean a = doubleList.contains(4);
        System.out.println(a);
        int data = doubleList.remove(3);
        System.out.println(data);
        doubleList.remove(3);
        doubleList.display();
        doubleList.removeAllKey(2);
        doubleList.display();
    }
}
