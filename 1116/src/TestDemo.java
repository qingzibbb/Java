public class TestDemo {
    //合并两有序链表
    public static ListNode mergeTwoLists(ListNode headA,ListNode headB){
        ListNode newHead = new ListNode(-1);
        ListNode tmp = newHead;
        while (headA != null && headB != null){
            if(headA.data < headB.data) {
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

    //求两相交链表的交点
    public static ListNode getIntersectionNode(ListNode headA,ListNode headB){
        if(headA == null||headB == null){
            return null;
        }
        ListNode pl = headA;//长的（假设）
        ListNode ps = headB;//短的
        int lenA = 0;
        int lenB = 0;
        while (pl != null){
            pl = pl.next;
            lenA++;
        }
        while (ps != null){
            ps = ps.next;
            lenB++;
        }
        pl = headA;
        ps = headB;
        int len = lenA - lenB;
        if(len < 0){
            pl = headB;
            ps = headA;
            len = lenB - lenA;
        }
        while (len > 0){
            pl = pl.next;
            len--;
        }
        while (pl != ps){
            pl = pl.next;
            ps = ps.next;
        }
        if(pl == null){
            return null;
        }
        return pl;
    }
    public static void createCut(ListNode headA,ListNode headB){
        headA.next = headB.next.next;
    }

    public static void main(String[] args) {
        MySingleList mySingleList1 = new MySingleList();
        mySingleList1.addLast(5);
        mySingleList1.addLast(7);
        mySingleList1.addLast(9);
        MySingleList mySingleList2 = new MySingleList();
        mySingleList2.addLast(1);
        mySingleList2.addLast(2);
        mySingleList2.addLast(3);
        mySingleList2.addLast(7);
        mySingleList2.addLast(9);
        //ListNode node = mergeTwoLists(mySingleList1.head,mySingleList2.head);
        //mySingleList1.displayNew(node);
        createCut(mySingleList1.head,mySingleList2.head);
        ListNode node = getIntersectionNode(mySingleList1.head,mySingleList2.head);
        System.out.println(node.data);
    }
}
