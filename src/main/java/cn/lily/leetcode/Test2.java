package cn.lily.leetcode;

import java.util.LinkedList;

public class Test2 {
    static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }
        @Override
        public String toString(){
            return val + " ";
        }
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2){
        if (l1 == null){
            return l2;
        }
        if (l2 == null){
            return l1;
        }
        int carry = 0;
        ListNode root = l1;
       // ListNode node = new ListNode(0);
       // root = node;
        while (l1 != null && l2 != null){
            int count = l1.val + l2.val + carry;
            carry = count / 10;
            if (carry > 0){
                l1.val = count % 10;
            } else {
                l1.val = count;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        if (l1 != null){
            while (l1 != null && carry > 0){
                l1.val = l1.val +carry;
                carry = l1.val / 10;
                if (carry > 0){
                    l1.val = l1.val % 10;
                }
                l1 = l1.next;
            }
        }
        ListNode node  = root;
        while (node.next != null){
            node = node.next;
        }
       /* if (carry > 0){
            ListNode nNode = new ListNode(1);
            node.next = nNode;
        }*/

        if (l2 != null){
            while (l2 != null){
                ListNode nNode = new ListNode(0);
                node.next = nNode;
                node.next.val += l2.val + carry;
                carry = node.next.val / 10;
                if (carry > 0){
                    node.next.val = node.next.val % 10;
                }
                l2 = l2.next;
                node = node.next;
            }
        }
        if (node.next != null){
            node = node.next;
        }

        if (carry > 0){
            ListNode nNode = new ListNode(1);
            node.next = nNode;
        }
       return root;

    }
    public static LinkedList<Integer> addTwo(LinkedList<Integer> list1, LinkedList<Integer> list2){
        if (list1 == null){
            return list2;
        }
        if (list2 == null){
            return list1;
        }
        int carry = 0;
        int idx = 0;
        if (list1.size() < list2.size()){
            LinkedList<Integer> temp = new LinkedList<Integer>();
            temp.addAll(list1);
            list1.clear();
            list1.addAll(list2);
            list2.clear();
            list2.addAll(temp);
        }
        while (idx < list1.size() && idx < list2.size()){
            int count = list1.get(idx) + list2.get(idx) + carry;
            carry = count / 10;
            if (carry > 0){
                list1.set(idx, count % 10);
            } else {
                list1.set(idx, count);
            }
            idx++;
        }
        if (carry > 0){
            list1.add(carry);
        }
        return list1;
    }

    public static void main(String[] args) {
        LinkedList<Integer> list1 = new LinkedList<Integer>();
        list1.add(2);
        list1.add(4);
        list1.add(3);
        LinkedList<Integer> list2 = new LinkedList<Integer>();
        list2.add(5);
        list2.add(6);
        list2.add(9);
        System.out.println(addTwo(list1,list2));
        ListNode root = new ListNode(0);
        /*root.next = new ListNode(4);
        root.next.next = new  ListNode(3);*/
        ListNode root2 = new ListNode(2);
        root2.next = new ListNode(7);
        root2.next.next = new ListNode( 8);
        ListNode result = addTwoNumbers(root, root2);
        while (result != null){
            System.out.print(result);
            result = result.next;
        }
    }


}
