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
}
