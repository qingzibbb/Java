import java.util.Arrays;

public class Test {
    public static void main1(String[] args) {
        int x = 20;
        int y = 5;
        System.out.println(x+y +""+(x+y)+y);
    }

    public static void main2(String[] args) {
        String str1 = "ABc123";
        String str2 = toLowerCase(str1);
        System.out.println(str2+" ");
    }
    //字符串中的大写字母转换成小写字母
    public static String toLowerCase(String str) {
        char[] a = str.toCharArray();
        for (int i = 0; i < a.length; i++) {
            if(a[i] >='A' && a[i] <= 'Z'){
                a[i] += 32;
            }
        }
        return new String(a);
    }

    //将数组中的元素向右移动 k 个位置，其中 k 是非负数
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5};
        rotate(a,2);
        System.out.println(Arrays.toString(a));
    }
    public static void rotate(int[] nums, int k) {
        for (int i = 0; i < k; i++) {
            int b = nums[nums.length-1];
            for (int j = 0; j < nums.length; j++) {
                int tmp = nums[j];
                nums[j] = b;
                b = tmp;
            }
        }
    }
}
