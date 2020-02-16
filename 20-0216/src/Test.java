import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] array = {12,5,9,34,6,8,33,56,89,0,7,4,55,22,77};
        System.out.println(Arrays.toString(array));
        mergeSort(array);
        System.out.println(Arrays.toString(array));

    }
    public static void mergeSortInternal(int[] array,int low,int high){
        if(low>=high) return;
        int mid = (low+high)/2;
        mergeSortInternal(array,0,mid);
        mergeSortInternal(array,mid+1,high);
        //合并
        merge(array,low,mid,high);
    }

    private static void merge(int[] array, int low, int mid, int high) {
        int[] tmpArr = new int[high-low+1];
        int i = 0;//新数组下标
        int s1 = low;
        int s2 = mid+1;
        while (s1<=mid && s2<=high){
            if(array[s1]<array[s2]){
                tmpArr[i++] = array[s1++];
            }else {
                tmpArr[i++] = array[s2++];
            }
        }
        //注意等于
        while (s1<=mid){
            tmpArr[i++] = array[s1++];
        }
        while (s2<=high){
            tmpArr[i++] = array[s2++];
        }
        //将tmpArr放回原来数组里
        for (int j = 0; j < tmpArr.length; j++) {
            array[low+j] = tmpArr[j];
        }
    }

    public static void mergeSort(int[] array){
        mergeSortInternal(array,0,array.length-1);
    }
}
