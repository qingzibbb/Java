import java.util.Arrays;

public class Sort {
    public static void insertSort(int[] array){
        for (int i = 1; i < array.length; i++) {
            int tmp = array[i];
            int j = 0;
            for (j = i-1;j>=0;j--){
                if(array[j] > tmp){
                    array[j+1] = array[j];
                }else {
                    break;
                }
            }
            array[j+1] = tmp;
        }
    }

    public static void selectSort(int[] array){
        for (int i = 0; i < array.length; i++) {
            for (int j = i+1; j < array.length; j++) {
                if(array[i]>array[j]){
                    int tmp = array[i];
                    array[i] = array[j];
                    array[j] = tmp;
                }
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = {1,3,5,7,2,4,6,8};
        //insertSort(arr);
        selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
