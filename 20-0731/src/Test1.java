public class Test1 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,3,2,1};
        int a = find(arr);
        System.out.println(a);
    }

    private static int find(int[] arr) {
        int ret = 0;
        for (int a:arr) {
            ret^=a;
        }
        return ret;
    }
}
