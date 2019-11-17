package com;

public class Cat extends Animal{
    //public String name;
    public String color;//子类独有的数据
    /*static {
        System.out.println("Cat::static");
    }
    {
        System.out.println("Cat::instance");
    }*/

    public void func1(){
        String name = super.name;
        super.eat();
    }
    public Cat(String name,String color){
        super(name);//必须在第一行
        //this.name = name;
        this.color = color;
        //System.out.println("Cat(String,String)");
    }
    /*public void eat(){
        System.out.println(this.name+"eat");
    }*/
}
class ChineseGardenCat extends Cat{
    public String sex;
    public ChineseGardenCat(String name,String color,String sex){
        super(name,color);
        this.sex = sex;
    }
}