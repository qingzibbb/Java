class OuterClass{
    public int data1 = 1;
    private int data2 = 2;
    int data3 = 3;
    public static int size = 10;

    public OuterClass(){
        System.out.println("OuterClass()");
    }

    class InnerClass{
        public int data4 = 4;
        //public static final int size = 10;
        public int data1 = 11;
        public InnerClass(){
            System.out.println("InnerClass()");
        }

        public void test(){
            System.out.println("data1="+data1);
            System.out.println("inner::data1="+this.data1);
            System.out.println("out::data1="+OuterClass.this.data1);
            System.out.println("InnerClass::test()");
        }
    }
}

class OuterClass2{
    public int data1 = 1;
    private int data2 = 2;
    int data3 = 3;
    public static int size = 10;

    public OuterClass2(){
        System.out.println("OuterClass()");
    }


    static class InnerClass2{
        public int data4 = 4;
        public static int data5 = 5;
        OuterClass outerClass;
        public InnerClass2(){
            System.out.println("static::InnerClass2()");
        }
        public InnerClass2(OuterClass o){
            this.outerClass = o;
            System.out.println("static::InnerClass2(OuterClass o)");
        }

        public void test(){
            System.out.println("data1="+this.outerClass.data1);
            System.out.println("InnerClass::test()");
        }
    }
}
public class TestDemo1{
    
}
public class Test {
    public static void main(String[] args) {
        OuterClass2 outerClass2 = new OuterClass2();
        OuterClass2.InnerClass2 innerClass2 = new OuterClass2.InnerClass2(outerClass);
    }

    public static void main1(String[] args) {
        OuterClass outerClass = new OuterClass();
        OuterClass.InnerClass innerClass = outerClass.new InnerClass();
        innerClass.test();
    }
}
