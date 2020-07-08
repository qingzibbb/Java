import org.junit.*;

import static org.junit.Assert.*;

public class MainTest {

    @BeforeClass
    public static void beforeClass(){
        System.out.println("---beforeClass---");
    }
    @AfterClass
    public static void afterClass(){
        System.out.println("---afterClass---");
    }
    @Before
    //清理工作
    public void before(){
        System.out.println("---before---");
    }
    @After
    public void after(){
        System.out.println("---after---");
    }

    @Test
    public void add1(){
        Main a = new Main();
        System.out.println("类的实例创建完成");
        int res = a.add(10,Main.a);
        Main.a++;
        System.out.println(res);
        System.out.println(Main.a);
    }
}