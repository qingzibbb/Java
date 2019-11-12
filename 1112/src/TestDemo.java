public class TestDemo {
    //因为牵扯到两个链表 所以在这块写
    public static ListNode mergeTwoLists(ListNode headA, ListNode headB) {
        ListNode newHead = new ListNode(-1);
        ListNode tmp = newHead;
        if(headA == null && headB == null){
            return null;
        }
        while (headA != null && headB != null) {
            if (headA.data < headB.data) {
                tmp.next = headA;
                headA = headA.next;
                tmp = tmp.next;
            } else {
                tmp.next = headB;
                tmp = tmp.next;
                headB = headB.next;
            }
        }
        if(headA == null){
            tmp.next = headB;
        }
        if(headB == null){
            tmp.next = headA;
        }
        return newHead.next;
    }
    //求两个链表交叉点
    public static ListNode getIntersectionNode(ListNode headA,ListNode headB){
        if(headA == null || headB == null){
            return  null;
        }
        ListNode pL = headA;//指向长long的单链表--假设
        ListNode pS = headB;//短short
        int lenA = 0;
        int lenB = 0;
        //求ab len
        while (pL != null) {
            pL = pL.next;
            lenA++;
        }
        while (pS != null) {
            pS = pS.next;
            lenB++;
        }
        pL = headA;
        pS = headB;
        //求两个单链表长度的差值
        int len = lenA - lenB;
        if(len < 0){
            pL = headB;
            pS = headA;
            len = lenB - lenA;
        }

        //让长的先走len步
        while (len > 0){
            pL = pL.next;
            len--;
        }
        //一人一步走
        while (pL != pS){
            pL = pL.next;
            pS = pS.next;
        }
        if(pL == null){
            return null;
        }
        return pL;
    }

    public static void createCut(ListNode headA,ListNode headB){
        headA.next.next = headB.next.next;
    }
    public static void main(String[] args) {
        MySingleList mySingleList1 = new MySingleList();
        mySingleList1.addLast(805);
        mySingleList1.addLast(1005);
        mySingleList1.addLast(1316);
        mySingleList1.addLast(2222);
        mySingleList1.display();
        MySingleList mySingleList2 = new MySingleList();
        mySingleList2.addLast(627);
        mySingleList2.addLast(1006);
        mySingleList2.addLast(1314);
        mySingleList2.addLast(2222);
        mySingleList2.addLast(9999);
        mySingleList2.display();
        //createCut(mySingleList1.head,mySingleList2.head);
        //ListNode b = getIntersectionNode(mySingleList1.head,mySingleList2.head);
        //System.out.println(b.data);
        //ListNode a = mergeTwoLists(mySingleList1.head,mySingleList2.head);
        //mySingleList1.displayNew(a);
        ListNode code = mySingleList2.swapPairs();
        mySingleList2.displayNew(code);
    }
}
