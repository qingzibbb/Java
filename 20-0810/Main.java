public class Solution {
    public void reOrderArray(int [] array) {
        int k = 0;
        if(array==null||array.length==0){
            return;
        }
        for(int i = 0;i<array.length;i++){
            if((array[i]&1)==1){
                int tmp = array[i];
                int j = i;
                while(j>k){
                    array[j]= array[j-1];
                    j--;
                }
                array[k++]=tmp;
            }
        }
    }
}