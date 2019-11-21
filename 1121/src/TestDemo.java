class Animal{
    public String name;
    public Animal(String name){
        this.name = name;
    }
    public void eat(){
        System.out.println(this.name+"Animal:eat");
    }
}

class Cat extends Animal{
    public String color;
    public Cat(String name,String color){
        super(name);
        this.color = color;
    }
    public void jump(){
        System.out.println(this.name+"jump");
    }

    @Override
    public void eat() {
        System.out.println(this.name+"Cat:eat");
    }
}

class Bird extends Animal{
    public Bird(String name){
        super(name);
    }
    public void fly(String name){
        System.out.println(name+"fly");
    }
}
public class TestDemo {

    public static void main(String[] args) {
        Animal animal = new Cat("小黑","黑色");
        animal.eat();
    }
    /*public static void main1(String[] args) {
        //向上转型
        Animal animal = new Cat("小红","红色");
        animal.eat();
        Animal animal1 = new Bird("小绿");
        animal1.eat();
        //向下转型
        Bird bird = (Bird) animal1;
        bird.fly("小绿");
        Animal animal3 = new Cat("小白","白色");
        if(animal3 instanceof Bird){
            Bird bird1 = (Bird)animal3;
        }
    }*/
}
