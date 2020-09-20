public class TestLanbda1 {

    //3、静态内部类
    static class Like2 implements ILike{
        @Override
        public void Lambda() {
            System.out.println("I like lambda2");
        }
    }
    public static void main(String[] args) {
        ILike like = new Like();//向下转型
        like.Lambda();
        like = new Like2();
        like.Lambda();

        //4、局部内部类
        class Like3 implements ILike{
            @Override
            public void Lambda() {
                System.out.println("I like lambda3");
            }
        }

        like = new Like3();
        like.Lambda();

        //5、匿名内部类，没有类的名称，必须借助接口或父类
        like = new ILike() {
            @Override
            public void Lambda() {
                System.out.println("I like lambda4");
            }
        };
        like.Lambda();

        like = ()->{
            System.out.println("I like lambda5");
        };
        like.Lambda();
    }
}

interface ILike{
    void Lambda();
}
class Like implements ILike{
    @Override
    public void Lambda() {
        System.out.println("I like lambda");
    }
}
