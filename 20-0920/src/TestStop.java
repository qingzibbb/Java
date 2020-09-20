/*
public class TestStop{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            if(!map.containsKey(s1.charAt(i))){
                map.put(s1.charAt(i),1);
            }else{
                map.put(s1.charAt(i),map.get(s1.charAt(i))+1);
            }
        }

        int count = 0;
        for (int i = 0; i < s2.length(); i++) {
            if(map.containsKey(s2.charAt(i))&&map.get(s2.charAt(i))>=1){
                count++;
                map.put(s2.charAt(i),map.get(s2.charAt(i))-1);
            }
        }
        System.out.println(count);
    }
}*/

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TestStop implements Runnable{
    //设置一个标志位
    private boolean flag = true;

    @Override
    public void run() {
        int i = 0;
        while (flag){
            System.out.println("run……Thread"+i++);
        }
    }

    public void stop(){
        this.flag = false;
    }
    //设置一个公开的方法停止线程，转换标志位
    public static void main(String[] args) {
        TestStop testStop = new TestStop();
        new Thread(testStop).start();

        for (int i = 0; i < 1000; i++) {
            System.out.println("main"+i);
            if(i==900){
                //调用stop方法，切换标志位，让线程停止
                testStop.stop();
                System.out.println("线程停止");
            }
        }
    }
}
