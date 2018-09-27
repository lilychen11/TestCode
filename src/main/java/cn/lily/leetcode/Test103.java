package cn.lily.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Test103 {
    public static List<List<Integer>> zizagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        int level = 0;
        queue.offer(root);
        while (!queue.isEmpty()) {
            Queue<TreeNode> tQueue = new LinkedList<>();
            List<Integer> temp = new LinkedList<>();
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (level % 2 == 0)
                    temp.add(node.val);
                else
                    temp.add(0, node.val);
                if (node.left != null)
                    tQueue.offer(node.left);
                if (node.right != null)
                    tQueue.offer(node.right);
            }
            res.add(temp);
            queue = tQueue;
            level++;
        }
        return res;
    }

    public static List<List<Integer>> zizagLevelOrder2(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null)
            return res;
        Stack<TreeNode> stack0 = new Stack<>();
        Stack<TreeNode> stack1 = new Stack<>();
        stack0.push(root);
        int flag = 0;
        while (!stack0.isEmpty() || !stack1.isEmpty()) {
            List<Integer> list = new LinkedList<>();
            if (flag % 2 == 0) {
                while (!stack0.isEmpty()) {
                    TreeNode node = stack0.pop();
                    list.add(node.val);

                    if (node.left != null)
                        stack1.push(node.left);
                    if (node.right != null)
                        stack1.push(node.right);
                }
            } else {
                while (!stack1.isEmpty()) {
                    TreeNode node = stack1.pop();
                    list.add(node.val);

                    if (node.right != null)
                        stack0.push(node.right);
                    if (node.left != null)
                        stack0.push(node.left);
                }
            }
            flag++;
            res.add(list);
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        System.out.println(zizagLevelOrder2(root));
    }

}
