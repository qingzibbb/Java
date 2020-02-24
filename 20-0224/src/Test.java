public class Test {
    public static void main(String[] args) {

    }
    public boolean Find(int target, int [][] array) {
        if (array == null || array.length == 0 || (array.length == 1 && array[0].length == 0)) {
            return false;
        }
        for (int i = array.length-1; i >= 0 ; i--) {
            if(array[i][0]<target){
                for (int j = 0; j < array[0].length; j++) {
                    if(array[i][j]==target){
                        return true;
                    }
                }
            }
            if(array[i][0]==target){
                return true;
            }
        }
        return false;
    }


}
