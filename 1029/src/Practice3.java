class Calculator{
    public int num1;
    public int num2;
    public int add(int num1,int num2){
        this.num1 = num1;
        this.num2 = num2;
        return num1+num2;
    }
    public int sub(int num1,int num2){
        this.num1 = num1;
        this.num2 = num2;
        return num1-num2;
    }
    public int mul(int num1,int num2){
        this.num1 = num1;
        this.num2 = num2;
        return num1*num2;
    }
    public int div(int num1,int num2){
        this.num1 = num1;
        this.num2 = num2;
        return num1/num2;
    }
}

class Person{
    private String name;
    private int age;
    private String sex;
    public Person(){
        this.name = "王琑";
        this.age = 25;
        this.sex = "男";
    }
    public Person(String name,int age){
        this.name = name;
        this.age = age;
    }
    public Person(String name,int age,String sex){
        this.name = name;
        this.age = age;
        this.sex = sex;
    }
    public void show(){
        System.out.println("姓名:"+name+"  年龄:"+age+"  性别:"+sex);
    }
}

class Swap{
    private int num1;
    private int num2;
    public void swap(int num1,int num2){
        this.num1 = num1;
        this.num2 = num2;
        int tmp = num1;
        num1 = num2;
        num2 = tmp;
        System.out.println("num1="+num1+"  num2="+num2);
    }
}
public class Practice3 {
    public static void main(String[] args) {
        //1、编写一个类Calculator,有两个属性num1,num2,这两个数据的值，不能在定义的同时初始化，最后实现加减乘
        //除四种运算.
        Calculator cal = new Calculator();
        System.out.println(cal.add(1,2));
        System.out.println(cal.sub(2,3));
        System.out.println(cal.mul(3,4));
        System.out.println(cal.div(6,2));
        //2、设计一个包含多个构造函数的类，并分别用这些构造函数来进行实例化对象。
        Person person1 = new Person();
        person1.show();
        Person person2 = new Person("wyb",22);
        person2.show();
        Person person3 = new Person("xz",28,"男");
        person3.show();
        //3、实现交换两个变量的值。要求：需要交换实参的值。
        Swap swap = new Swap();
        swap.swap(1,2);
    }
}
