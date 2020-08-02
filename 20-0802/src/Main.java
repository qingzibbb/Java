public class Main {
    public static void main(String[] args) {
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.add(0,2);
        myArrayList.add(0,1);
        myArrayList.add(1,9);

        int ret = myArrayList.search(9);
        myArrayList.display();
        System.out.println(ret);
        myArrayList.remove(9);
        myArrayList.display();
        myArrayList.clear();
        myArrayList.display();
}
}
