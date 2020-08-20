
/*import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                arr[i][j] = sc.nextInt();

            }
            sc.nextLine();
        }

        int max = path(arr);
        System.out.println(max);
    }

    public static int path(int[][] arr) {
        if(arr==null||arr.length<=0||arr[0].length<=0){
            return 0;
        }
        int m = arr.length;
        int n = arr[0].length;
        int max = 0;
        int[][] ml = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int tmp = find(arr,i,j,ml);
                if(max<tmp){
                    max = tmp;
                }
            }
        }
        return max;
    }

    private static int find(int[][] arr, int i, int j, int[][] ml) {
        if(ml[i][j]!=0){
            return ml[i][j];
        }
        int m = arr.length;
        int n = arr[0].length;
        int max = 0;
        if(j>0 && arr[i][j-1]>arr[i][j]){
            max = Math.max(max,find(arr,i,j-1,ml));
        }
        if(j<n-1 && arr[i][j+1]>arr[i][j]){
            max = Math.max(max,find(arr,i,j+1,ml));
        }
        if(i>0 && arr[i-1][j]>arr[i][j]){
            max = Math.max(max,find(arr,i-1,j,ml));
        }
        if(i<m-1 && arr[i+1][j]>arr[i][j]){
            max = Math.max(max,find(arr,i+1,j,ml));
        }
        ml[i][j] = max+1;
        return ml[i][j];
    }
}*/


import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        //arr[0]:G  arr[1]:Go  arr[2]:Goo  arr[3]:Good
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        if(s.length()==0){
            System.out.println(0);
            return;
        }
        int ret = 0;
        int[] arr = new int[4];
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='G'){
                arr[0]++;
            }
            if(s.charAt(i)=='o'){
                if(arr[1]>0){
                    arr[2]++;
                    arr[1]--;
                }
                if(arr[0]>0){
                    arr[1]++;
                    arr[0]--;
                }
            }
            if(s.charAt(i)=='d'){
                if(arr[2]>0){
                    ret++;
                    arr[2]--;
                }
            }
        }
        System.out.println(ret);
    }
}
