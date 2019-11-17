package com;

public class Bird extends Animal{
    public String feather;

    public Bird(String name,String feather){
        super(name);
        this.feather = feather;
    }
    public void fly(){
        System.out.println(this.name+"fly");
    }
}
