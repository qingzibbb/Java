interface A{
    void funcA();
}
interface B{
    void funcB();
}
interface D extends A,B{
    void funcD();
}
class F implements D{
    @Override
    public void funcA() {

    }

    @Override
    public void funcB() {

    }

    @Override
    public void funcD() {

    }
}
class C implements A,B{//接口数不限
    @Override
    public void funcA() {

    }
    @Override
    public void funcB() {

    }
}
public class TestDemo5 {
}
