public class TestDemo {
    public static void main(String[] args) {
        MySingleList mySingleList = new MySingleList();
        mySingleList.addLast(80);
        mySingleList.addLast(10);
        mySingleList.addLast(10);
        mySingleList.addLast(80);
        //mySingleList.addLast(80);

        //ListNode newHead = mySingleList.deleteDuplication();
        //mySingleList.displayNew(newHead);
        boolean a = mySingleList.chkPalindrome();
        System.out.println(a);
    }
}
