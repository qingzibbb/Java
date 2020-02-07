import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] A = {1,2,3,4,5};
        int[] ret1 = sortArrayByParity(A);
        System.out.println(Arrays.toString(ret1));

        int[] nums = {1,2,1};
    }
    public static int[] sortArrayByParity(int[] A) {
        int left = 0;
        int right = A.length-1;
        while (left<right){
            while (left<right&&A[left]%2!=1){
                left++;
            }
            while (left<right&&A[right]%2!=0){
                right--;
            }
            if(A[left]%2==1&&A[right]%2==0){
                int ret = A[left];
                A[left] = A[right];
                A[right] = ret;
            }
        }
        return A;
    }
    public static int pivotIndex(int[] nums) {
        int sum = 0;
        int leftSum = 0;
        for (int x:nums
             ) {
            sum+=x;
        }
        for (int i = 0; i < nums.length; i++) {
            if(leftSum==sum-leftSum-nums[i]){
                return i;
            }
            leftSum+=nums[i];
        }
        return -1;
    }

}
