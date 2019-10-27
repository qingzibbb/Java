class Person{
    public int age=1;
    public String name;
    public  void eat(){
        System.out.println("吃饭");
    }

}
public class TestDemo2 {
    public static void main(String[] args) {
        //实例化一个对象  new
        Person person = new Person();
        System.out.println(person.age);
    }
}
