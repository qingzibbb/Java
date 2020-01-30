public class Test {
    public static void main(String[] args) {
        int[] nums = {1,3,5,7};
        int target = 8;
        //int ret = searchInsert1(nums,target);
        int ret = searchInsert1(nums,target);
        System.out.println(ret);
    }
    public static int searchInsert1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] >= target){
                return i;
            }
        }
        return nums.length;
    }
    public static int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        while (left < right){
            int mid = (left+right)+1;
            if(nums[mid] > target){
                right = mid-1;
            }else if(nums[mid] == target){
                return mid;
            }else {
                left = mid+1;
            }
        }
        return left;
    }
}
