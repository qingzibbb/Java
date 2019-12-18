import java.util.LinkedList;
import java.util.List;

public class TestDemo {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();

        TreeNode root = binaryTree.buildTree();

        List<Character> a = binaryTree.preOrderTraversal(root);
        System.out.println(a);

        binaryTree.getSize1(root);
        System.out.println(BinaryTree.size);
        int size = binaryTree.getSize2(root);
        System.out.println(size);

        int leafSize = binaryTree.getLeafSize2(root);
        System.out.println(leafSize);
        binaryTree.getLeafSize1(root);//先调用在使用
        System.out.println(BinaryTree.leafSize);

        int count = binaryTree.getKLevelSize(root,2);
        System.out.println(count);

        TreeNode ret = binaryTree.find(root,'G');
        System.out.println(ret.value);
    }
}
