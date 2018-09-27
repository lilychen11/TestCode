package cn.lily.leetcode;

public class Test138 {
    public static RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return head;
        }
        RandomListNode node = head;
        while (node != null) {
            RandomListNode temp = node.next;
            node.next = new RandomListNode(node.label);
            node.next.next = temp;
            node = temp;
        }
        node = head;
        while (node != null && node.next != null)  {
            if (node.random != null)
                node.next.random = node.random.next;
            node = node.next.next;
        }
        RandomListNode root = new RandomListNode(0);
        root.next = head;
        RandomListNode node1 = root;
        while (node1 != null && node1.next != null) {
            RandomListNode temp = node1.next;
            node1.next = node1.next.next;
            temp.next = node1.next.next;
            node1 = node1.next;
        }
        return root.next;
    }

    public static void main(String[] args) {
        RandomListNode root = new RandomListNode(-1);
        root.next = new RandomListNode(-2);
        System.out.println(copyRandomList(root));
    }
}
