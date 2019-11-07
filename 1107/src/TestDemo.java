public class TestDemo {
    public static void main(String[] args) {
        MySingleList mySingleList = new MySingleList();
        mySingleList.addFirst(3);
        mySingleList.addFirst(1005);
        mySingleList.addLast(1314);
        mySingleList.addLast(9999);
        mySingleList.addFirst(9999);
        mySingleList.addIndex(2,9999);
        mySingleList.addIndex(2,6666);
        mySingleList.display();
        boolean con1 = mySingleList.contains(1314);
        System.out.println(con1);
        mySingleList.remove(6666);
        mySingleList.display();
        mySingleList.removeAllKey(9999);
        mySingleList.display();
        mySingleList.clear();
        mySingleList.display();
    }
}
