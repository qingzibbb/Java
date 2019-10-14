/*public class Test {
    public static void main(String[] args) {
		//1. 根据年龄, 来打印出当前年龄的人是少年(低于18), 青年(19-28), 中年(29-55), 老年(56以上)
		int a = 10;
		if(a <= 18){
			System.out.println("少年");
		}
		else if(a > 18 && a<=28){
			System.out.println("青年");
		}
		else if(a > 28 && a<=55){
			System.out.println("中年");
		}
		else{
			System.out.println("老年");
		}

		//2. 判定一个数字是否是素数
		int a = 13;
		int i = 2;
		for(i=2;i<a;i++){
			if(a%i == 0){
				System.out.println("a不是素数");
				break;
			}
		}
		if(i==a){
			System.out.println("a是素数");
		}

		//3. 打印 1 - 100 之间所有的素数
		int i = 1;
		int j = 1;
		for(i = 2;i <= 100;i++){
			int a = 1;
			for(j = 2;j < i;j++){
				if(i%j==0){
					a = 0;
					break;
				}
			}
			if(a == 1){
				System.out.print(i+" ");
			}
		}

		//4. 输出 1000 - 2000 之间所有的闰年
		int i = 1000;
		for(i=1000;i<=2000;i++){
			if((i%4==0&&i%100!=0)||(i%400==0)){
				System.out.print(i+" ");
			}
		}

		//5. 输出乘法口诀表
		int i = 1;
		int j = 1;
		for(i = 1;i <= 9;i++){
			for(j = 1;j < 9;j++){
				System.out.print(i+"*"+j+"="+i*j+"    ");
			}
			System.out.print("\n");
		}

		//6. 求两个正整数的最大公约数
		int a = 10;
		int b = 20;
		int i = 1;
		int n = 1;
		if(a<b){
			int tmp = a;
			a = b;
			b = tmp;
		}
		for(i = 1;i <= b;i++){
			if((a%i==0)&&(b%i==0)){
				n = i;
			}
		}
		System.out.println(n);

		//7. 计算1/1-1/2+1/3-1/4+1/5 …… + 1/99 - 1/100 的值。
		int i = 1;
		int k = 1;
		double sum = 0;
		for(i = 1;i <= 100;i++){
			sum+=1.0/i*k;
			k = -k;
		}
		System.out.println(sum);

		//8. 编写程序数一下 1到 100 的所有整数中出现多少个数字9。
		int i = 1;
		int count = 0;
		for(i = 1;i <= 100;i++){
			if(i%10==9){
				count++;
			}
			int tmp = i/10;
			if(tmp==9){
				count++;
			}
		}
		System.out.println(count);

		//9. 求出0～999之间的所有“水仙花数”并输出。(“水仙花数”是指一个三位数，其各位数字的立方和确好等于该数本
        //   身，如；153＝1＋5＋3?，则153是一个“水仙花数”。)
		//方法1
		int i = 0;
		for(i = 1;i <= 999;i++){
			int a = i/100;//百位
			int b = (i-a*100)/10;//十位
			int c = i-(a*100+b*10);//个位
			if(i==(a*a*a+b*b*b+c*c*c)){

			}
		}
		//方法2
		int i = 1;//百位
		int j = 1;//十位
		int k = 1;//个位
		for(i = 0;i <= 9;i++){
			for(j = 0;j <= 9;j++){
			    for(k = 0;k <= 9;k++){
			        if((i*100+j*10+k)==(i*i*i+j*j*j+k*k*k)){
					    System.out.println(i*100+j*10+k);
				    }
		        }
		    }
		}*/

//？？？？？？？？？？？10. 编写代码模拟三次密码输入的场景。 最多能输入三次密码，密码正确，提示“登录成功”,密码错误， 可以重新输
//    入，最多输入三次。三次均错，则提示退出程序
//序列的比较？
import java.util.Scanner;

public class Test{
    public static void main(String[] args) {
        int sec = 1005;
        int i = 1;
        for(i=1;i<3;i++){
            Scanner scan = new Scanner(System.in);
            System.out.println("请输入密码");
            int guess = scan.nextInt();
            scan.close();
            if(guess == sec){
                System.out.println("输入正确");
                break;
            }else {
                System.out.println("请重新输入");
            }

        }
        if(3 == i) {
            System.out.println("退出");
        }
    }
}


/*/public class Test {
    public static void main(String[] args) {
		/11. 写一个函数返回参数二进制中 1 的个数 比如： 15 0000 1111 4 个 1
		//方法1：磨2除2 缺点：只能对正数
		int a = 15;
		int count = 0;
		while(a != 0){
			if(a%2 == 1){
				count++;
			}
			a/=2;
		}
		System.out.println(count);
		//方法2：右移操作符 可以求负数,但效率低
		int a = -1;
	    int i = 1;
		int count = 0;
		for(i = 1;i <= 32;i++){
			if((a&1) == 1){
				count++;
			}
			a = a>>1;
		}
		System.out.println(count);
		//方法3：a&(a-1)  都能求，效率高
		int a = 35;
		int count = 0;
		while(a != 0){
			a = a&(a-1);
			count++;
		}
		System.out.println(count);
	}
}*/
/*//？？？？？？？？？？？？12. 获取一个数二进制序列中所有的偶数位和奇数位， 分别输出二进制序列。
//数组？？？
public class Test{
    public static void main(String[] args) {
        int[32] arr = {0};
    }
}*/

/*//13. 输出一个整数的每一位.
public class Test{
    public static void main(String[] args) {
        int a = 1234;
        func(a);
    }
    public static void func(int a) {
        if (a > 9) {
            func(a/10);
        }
        System.out.println(a %10);
    }
}*/

/*//14. 完成猜数字游戏
import java.util.Scanner;
import java.util.Random;

public class Test {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scan = new Scanner(System.in);//从键盘输入
        while(true){
            int guess = random.nextInt(100);
            System.out.println("输入要猜的数");
            int num = scan.nextInt();
            if(num<guess){
                System.out.println("小了");
            }else if(num > guess) {
                System.out.println("大了");
            }else {
                System.out.println("猜对了");
                break;
            }
        }
        scan.close();
    }
}*/