public class Test {
    public static void main(String[] args) {
        int[] nums = {1,2,2,3,3,4,5,3};
        //int a = removeElement1(nums,3);
        int a = removeElement2(nums,3);
        System.out.println(a);
    }
    public static int removeElement1(int[] nums, int val) {
        int i= 0;
        for (int j = 0; j < nums.length; j++) {
            if(nums[j] != val){
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

    public static int removeElement2(int[] nums, int val) {
        int l = nums.length;
        int i = 0;
        while (i < l){
            if(nums[i] == val){
                nums[i] = nums[l-1];
                l--;
            }else {
                i++;
            }
        }
        return l;
    }
}

