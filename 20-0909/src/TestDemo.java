public class TestDemo {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        Node root = binaryTree.createNode();
        binaryTree.preOrderTraversal(root);
    }
}
