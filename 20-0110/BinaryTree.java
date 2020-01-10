import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class TreeNode{
    char value;
    TreeNode left;
    TreeNode right;
    public TreeNode(char value){
        this.value = value;
    }
}
class BinaryTree {
    public TreeNode buildTree(){
        TreeNode root = new TreeNode('A');
        TreeNode B = new TreeNode('B');
        TreeNode C = new TreeNode('C');
        TreeNode D = new TreeNode('D');
        TreeNode E = new TreeNode('E');
        TreeNode F = new TreeNode('F');
        TreeNode G = new TreeNode('G');
        TreeNode H = new TreeNode('H');
        root.left = B;
        root.right = C;
        B.left = D;
        B.right = E;
        E.right = H;
        C.left = F;
        C.right = G;
        return root;
    }

    // 前序遍历
    List<Character> preOrderTraversal(TreeNode root){
        List<Character> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        //System.out.print(root.value + " ");
        list.add(root.value);
        List<Character> left = preOrderTraversal(root.left);
        list.addAll(left);
        List<Character> right = preOrderTraversal(root.right);
        list.addAll(right);
        return list;
    }


    // 遍历思路-求结点个数
    static int size = 0;
    void getSize1(TreeNode root){
        if(root == null){
            return;
        }
        size++;
        getSize1(root.left);
        getSize1(root.right);
    }

    // 子问题思路-求结点个数 左子树个数+右子树个数+1
    int getSize2(TreeNode root){
        if(root == null){
            return 0;
        }
        return getSize2(root.left)+getSize2(root.right)+1;
    }

    // 遍历思路-求叶子结点个数
    static int leafSize = 0;
    void getLeafSize1(TreeNode root){
        if (root == null){
            return;
        }
        if(root.left == null && root.right == null){
            leafSize++;
        }
        getLeafSize1(root.left);
        getLeafSize1(root.right);
    }
    //求叶子结点个数
    int getLeafSize2(TreeNode root){
        if(root == null){
            return 0;
        }else if(root.left == null && root.right == null){
            return 1;
        }
        return getLeafSize2(root.left)+getLeafSize2(root.right);
    }

    //  子问题思路-求第 k 层结点个数 ;
    int getKLevelSize(TreeNode root,int k){
        if(root == null){
            return 0;
        }
        if(k == 1){
            return 1;
        }
        return getKLevelSize(root.left,k-1)+getKLevelSize(root.right,k-1);
    }

    // 查找 val 所在结点，没有找到返回 null
    // 按照 根 -> 左子树 -> 右子树的顺序进行查找
    // 一旦找到，立即返回，不需要继续在其他位置查找
    TreeNode find(TreeNode root, int val){
        if(root == null){
            return null;
        }
        if(root.value == val){
            return root;
        }
        TreeNode ret = find(root.left,val);
        if(ret != null){
            return ret;
        }
        ret = find(root.right,val);
        if(ret != null){
            return ret;
        }
        return null;
    }

    //相同的树
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if((p == null && q != null)||(p != null && q == null)){
            return false;
        }
        if(p == null & q == null){
            return true;
        }
        if(p.value != q.value){
            return false;
        }
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }

    //t是否为S的子树
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s == null || t == null){
            return false;
        }
        if(isSameTree(s,t)){
            return true;
        }
        if(isSubtree(s.left,t)){
            return true;
        }
        if(isSubtree(s.right,t)){
            return true;
        }
        return false;
    }
}