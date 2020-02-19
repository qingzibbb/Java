import java.util.HashSet;
import java.util.Set;

public class TestBinaryTree {
    static class Node {
        public int data;
        public Node left;
        public Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public Node root = null;

    public void insert(int key) {
        Node node = new Node(key);
        if(root==null){
            root = node;
            return;
        }
        //找叶子结点
        Node cur = root;
        Node parent = cur;
        while (cur!= null){
            if(cur.data>key){
                parent = cur;
                cur = cur.left;
            }else if(cur.data<key) {
                parent = cur;
                cur = cur.right;
            } else {
                return;
            }
        }
        //插入
        if(parent.data>key){
            parent.left = node;
        }else {
            parent.right = node;
        }
    }

    public void inOrder(Node root){
        if(root==null){
            return;
        }
        inOrder(root.left);
        System.out.println(root.data);
        inOrder(root.right);
    }
    //查找   key
    public Node search1(int key) {
        Node cur = root;
        while (cur!= null){
            if(cur.data>key){
                cur = cur.left;
            }else if(cur.data<key) {
                cur = cur.right;
            } else {
                return cur;
            }
        }
        return null;
    }

    public void removeNode(Node parent,Node cur){

        if(cur.left == null) {
            if(cur == root) {
                root = cur.right;
            }else if(cur == parent.left){
                parent.left = cur.right;
            }else {
                parent.right = cur.right;
            }
        }else if(cur.right == null) {
            if(cur == root) {
                root = cur.left;
            }else if(cur == parent.left){
                parent.left = cur.left;
            }else {
                parent.right = cur.left;
            }
        }else {
            Node targetParent = cur;//替罪羊的父亲
            Node target = cur.right;
            while (target.left!= null){
                targetParent = target;
                target = target.left;
            }
            //替换
            cur.data = target.data;
            //target左边肯定是空的
            if(target==targetParent.left){
                targetParent.left = target.right;
            }else {
                targetParent.right = target.right;
            }
        }
    }
    public int singleNumber(int[] nums){
        Set<Integer> set = new HashSet<>();
        for (int i:nums) {
            if(set.contains(i)){
                set.remove(i);
            }else {
                set.add(i);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if(set.contains(nums[i])){
                return nums[i];
            }
        }
        return -1;
    }
}
