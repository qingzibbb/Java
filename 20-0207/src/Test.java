import java.util.Arrays;
import java.util.Stack;

public class Test {
    public static void main(String[] args) {
        int[] digits = {9,9,9,9};
        int[] ret1 = plusOne(digits);
        System.out.println(Arrays.toString(ret1));

        int[] nums = {1,1,7,10,10};
        int target = 9;
        //int[] ret2 = twoSum(nums,target);
        //System.out.println(Arrays.toString(ret2));

        String a = "1011";
        String b = "1001";
        //String ret3 = addBinary(a,b);
        //System.out.println(ret3);

//        int[] nums1 = {1,2,2,3,3,4,5};
//        int target1 = 3;
//        int[] ret2 = searchRange(nums1,target1);
//        System.out.println(Arrays.toString(ret2));

        String s = "abcdefedcba";
        Boolean ret3 = isPalindrome(s);
        System.out.println(ret3);

        char[] chars = {'a','a','b','b','b','c','d','d'};
        int ret4 = compress(chars);

    }
    public static int[] plusOne(int[] digits) {
        for (int i = digits.length-1; i >=0 ; i--) {
            digits[i]++;
            digits[i]%=10;
            if(digits[i]!=0) return digits;
        }
        digits = new int[digits.length+1];
        digits[0]=1;
        return digits;
    }
    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if(nums[i]+nums[j]==target) return new int[]{i,j};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
//    public static String addBinary(String a, String b) {
//
//    }

    public static String reverseOnlyLetters(String S) {
        Stack<Character> letters = new Stack<>();
        for (char c:S.toCharArray()
             ) {
            if(Character.isLetter(c)){
                letters.push(c);
            }
        }
        StringBuilder ret = new StringBuilder();
        for (char c:S.toCharArray()
             ) {
            if(Character.isLetter(c)){
                ret.append(letters.pop());
            }else {
                ret.append(c);
            }
        }
        return ret.toString();
    }
//    public static int[] searchRange(int[] nums, int target) {
//
//    }

    public static boolean isPalindrome(String s) {
        s = s.toLowerCase();
        StringBuilder ret = new StringBuilder();
        for (char c:s.toCharArray()
             ) {
            if((c>='0'&c<='9')||(c>='a'&&c<='z')){
                ret.append(c);
            }
        }
        char[] character = ret.toString().toCharArray();
        int left = 0;
        int right = character.length-1;
        if(s.isEmpty()) return true;
        while (left<right) {
            if (character[left] != character[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    public static int compress(char[] chars) {
        int anchor = 0;//每块的开始位置
        int write = 0;//原数组上重新覆盖的下标
        //i一直走 每次停在每块结束的位置
        for (int i = 0; i < chars.length; i++) {
            if(i==chars.length-1||chars[i]!=chars[i+1]){//停止条件，第一个条件放前面
                chars[write] = chars[anchor];
                write++;
                if(i>anchor){
                    for (char c:(""+(i-anchor+1)).toCharArray()
                         ) {
                        chars[write] = c;
                        write++;
                    }
                }
                anchor = i+1;
            }
        }
        return write;
    }
}
