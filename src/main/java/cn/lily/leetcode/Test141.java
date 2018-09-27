package cn.lily.leetcode;

public class Test141 {
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
    public boolean hasCycle(ListNode head){
        if (head == null || head.next == null){
            return false;
        }
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null && slow != fast){
            slow = slow.next;
            fast = fast.next.next;
        }

        if (slow == fast){
            return true;
        }
        return false;
    }
}
