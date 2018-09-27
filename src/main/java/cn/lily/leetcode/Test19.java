package cn.lily.leetcode;

public class Test19 {
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

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (n <= 0) {
            return null;
        }
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        ListNode node = newHead;
        while (n > 0) {
            node = node.next;
            n--;
        }
        ListNode nHead = newHead;
        while (node.next != null) {
            nHead = nHead.next;
            node = node.next;
        }
        nHead.next = nHead.next.next;
        return newHead.next;
    }

    public static ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        for (int i = 0; i < n; i++) {
            first =  first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        int n = 1;
        ListNode head1 = new ListNode(10);
        System.out.println(removeNthFromEnd(head1, n));
    }

}
