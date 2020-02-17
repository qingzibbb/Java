import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] array = {12,5,9,34,6,8,33,56,89,0,7,4,22,55,77};
        System.out.println(Arrays.toString(array));
        mergeSort(array);
        System.out.println(Arrays.toString(array));
    }
    public static void mergeSort(int[] array){
        for (int i = 1; i < array.length; i*=2) {
            merge(array,i);
        }
    }

    private static void merge(int[] array, int gap) {
        int[] tmpArr = new int[array.length];
        int k = 0;//临时数组下标
        //分组 订每两个组的左右下标
        int s1 = 0;
        int e1 = s1+gap-1;
        int s2 = e1+1;
        int e2 = s2+gap-1<array.length?s2+gap-1:array.length-1;

        while (s2<array.length){
            while (s1<=e1&&s2<=e2){
                if(array[s1]<=array[s2]){
                    tmpArr[k++] = array[s1++];
                }else {
                    tmpArr[k++] = array[s2++];
                }
            }
            while (s1<=e1){
                tmpArr[k++] = array[s1++];
            }
            while (s2<=e2){
                tmpArr[k++] = array[s2++];
            }
            s1 = e2+1;
            e1 = s1+gap-1;
            s1 = e1+1;
            e2 = s2+gap-1<array.length?s2+gap-1:array.length-1;
        }
        //判断是不是还有一个归并段，且这个归并段一定是s1那个段
        while (s1<=array.length-1){
            tmpArr[k++]=array[s1++];
        }
        for (int i = 0; i < tmpArr.length; i++) {
            array[i] = tmpArr[i];
        }
    }
}
