public class Sort {
    public static int partion(int[] array,int start,int end){
        int tmp = array[start];
        while (start < end){
            while (start < end && array[end] >= tmp){//注意前后顺序，否则数组越界异常
                end--;
            }
            if (start >= end){
                break;
            }else {
                array[start] = array[end];
            }
            while (start < end && array[end] <= tmp){
                start++;
            }
            if (start >= end){
                break;
            }else {
                array[end] = array[start];
            }
        }
        array[start] = tmp;
        return start;
    }
}
