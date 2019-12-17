public class Test {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        TreeNode root = binaryTree.buildTree();
        //binaryTree.inOrderTraversalNor(root);
        binaryTree.levelOrderTraversal(root);
    }
}
