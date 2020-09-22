public class UnsafeBank {

    public static void main(String[] args) {
        Account account = new Account(100,"结婚基金");
        Drawing you = new Drawing(account,50,"你"+);
    }
}
class Account{
    int money;//余额
    String name;//卡名

    //账户
    public Account(int money, String name) {
        this.money = money;
        this.name = name;
    }



}
//银行：模拟取款
class Drawing extends Thread{
    Account account;
    int drawingMoney;
    int nowMoney;
    public Drawing(Account account,int drawingMoney,int nowMoney){
        this.account = account;
        this.drawingMoney = drawingMoney;
        this.nowMoney = nowMoney;
    }
    public void run(){
        if(account.money-drawingMoney<0){
            System.out.println(Thread.currentThread().getName()+"钱不够，取不了");
        }

        account.money = account.money-drawingMoney;
        nowMoney = nowMoney+drawingMoney;
        System.out.println(account.name+"余额为："+account.money);
        System.out.println(this.getName()+"手里的钱"+nowMoney);
    }
}
