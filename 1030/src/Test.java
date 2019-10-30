public class Test {
    public static void main(String[] args) {
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.dispaly();
        myArrayList.add(0,2);
        myArrayList.add(1,1);
        myArrayList.add(2,3);
        myArrayList.dispaly();
        boolean contains = myArrayList.contains(3);
        System.out.println(contains);
        int search = myArrayList.search(3);
        System.out.println(search);
        int toFind = myArrayList.getPos(2);
        System.out.println(toFind);
        myArrayList.setPos(2,5);
        myArrayList.dispaly();
        myArrayList.remove(2);
        myArrayList.dispaly();
        int size = myArrayList.size();
        System.out.println(size);
        myArrayList.clear();
    }
}
