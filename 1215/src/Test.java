import java.util.List;

public class Test {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        TreeNode root = binaryTree.buildTree();
        TreeNode tmp = binaryTree.find(root,'G');
        System.out.println(tmp.value);
    }
}
