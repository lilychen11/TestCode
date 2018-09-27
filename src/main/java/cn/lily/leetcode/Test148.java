package cn.lily.leetcode;

import java.util.LinkedList;

public class Test148 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return val + " ";
        }
    }
    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        return Partition(head, null);
    }
    public static ListNode Partition(ListNode start, ListNode end) {
        if (start == end || start.next == end) {
            return start;
        }
        ListNode cur = start;
        ListNode left = start;
        while (cur != null && cur != end) {
            if (cur.next != null && cur.next.val < start.val) {
                ListNode t = cur.next;
                cur.next = t.next;
                t.next = left;
                left = t;
            } else {
                cur = cur.next;
            }
        }
        left = Partition(left, start);
        start.next = Partition(start.next, end);
        return left;
    }
    public static ListNode sortList1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = null, slow = head, fast = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        ListNode l1 = sortList1(head);
        ListNode l2 = sortList1(slow);
        return merge(l1, l2);
    }
    public static ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode root = new ListNode(0);
        ListNode temp = root;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                temp.next = l1;
                temp = temp.next;
                l1 = l1.next;
            } else {
                temp.next = l2;
                temp = temp.next;
                l2 =  l2.next;
            }
        }
        if (l1 != null) {
            temp.next = l1;
        }
        if (l2 != null) {
            temp.next = l2;
        }
        return root.next;
    }
    public static void printNode(ListNode root) {
        if (root == null) {
            System.out.print("null");
        }
        while (root != null) {
            System.out.print(root);
            root = root.next;
        }
        System.out.println();
    }
    public static ListNode sortList3(ListNode head) {
        return Heap(head);
    }
    public static ListNode Heap(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        LinkedList<ListNode> lists = new LinkedList<>();
        int count = 0;
        while (head != null) {
            ListNode node = head;
            head = head.next;
            node.next = null;
            add(lists, node);
        }
        ListNode root = new ListNode(0);
        ListNode temp = root;
        while (lists.size() > 0) {
            temp.next = remove(lists);
            temp = temp.next;
        }
        temp.next = null;
        return root.next;
    }
    public static void siftUp(LinkedList<ListNode> lists, int index){
        if(index > lists.size()) {
            return;
        }
        int parent = (index - 1) >> 1;
        while(lists.get(index).val < lists.get(parent).val) {
            ListNode child = lists.remove(index);
            ListNode father = lists.remove(parent);
            lists.add(parent,child);
            lists.add(index,father);
            index = parent;
        }
    }
    public static void siftDown(LinkedList<ListNode> lists, int index) {
        if ((index<< 1) + 1 < 0 || ((index<< 1) + 1) >= lists.size()) {
            return;
        }
        int to = (index<< 1) + 1;
        if (to >= lists.size()) {
            return;
        }
        while ((to < lists.size() && lists.get(index).val > lists.get(to).val) ||(to + 1 < lists.size() && (lists.get(index).val > lists.get(to + 1).val))){
            ListNode min = null;
            int mIdx = 0;
            if ((to + 1) >= lists.size() ) {
                min = lists.get(to);
                mIdx = to;
            } else {
                min = lists.get(to).val < lists.get(to + 1).val ? lists.get(to) : lists.get(to + 1);
                mIdx = lists.get(to).val < lists.get(to + 1).val ? to : to + 1;
            }
            if (lists.get(index).val > min.val) {
                int itmp = lists.get(index).val;
                lists.get(index).val = min.val;
                min.val = itmp;
                index = mIdx;
                to = (index << 1)  + 1;
            }
        }

    }
    public static ListNode remove(LinkedList<ListNode> lists){
        if (lists.size() == 0) {
            return null;
        }
        if (lists.size() == 1) {
            return lists.remove();
        }
        ListNode temp = lists.remove(0);
        lists.add(0, lists.remove(lists.size() - 1));
        siftDown(lists, 0);
        return temp;
    }
    public static void add(LinkedList<ListNode> lists, ListNode node) {
        lists.add(0,node);
        siftDown(lists, 0);
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(4);
        root.next = new ListNode(2);
        root.next.next = new ListNode(1);
        root.next.next.next = new ListNode(3);


        ListNode root2 = new ListNode(-1);
        root2.next = new ListNode(5);
        root2.next.next = new ListNode(3);
        root2.next.next.next = new ListNode(4);
        root2.next.next.next.next = new ListNode( 0);
        printNode(sortList3(root2));
        printNode(sortList(root));

    }
}