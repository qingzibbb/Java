public class 单例模式之饿汉模式 {
    private static 单例模式之饿汉模式 instance = new 单例模式之饿汉模式();


    private 单例模式之饿汉模式(){
    }

    public static 单例模式之饿汉模式 getInstance(){
        return instance;
    }

    public static void main(String[] args) {
        单例模式之饿汉模式 ins1 = 单例模式之饿汉模式.getInstance();
        单例模式之饿汉模式 ins2 = 单例模式之饿汉模式.getInstance();
        单例模式之饿汉模式 ins3 = 单例模式之饿汉模式.getInstance();

        System.out.println(ins1==ins2);
        System.out.println(ins2==ins3);
    }
}
