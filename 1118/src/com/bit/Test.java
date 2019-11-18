package com.bit;

class Address{
    private String building;
    private int floor;

    public Address(String building, int floor){
        this.floor = floor;
        this.building = building;
    }

    @Override
    public String toString() {
        return "Address{" +
                "building='" + building + '\'' +
                ", floor=" + floor +
                '}';
    }
}

class Student{
    public String name;
    public Address address;

    public Student(String name,Address address){
        this.name = name;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", address=" + address +
                '}';
    }
}
public class Test {
    //多态
    public static void main2(String[] args) {
        //Animal animal = new Animal("小白");
        /*Cat cat = new Cat("小黑","红");
        Animal animal = cat;//向上转型*/
        //父类引用子类的对象---向上转型
        Animal animal = new Cat("小白","白色");
        //animal.func1();//error 父类引用
        // 只能调用父类自己的方法或访问自己的属性
    }

    public static Animal function2(Animal animal){
        Cat cat = new Cat("小白","白色");
        return cat;
    }
    public static void function1(Animal animal){

    }
    public static void main3(String[] args) {
        Cat cat = new Cat("小白","白色");
        function1(cat);
    }
    //向下转型
    public static void main(String[] args) {
        Animal animal = new Cat("小白","白色");
        if(animal instanceof Bird){
            Bird bird = (Bird)animal;
            bird.fly();
        }
    }

    //组合
    public static void main1(String[] args) {
        Address address = new Address("13栋",14);
        Student student = new Student("bjyx",address);
        System.out.println(student);
    }
}
