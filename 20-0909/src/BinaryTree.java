class Node{
    public char value;
    public Node left;//节点地址
    public Node right;
    public Node(char value){
        this.value = value;
    }
}

public class BinaryTree {
    public Node createNode(){
        Node  a = new Node('a');
        Node  b = new Node('b');
        Node  c = new Node('c');
        Node  d = new Node('d');
        Node  e = new Node('e');
        Node  f = new Node('f');
        Node  g = new Node('g');
        Node  h = new Node('h');
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.left = f;
        c.right = g;
        e.right = h;
        return a;
    }
    //前序遍历
    void preOrderTraversal(Node root){
        if(root==null){
            return;
        }
        System.out.println(root.value+" ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }
}
