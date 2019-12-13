public class Test {
    public static void main1(String[] args) {
        int[] arr = {1,2,3,4};
        try {
            System.out.println(arr[3]);
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("捕获到了异常");
        }
        System.out.println("after");
    }

    public static void main2(String[] args) {
        int[] arr = {1,2,3,4};
        try {
            arr = null;
            System.out.println(arr[4]);
        }catch (ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
            System.out.println("捕获到了数组越界异常");
        }catch (NullPointerException e){
            e.printStackTrace();
            System.out.println("捕获到了空指针异常");
        }
        System.out.println("after");
    }

    public static void main3(String[] args) {
        int[] arr = {1,2,3,4};
        try {
            arr = null;
            System.out.println(arr[4]);
        }catch (ArrayIndexOutOfBoundsException | NullPointerException e){
            e.printStackTrace();
            System.out.println("捕获到了异常");
        }
        System.out.println("after");
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        try {
            arr = null;
            System.out.println(arr[4]);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("捕获到了异常");
        }
        System.out.println("after");
    }
}
