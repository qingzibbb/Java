import java.util.*;

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

    List<Character> inOrderTraversalNor(TreeNode root){
        List<Character> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.empty()){
            while (cur!= null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            list.add(cur.value);
            cur = cur.right;
        }
        return list;
    }

    void levelOrderTraversal(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        if(root != null){
            queue.offer(root);
        }
        while(!queue.isEmpty()){
            TreeNode cur = queue.poll();
            System.out.print(cur.value+ " ");
            if(cur.left != null){
                queue.offer(cur.left);
            }
            if(cur.right != null){
                queue.offer(cur.right);
            }
        }
    }
}
