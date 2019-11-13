public class Test {
    public static void main(String[] args) {
        MySingleList mySingleList = new MySingleList();
        mySingleList.addFirst(805);
        mySingleList.addFirst(1314);
        //mySingleList.addLast(1314);
        mySingleList.addLast(9999);
        mySingleList.addFirst(222);
        mySingleList.display();
        //ListNode code = mySingleList.reverseList2(mySingleList.head);
        //mySingleList.displayNew(code);
        ListNode code = mySingleList.middleNode();
        System.out.println(code.data);
        ListNode find = mySingleList.findKthToTail(3);
        System.out.println(find.data);
        ListNode part= mySingleList.partition(2222);
        mySingleList.displayNew(part);
        ListNode head= mySingleList.deleteDuplication();
        mySingleList.displayNew(head);
    }
}
