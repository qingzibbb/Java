import java.util.Arrays;

class Student implements Comparable<Student>{//自定义类型排序
    public String name;                //手动实现实现Comparable
    public int age;
    public double height;

    public Student(String name,int age,double height){
        this.name = name;
        this.age = age;
        this.height = height;
    }
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", height=" + height +
                '}';
    }
    @Override
    public int compareTo(Student o) {
        return this.name.compareTo(o.name);
        //return this.age - o.age;
        //return (int)(this.height - o.height);
    }
}



public class TestDemo1 {
    public static void main(String[] args) {
        Student[] student = new Student[3];
        student[0] = new Student("xz",28,183.3);
        student[1] = new Student("wyb",22,178.3);
        student[2] = new Student("wx",25,180.3);
        Arrays.sort(student);
        System.out.println(Arrays.toString(student));
    }

    public static void main1(String[] args) {
        //Person person = new Person("aa",)
    }
}
