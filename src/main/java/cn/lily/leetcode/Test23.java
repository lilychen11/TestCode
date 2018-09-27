package cn.lily.leetcode;
import cn.lily.leetcode.ListNode;

import java.util.PriorityQueue;

public class Test23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length < 0) {
            return null;
        }
        PriorityQueue<ListNode> queue = new PriorityQueue<>((p,q) -> (p.val - q.val));
        for (ListNode node : lists) {
            queue.add(node);
        }
        ListNode root = new ListNode(0);
        ListNode head = root;
        while (!queue.isEmpty()) {
            head.next = queue.poll();
            if (head.next.next != null) {
                queue.add(head.next.next);
            }
            head.next = null;
        }
            return root.next;
    }
    public static ListNode mergeKLists1(ListNode[] lists){
        int amount = lists.length;
        int interval = 1;
        while (interval < amount) {
            for (int i = 0; i < amount - interval; ) {
                lists[i] = merge2List(lists[i], lists[i + interval]);
                i += interval * 2;
            }
            interval *= 2;
        }
        return lists.length > 0 ? lists[0] : null;
    }
    public static ListNode merge2List(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode root = new ListNode(0);
        ListNode head = root;
        while (l1!= null && l2 != null){
            if (l1.val < l2.val) {
                head.next = l1;
                l1 = l1.next;
            } else {
                head.next = l2;
                l2 = l2.next;
            }
            head = head.next;
        }
        if (l1 != null)
            head.next = l1;
        if (l2 != null)
            head.next = l2;
        return root.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);
        ListNode[] lists = {l1, l2, l3};
        System.out.println(mergeKLists1(lists));
    }
}
