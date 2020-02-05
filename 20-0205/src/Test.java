import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int x = 1002320016;
        boolean ret = isPalindrome(x);
        System.out.println(ret);

        String a = "hello world";
        int len = lengthOfLastWord(a);
        System.out.println(len);

        int[] nums1 ={1,3,5,7};
        int[] nums2 ={2,4,6,8,9,10};
        //merge(nums1,nums1.length,nums2,nums2.length);
        System.out.println(Arrays.toString(nums1));

        int[] nums = {1,2,5,7,6};
        boolean ret3 = containsDuplicate(nums);
        System.out.println(ret3);

        int[] A = {1,-1,3,8,-5};
        int[] ret4 = sortedSquares(A);
        System.out.println(Arrays.toString(ret4));
    }

    public static boolean isPalindrome1(int x) {
        String reverseStr = (new StringBuffer(x + "")).reverse().toString();
        return (x + "").equals(reverseStr);
    }

    public static boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int reverseNumber = 0;
        while (x > reverseNumber) {
            reverseNumber = reverseNumber * 10 + x % 10;
            x /= 10;
        }
        return x == reverseNumber || x == reverseNumber / 10;
    }

    public static int lengthOfLastWord(String s) {
        if(s.length()==0){
            return 0;
        }
        int end = s.length()-1;//最后一个单词的末尾位置
        while (end>=0 && s.charAt(end)==' '){
            end--;
        }
        int start = end;//最后一个单词的开始位置
        while (start>=0 && s.charAt(start)!=' '){
            start--;
        }
        return end-start;
    }
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int len1 = m-1;
        int len2 = n-1;
        int len = m+n-1;
        while (len1>=0 && len2>=0){
            nums1[len--] = nums1[len1] > nums2[len2] ? nums1[len1--]:nums2[len2--];
        }
        System.arraycopy(nums2,0,nums1,0,len2+1);
    }
    public static boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-1; i++) {
            if(nums[i] == nums[i+1]){
                return true;
            }
        }
        return false;
    }
    public static int[] sortedSquares(int[] A) {
        for (int i = 0; i < A.length; i++) {
            A[i] *= A[i];
        }
        Arrays.sort(A);
        return A;
    }
}