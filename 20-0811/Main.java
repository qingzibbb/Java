/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class Solution {
    public ListNode FindKthToTail(ListNode head,int k) {
        if(head==null||k<=0){
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(k>1){
            if(fast.next!=null){
                fast = fast.next;
                k--;
            }else{
                return null;
            }
        }
        while(fast.next!=null){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}