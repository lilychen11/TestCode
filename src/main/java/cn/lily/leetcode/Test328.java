package cn.lily.leetcode;

public class Test328 {
    public static ListNode oddEvenList(ListNode head){
        ListNode node = head;
        ListNode even = new ListNode(0);
        ListNode nodeEven = even;
        while (node.next!= null && node.next.next!= null){
            nodeEven.next = node.next;
            nodeEven = nodeEven.next;
            node.next = node.next.next;
            node = node.next;
            nodeEven.next = null;
        }
        if (node.next != null){
            nodeEven.next = node.next;
            nodeEven.next.next = null;
        }
        node.next = even.next;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
       // head.next.next.next.next = new ListNode(5);
        System.out.println(oddEvenList(head));
    }
}
