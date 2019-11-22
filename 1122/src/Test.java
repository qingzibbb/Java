public class Test {
    public static void main(String[] args) {
        DoubleList doubleList = new DoubleList();
        doubleList.addFirst(1);
        doubleList.addFirst(2);
        doubleList.addLast(3);
        doubleList.addLast(3);
        doubleList.addFirst(4);
        doubleList.addIndex(2,6);
        doubleList.display();
        boolean a = doubleList.contains(5);
        System.out.println(a);
        doubleList.remove(2);
        doubleList.display();
    }
}
