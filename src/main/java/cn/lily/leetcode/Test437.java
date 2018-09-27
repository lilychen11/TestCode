package cn.lily.leetcode;

import java.util.*;

public class Test437 {
    public static int count = 0;

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static int pathSum(TreeNode root, int sum) {
        Deque<Integer> deque = new LinkedList<>();
        pathSumCur(root, sum, deque);
        return count;
    }

    public static void pathSumCur(TreeNode root, int sum, Deque<Integer> deque) {
        if (root == null) {
            return;
        }
        deque.add(root.val);
        Queue<Integer> temp = new LinkedList<>();
        temp.addAll(deque);
        int tSum = 0;
        Iterator<Integer> iterator = temp.iterator();
        while (iterator.hasNext()) {
            tSum += iterator.next();
        }
        while (/*tSum >= sum &&*/ !temp.isEmpty()) {
            if (tSum == sum) {
                count++;
            }
            int head = temp.poll();
            tSum -= head;
        }
        pathSumCur(root.left, sum, deque);
        if (root.left != null) {
            deque.removeLast();
        }
        pathSumCur(root.right, sum, deque);
        if (root.right != null) {
            deque.removeLast();
        }
    }

    public static int pathSum1(TreeNode root, int sum) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        helper(root, sum, 0, map);
        return countNew;
    }
    static int countNew = 0;
    public static void helper(TreeNode root, int sum, int cur, HashMap<Integer, Integer> map) {
        if (root == null) {
            return;
        }
        cur += root.val;
        countNew += map.getOrDefault(cur - sum, 0);
        map.put(cur, map.getOrDefault(cur,0) + 1);
        helper(root.left, sum, cur, map);
        helper(root.right, sum, cur, map);
        map.put(cur, map.get(cur) - 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(-3);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        root.right.right = new TreeNode(11);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);
        root.left.right.right = new TreeNode(1);
        int sum = 8;
        /*TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        int sum = 1*/;
        System.out.println(pathSum1(root, sum));
    }
}
