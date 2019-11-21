interface IShape{//接口
    void draw();
}
class Rect4 implements IShape{
    @Override
    public void draw() {
        System.out.println("□");
    }
}
class Cycle4 implements IShape{
    @Override
    public void draw() {
        System.out.println("○");
    }
}
public class TestDemo4 {
    public static void drawMap(IShape shape){
        shape.draw();
    }
    public static void main(String[] args) {
        IShape shape = new Cycle4();
        Cycle4 cycle4 = new Cycle4();
        drawMap(shape);
        drawMap(cycle4);
    }
}
