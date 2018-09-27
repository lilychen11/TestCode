package cn.lily.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Test102 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return this.val + " ";
        }
    }
    public static List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        List<List<Integer>> res = new LinkedList<>();
        q1.offer(root);
        while (!q1.isEmpty() || !q2.isEmpty()) {
            List<Integer> temp = new LinkedList<>();
            while (!q1.isEmpty()) {
                TreeNode node = q1.poll();
                if (node.left != null) {
                    q2.offer(node.left);
                }
                if (node.right != null) {
                    q2.offer(node.right);
                }
                temp.add(node.val);
            }
            if (temp.size() > 0){
                res.add(temp);
            }

            List<Integer> temp1 = new LinkedList<>();
            while (!q2.isEmpty()) {
                TreeNode node = q2.poll();
                if (node.left != null) {
                    q1.offer(node.left);
                }
                if (node.right != null) {
                    q1.offer(node.right);
                }
                temp1.add(node.val);
            }
            if (temp1.size() > 0){
                res.add(temp1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.print(levelOrder(root));
    }
}
