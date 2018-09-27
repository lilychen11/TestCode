package cn.lily.leetcode;

public class Test21 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return this.val + " ";
        }
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2){
        if (l1 == null){
            return l2;
        }
        if (l2 == null){
            return l1;
        }
        ListNode head = new ListNode(0);
        ListNode root = head;
        while (l1 != null && l2 != null){
            if (l1.val <= l2.val){
                root.next = l1;
                l1 = l1.next;
                root = root.next;
            } else {
                root.next = l2;
                l2 = l2.next;
                root = root.next;
            }
        }
        if (l1 != null){
            root.next = l1;
        }
        if(l2 != null){
            root.next = l2;
        }
        return head.next;
    }
}
