import java.util.Arrays;
import java.util.Scanner;

public class Test {
        public static void main1 (String[]args){
            Scanner in = new Scanner(System.in);
            String str1 = in.nextLine();
            String str2 = in.nextLine();
            int count = 0;

            for (int i = 0; i <= str1.length(); i++) {
                StringBuilder sb = new StringBuilder(str1);
                sb.insert(i, str2);
                if (isHuiwen(sb.toString())) {
                    count++;
                }
            }
            System.out.print(count);
        }


    private static boolean isHuiwen(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main2(String[] args) {
        int[] arr = {1,3,7,9,4,2,6,5,1};
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort(int[] arr, int low, int high) {
            if(low>high)return;
            int left = low;
            int right = high;
            int t = arr[low];//每次的基准
            while (left<right){
                //先从右边开始 不然左边肯定小于右边
                while (left<right&&arr[right]>=t){
                    right--;
                }
                while (left<right&&arr[left]<=t){
                    left++;
                }
                if(left<right){
                    int tmp = arr[left];
                    arr[left] = arr[right];
                    arr[right] = tmp;
                }
            }
        arr[low] = arr[left];
        arr[left] = t;

        quickSort(arr,low,right-1);
            quickSort(arr,right+1,high);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        while (sc.hasNext()){
            n = sc.nextInt();
            if(n==0){
                break;
            }
            int count = drink(n);
            System.out.println(count);
        }
    }

    private static int drink(int n) {
        int count = 0;

        while (n>=3){
            count+=n/3;
            n = n%3+n/3;
        }
        if(n==2){
            count++;
        }
        return count;
    }
}