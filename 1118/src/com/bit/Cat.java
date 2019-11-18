package com.bit;

public class Cat extends Animal{
    protected String color;
    public Cat(String name,String color){
        super(name);
        this.color = color;
    }

    public void func1(){
        System.out.println("func1");
    }
}
