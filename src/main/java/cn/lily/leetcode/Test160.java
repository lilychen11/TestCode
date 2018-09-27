package cn.lily.leetcode;

import com.sun.org.apache.bcel.internal.generic.LNEG;

import java.util.LinkedList;

public class Test160 {
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

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        int lenA = 0, lenB = 0;
        ListNode rootA = headA;
        while (rootA != null) {
            lenA++;
            rootA = rootA.next;
        }
        ListNode rootB = headB;
        while (rootB != null) {
            lenB++;
            rootB = rootB.next;
        }
        ListNode rootMax = headA;
        ListNode rootMin = headB;
        if (lenA < lenB) {
            rootMax = headB;
            rootMin = headA;
        }
        int diff = Math.abs(lenA - lenB);
        while (diff > 0) {
            rootMax = rootMax.next;
            diff--;
        }
        while (rootMax != null && rootMax != rootMin) {
            rootMax = rootMax.next;
            rootMin = rootMin.next;
        }
        return rootMax;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(3);
        root.next.next = new ListNode(5);
        root.next.next.next = new ListNode(7);
        root.next.next.next.next = new ListNode(9);
        ListNode root2 = new ListNode(2);
        System.out.println(getIntersectionNode(root, root2));
    }
}
