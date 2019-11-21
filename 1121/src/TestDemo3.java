abstract class Shape2{ //抽象类
    public void func(){

    }
    public abstract void draw();//抽象方法
}
class Rect2 extends Shape2{
    @Override
    public void draw() {
        System.out.println("□");
    }
}
abstract class Cycle2 extends Shape2{
    /*@Override
    public void draw() {
        System.out.println("○");
    }*/
}
class Cycle3 extends Cycle2{
    public void draw() {
        System.out.println("○");
    }
}
class Flower2 extends Shape2{
    @Override
    public void draw() {
        System.out.println("❀");
    }
}
public class TestDemo3 {
    public static void drawMap(Shape2 shape){
        shape.draw();
    }
    public static void main(String[] args) {
        Rect2 rect2 = new Rect2();
        Flower2 flower2 = new Flower2();
        drawMap(rect2);
        drawMap(flower2);
    }
}
