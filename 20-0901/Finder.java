import java.util.*;

public class Finder {
    public int findKth(int[] a, int n, int K) {
        return findKth(a,0,n-1,K);
    }
    public int findKth(int[] a, int low, int high, int K) {
        int flag = quickSort(a,low,high);
        
        if(flag-low == K-1){
            return a[flag];
        }else if(flag-low > K-1){
            return findKth(a,low,flag-1,K);
        }else{
            return findKth(a,flag+1,high,K-flag+low-1);
        }
    }
    public int quickSort(int[] a,int low,int high){
        int key = a[low];
        while(low<high){
            while(low<high&&a[high]<=key){
                high--;
            }
            a[low]= a[high];
            while(low<high&&a[low]>=key){
                low++;
            }
            a[high]= a[low];
        }
        a[low] = key;
        return low;
    }
}