//class ListNode{
//    public int data;
//    public ListNode next;
//    public ListNode(int data){
//        this.data = data;
//        this.next = null;
//    }
//}
//class MySingleList {
//     ListNode head;
//    public MySingleList(){
//        this.head = null;
//    }
//
//    public ListNode reverseList(){
//        ListNode newHead = new ListNode(-1);
//        ListNode prev = this.head;
//        ListNode cur = this.head.next;
//        while (cur != null){
//            ListNode curNext = cur.next;
//            if(curNext == null){
//                newHead = cur;
//            }
//            cur.next = prev;
//            cur = cur.next;
//            prev = prev.next;
//        }
//        return  newHead;
//    }
//}
