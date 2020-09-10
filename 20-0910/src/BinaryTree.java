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
        System.out.print(root.value+" ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    void inOrderTraversal(Node root){
        if(root==null){
            return;
        }
        preOrderTraversal(root.left);
        System.out.print(root.value+" ");
        preOrderTraversal(root.right);
    }

    int getSize1(Node root){
        if(root==null){
            return 0;
        }
        return getSize1(root.left)+getSize1(root.right)+1;
    }

    static int size = 0;
    void getSize2(Node root){
        if(root==null){
            return;
        }
        size++;
        getSize2(root.left);
        getSize2(root.right);
    }

    int getLeafSize1(Node root){
        if(root==null){
            return 0;
        }
        if(root.left==null&&root.right==null){
            return 1;
        }else {
            return getLeafSize1(root.left)+getLeafSize1(root.right);
        }
    }

    static int leafSize = 0;
    void getLeafSize2(Node root){
        if(root==null){
            return;
        }
        if(root.left==null&&root.right==null){
            leafSize++;
            return;
        }else {
            getLeafSize2(root.left);
            getLeafSize2(root.right);
        }
    }

    int getKLevelSize(Node root,int k){
        if(k==0||root==null){
            return 0;
        }
        if(k==1){
            return 1;
        }
        return getKLevelSize(root.left,k-1)+getKLevelSize(root.right,k-1);
    }


}

