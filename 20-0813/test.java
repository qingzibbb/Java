import java.util.*;

/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class PalindromeList {
    public boolean chkPalindrome(ListNode A) {
        if(A==null||A.next==null){
            return false;
        }
        ListNode slow = A;
        ListNode fast = A;
        while(fast!=null&&fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode cur = slow.next;
        
        while(cur!=null){
            ListNode curNext = cur.next;
            cur.next = slow;
            slow = cur;
            cur = curNext;
        }
        while(slow!=A){
            if(slow.val==A.val){
                slow = A.next;
                A = A.next;
            }else{
                return false;
            }
        }
        return true;
    }
}