public class TestLanbda2 {


    public static void main(String[] args) {
        /*ILove love = (int a)->{
                System.out.println("I love you->"+a);
        };*/

        /*ILove love = (a)->{
            System.out.println("I love you->"+a);
        };*/

        /*ILove love = a->{
            System.out.println("I love you->"+a);
        };*/

        ILove love = a-> System.out.println("I love you->"+a);
        love.love(520);
    }
}
interface ILove{
    void love(int a);
}
