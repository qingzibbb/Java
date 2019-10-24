//1.递归求n的阶乘
/*public class Test {
    public static void main(String[] args){
        int a = 3;
        int sum = func(a);
        System.out.println(sum);
    }
    public static int func(int num){
           if(num == 1 || num == 0 ){
               return num;
           } else {
               return num * func(num - 1);
           }
    }
}

//2.求1+2+3+。。。。+10
public class Test {
    public static void main(String[] args){
        int a = 10;
        int sum = func(a);
        System.out.println(sum);
    }
    public static int func(int num){
        if(num == 1 || num == 0 ){
            return num;
        } else {
            return num + func(num - 1);
        }
    }
}

//3.输出整数的每一位
public class Test {
    public static void main(String[] args){
        int a = 1729;
        func(a);
    }
    public static void func(int num){
        if(num>9){
            func(num/10);
        }
        System.out.printf(num%10+" ");
    }
}

//4.输入非负整数，输出每位和
public class Test {
    public static void main(String[] args){
        int a = 1279;
        int sum = func(a);
        System.out.println(sum);
    }
    public static int func(int num){
        if(num<9 ){
            return num;
        } else {
            return (num%10) + func(num/10);
        }
    }
}


//5.求斐波那契数第n项
public class Test {
    public static void main(String[] args) {
        int n = 6;
        int a = func(n);
        System.out.println(a);
    }

    public static int func(int num) {
        if (num == 1 || num == 2) {
            return 1;
        } else {
            return func(num-1)+func(num-2);
        }
    }
}


//6.青蛙跳台阶问题
public class Test {
    public static void main(String[] args) {
        int n = 6;
        int a = func(n);
        System.out.println(a);
    }

    public static int func(int num) {
        if (num == 1) {
            return 1;
        }
        if(num == 2) {
            return 2;
        }else {
            return func(num-1)+func(num-2);
        }
    }
}*/


//7.汉诺塔问题
public class Test {
    public static void main(String[] args) {
        int n = 3;
        hanota(n,'a','b','c');
    }

    public static void move(char pos1,char pos2){
        System.out.println(pos1+"->"+pos2);
    }
    public static void hanota(int n,char pos1,char pos2,char pos3) {//   1通过2移到3
        if(n==1) {
            move(pos1, pos3);
        }else {
            hanota(n-1,pos1,pos3,pos2);
            move(pos1,pos3);
            hanota(n-1,pos2,pos1,pos3);
        }
    }
}