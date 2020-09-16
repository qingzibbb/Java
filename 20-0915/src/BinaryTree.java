/*
class TreeNode{
    int data;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int data){
        this.data = data;
    }
}
public class BinaryTree {
    int getKLevelTree(TreeNode root,int k){
        if(root==null||k<=0){
            return 0;
        }
        if(k==1){
            return 1;
        }
        return getKLevelTree(root.left,k-1)+getKLevelTree(root.right,k-1);
    }

    int getHeight(TreeNode root){
        if(root==null){
            return 0;
        }
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        return leftHeight>rightHeight?leftHeight+1:rightHeight+1;
    }

    TreeNode find(TreeNode root,int val){
        if(root==null){
            return null;
        }
        if(root.data==val){
            return root;
        }
        TreeNode ret = find(root.left,val);
        if(ret!=null){
            return ret;
        }
        ret = find(root.right,val);
        if(ret!=null){
            return ret;
        }
        return null;
    }

    public boolean isSameTree(TreeNode p,TreeNode q){
        if((p==null&&q!=null)||(p!=null&&q==null)){
            return false;
        }
        if(p==null&&q==null){
            return true;
        }
        if(p.data!=q.data){
            return false;
        }
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }

    public boolean isSubtree(TreeNode root){

    }
}*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class BinaryTree{
    /*static int[] primeFactorization(int num) {
        int[] zs;
        if(num<=3){
            zs = new int[1];
            zs[0] = num;
            return zs;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 2; i <= num; i++) {
            if(num%i==0){
                list.add(i);
                num = num/i;
                i=1;
            }
        }
        zs = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            zs[i] = list.get(i);
        }
        return zs;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] res;

        int _num;
        _num = Integer.parseInt(in.nextLine().trim());

        res = primeFactorization(_num);
        for(int res_i=0; res_i < res.length; res_i++) {
            System.out.println(String.valueOf(res[res_i]));
        }
    }*/

    public static boolean exist(char[][] b,String word){
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                int[][] v = new int[b.length][b[0].length];
                if(isExist(b,word,i,j,0,v)){
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isExist(char[][] b, String word, int i, int j, int index, int[][] v) {
        if(i<0||i>b.length||j<0||j>=b[0].length){
            return false;
        }
        if(b[i][j]!=word.charAt(index)||v[i][j]==1){
            return false;
        }
        if(index==word.length()-1){
            return true;
        }
        v[i][j] = 1;
        if(isExist(b,word,i-1,j,index+1,v)||
                isExist(b,word,i+1,j,index+1,v)||
                        isExist(b,word,i,j-1,index+1,v)||
                                isExist(b,word,i,j+1,index+1,v)
                ){
            return true;
        }else
            v[i][j]=0;
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String,String> map = new HashMap<>();
        boolean flag = true;
        String e = new String();

        while (flag){
            String s = sc.nextLine();
            if(!s.contains(",")){
                flag = false;
                e = s;
                break;
            }

            String[] arr = s.split(",");
            for (int j = 0;j<arr.length;j++){
                String m = arr[j];
                if(map.containsKey(m)){
                    map.put(m,map.get(m)+1);
                }else{
                    map.put(m,1);
                }
            }
        }
    }
}






















