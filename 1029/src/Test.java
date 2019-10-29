class Person{
    private String name;
    public static int count;
    public void eat(){
        System.out.println("吃饭");
    }
    //this调用其他构造函数
    public Person(){
        //this("bjyx");
        System.out.println("Person()");
    }
    //构造函数
    public Person(String name){
        this.name = name;
        System.out.println("Person(String)");
    }
    //实例代码块
    {
        count  = 1005;
        this.name = "bjyx";
        System.out.println("实例代码块");
    }
    //静态代码块
    static {
        count = 1314;
        System.out.println("静态代码块");
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}
public class Test {
    public static void main(String[] args) {
        Person person = new Person();
        System.out.println(person);
        System.out.println(Person.count);
        new Person("bjyx").eat();
    }
}


