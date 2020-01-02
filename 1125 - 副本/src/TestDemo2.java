/*class Money implements Cloneable{
    double money = 12.5;String name,Money money
}*/
class Person implements Cloneable{
    public String name;
    //public Money m;
    public Person(){
        this.name = name;
        //this.m = money;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }


}
public class TestDemo2 {
    public static void main(String[] args) {
        Person person = new Person();
        person.name = "bjyx";
        Person person1 = person.clone();
    }
}

