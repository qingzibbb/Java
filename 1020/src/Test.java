/*public class Test {
    public static int[] transform(int[] array){
        //将数组扩大两倍并返回，不能修改原数组
        int[] ret = new int[array.length];
        for (int i = 0; i <array.length ; i++) {
            ret[i] = array[i]*2;
        }
        return ret;
    }
    public static void print(int[] array){
        for (int x:array
             ) {
            System.out.print(x+" ");
        }
    }
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5};
        int[] ret = transform(array);
        print(array);
        System.out.printf("\n");
        print(ret);
    }
}*/

//模拟实现 Arrays.toString(array) ---字符串拼接
/*public class Test{
    public static String toString(int[] arr){
        String str = "[";
        for (int i = 0; i < arr.length; i++) {
            str += arr[i];
            if(i<arr.length-1){
                str += ",";
            }
        }
        str+="]";
        return str;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        System.out.println(toString(arr));
    }
}*/

/*public class Test{
    public static int findMax(int[] arr){
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]>max){
                max = arr[i];
            }
        }
        return max;
    }
    public static void main(String[] args) {
        //1、求数组中的最大值
        int[] arr = {1,2,3};
        int max = findMax(arr);
        System.out.println(max);
    }
}

/*public class Test{
    public static int findMin(int[] arr){
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]<min){
                min = arr[i];
            }
        }
        return min;
    }
    public static void main(String[] args) {
        //1、求数组中的最小值
        int[] arr = {1,2,3};
        int min = findMin(arr);
        System.out.println(min);
    }
}*/

/*public class Test{
    public static double arrAvg(int[] arr){
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[1];
        }
        return  (double)sum/(double)arr.length;
    }
    public static void main(String[] args) {
        //求数组平均值
        int[] arr = {1,2,3};
        double avg = arrAvg(arr);
        System.out.println(avg);
    }
}*/

/*import  java.util.Arrays;

public class Test{
    public static void reverse(int[] arr){
        int left = 0;
        int right = arr.length-1;
        if(left<right){
            int tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;
            left++;
            right--;
        }
        System.out.print(Arrays.toString(arr));
    }
    public static void main(String[] args) {
        //数组逆序
        int[] arr = {1,2,3};
        reverse(arr);
    }
}*/

import java.util.Arrays;

/*public class Test{
    public static int binarySearch(int[] arr,int key,int left,int right){
        if(left>right){
            return -1;
        }
        int mid = (left+right)>>1;
        if(arr[mid] == key){
            return mid;
        } else if(arr[mid]>key){
            right  = mid - 1;
            return binarySearch(arr,key,left,right);
        }else  {
            left = mid + 1;
            return binarySearch(arr,key,left,right);
        }
    }
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6};
        int key = 5;
        int left = arr[0];
        int right = arr[arr.length-1];
        //int k = binarySearch(arr,key,left,right);
        //int ret = Arrays.binarySearch(arr,3);
        int ret = Arrays.binarySearch(arr,0,4,4);
        System.out.println(ret);
    }
}*/

public class Test{
    public static void bubbleSort(int[] arr){
        for (int i = 0; i < arr.length-1; i++) {
            boolean flag = true;//每趟都要判断
            for (int j = 0; j < arr.length-1-i; j++) {
                if(arr[j]>arr[j+1]){
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                    flag = false;
                }
            }
            if(flag){
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}