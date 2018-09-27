package cn.lily.leetcode;

public class Test234 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null){
            return true;
        } else if(head.next.next == null){
            if (head.val == head.next.val){
                return true;
            }
            return false;
        }
        ListNode root = new ListNode(-1);
        root.next = head;
        ListNode fast = root;
        ListNode slow = root;
        int count = 0;
        while (fast.next != null && fast.next.next!= null){
            slow = slow.next;
            fast = fast.next.next;
            count++;
        }
        if (fast.next == null){
            fast = slow.next;
        } else {
            fast = slow.next.next;
        }
        slow = root;
        while (count > 0){
            for (int i = 0; i < count; i++) {
                slow = slow.next;
            }
            if (slow.val == fast.val){
                slow = root;
                fast = fast.next;
                count--;
            } else {
                return false;
            }
        }
        if (count == 0){
            return  true;
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(2);
        root.next.next.next = new ListNode(1);
        //root.next.next.next.next = new ListNode(1);
        ListNode temp = null;
        System.out.println(isPalindrome(root));
    }
}
