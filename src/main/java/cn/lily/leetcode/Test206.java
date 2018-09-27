package cn.lily.leetcode;

public class Test206 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
        @Override
        public String toString(){
            return this.val + " ";
        }
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode pre = null;
        ListNode cur = head;
        ListNode next = head.next;
        while (next != null){
            cur.next = pre;
            pre = cur;
            cur = next;
            next = cur.next;
            cur.next = null;
        }
        cur.next= pre;
        return cur;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);
        root.next.next.next.next = new ListNode(5);
        ListNode head = reverseList(root);
        while (head != null){
            System.out.print(head);
            head = head.next;
        }

    }
}
