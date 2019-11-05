public class TestDemo {
    public static void main(String[] args) {
        MySingleList mySingleList = new MySingleList();
        mySingleList.addFirst(805);
        mySingleList.addFirst(1005);
        mySingleList.addLast(1314);
        mySingleList.addLast(9999);
        mySingleList.addFirst(9999);
        mySingleList.addIndex(2,9999);
        mySingleList.addIndex(2,6666);
        mySingleList.display();
        boolean con1 = mySingleList.contains1(1314);
        System.out.println(con1);
        ListNode con2 = mySingleList.contains2(1314);
        System.out.println(con2.data);
        mySingleList.remove(6666);
        mySingleList.display();
        mySingleList.removeAllKey(9999);
        mySingleList.display();
        //mySingleList.clear();
        //逆序  方法1：四个ListNode  方法2：头插法
        //ListNode newHead = mySingleList.reverseList();
        //mySingleList.displayNew(newHead);
        mySingleList.addFirst(999);
        mySingleList.display();
        //System.out.println(mySingleList.middleNode1().data);
        //System.out.println(mySingleList.middleNode2().data);
        System.out.println(mySingleList.findKthToTail(2).data);
    }
}
