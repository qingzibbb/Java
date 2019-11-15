public class TestDemo {
    public static void main(String[] args) {
        MySingleList mySingleList = new MySingleList();
        mySingleList.addFirst(1);
        mySingleList.addLast(2);
        mySingleList.addLast(3);
        mySingleList.searchIndex(2,3);
        mySingleList.remove(2);
        mySingleList.removeAllKey(3);
        mySingleList.display();
    }
}
