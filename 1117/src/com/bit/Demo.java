package com.bit;

import com.Animal;

public class Demo extends Animal{
    public Demo(String name){
        super(name);
    }
    public void func(){
        System.out.println(this.name);
    }
    public static void main(String[] args) {
        Animal animal = new Animal("小黑");
    }
}
