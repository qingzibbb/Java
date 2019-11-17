package com;
//import java.util.Date;
import java.util.*;
public class TestDemo {
    public static void main(String[] args) {
        Cat cat = new Cat("花花", "黄");
        System.out.println("================");
        Cat cat2 = new Cat("花花", "黄");

        /*cat.eat();
        Bird bird =new Bird("小白","白色");
        bird.eat();
        bird.fly();*/
    }
    public static void main1(String[] args){
        //java.util.Date date = new java.util.Date();
        Date date = new Date();
        System.out.println(date.getTime());
        //格林威治时间  1970年1月1日开始的毫秒数
    }
}
