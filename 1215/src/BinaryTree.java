import java.util.ArrayList;
import java.util.List;

class TreeNode {
    char value;
    TreeNode left;
    TreeNode right;
    public TreeNode(char value) {
        this.value = value;
    }
}
public class BinaryTree {

    public BinaryTree() {
    }

    public TreeNode buildTree() {
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
    void preOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.value + " ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    // 中序遍历
    void inOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrderTraversal(root.left);
        System.out.print(root.value + " ");
        inOrderTraversal(root.right);
    }

    // 后序遍历
    void postOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.value + " ");
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        List<Integer> list1 = inorderTraversal(root.left);
        list.addAll(list1);
        System.out.print(root.value + " ");
        //list.add(root.value);
        List<Integer> list2 = inorderTraversal(root.right);
        list.addAll(list2);
        return list;
    }

    public int getLeafSize(TreeNode root) {
        if (root == null) {
            return 0;
        } else if (root.left == null && root.right == null) {
            return 1;
        }
        return getLeafSize(root.left) + getLeafSize(root.right);
    }

    public int getKLevelSize(TreeNode root,int k){
        if(k == 1){
            return 1;
        }
        if(root == null){
            return 0;
        }
        return getKLevelSize(root.left,k-1)+getKLevelSize(root.right,k-1);
    }

    public TreeNode find(TreeNode root,int val){
        if(root == null){
            return null;
        }
        if(root.value == val){
            return root;
        }
        TreeNode tmp = find(root.left,val);
        if(tmp != null){
            return tmp;
        }
        tmp = find(root.right,val);
        if(tmp != null){
            return tmp;
        }
        return null;
    }

}