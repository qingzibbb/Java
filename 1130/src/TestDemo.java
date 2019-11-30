public class TestDemo {
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

