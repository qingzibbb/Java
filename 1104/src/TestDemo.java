public class TestDemo {
    public static void main(String[] args) {
        MySingleLise mySingleLise = new MySingleLise();
        mySingleLise.addFirst(2);
        mySingleLise.addFirst(3);
        mySingleLise.addLast(4);
        mySingleLise.addLast(6);
        mySingleLise.addLast(3);
        mySingleLise.addIndex(2,99);
        mySingleLise.display();
        boolean flg1 = mySingleLise.contains1(10);
        System.out.println(flg1);
        ListNode node = mySingleLise.contains2(3);
        System.out.println(node.data);
        mySingleLise.remove(2);
        System.out.println("删2");
        mySingleLise.display();
        mySingleLise.removeAllKey(3);
        System.out.println("删3");
        mySingleLise.display();
        mySingleLise.clear();
        mySingleLise.display();

    }
}
