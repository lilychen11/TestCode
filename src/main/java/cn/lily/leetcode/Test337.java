package cn.lily.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Test337 {
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

    public static int rob1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        List<Integer> levels = new LinkedList<>();
        stack1.push(root);
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            levels.add(addChild(stack1, stack2));
            levels.add(addChild(stack2, stack1));
        }
        int[] resDp = new int[levels.size()];
        if (levels.size() <= 1) {
            return levels.get(0);
        }
        resDp[0] = levels.get(0);
        resDp[1] = levels.get(1);
        for (int i = 2; i < levels.size(); i++) {
            for (int j = 0; j < i - 1; j++) {
                resDp[i] = Math.max(resDp[i], levels.get(i) + resDp[j]);
            }
        }
        return resDp[resDp.length - 1] > resDp[resDp.length - 2] ? resDp[resDp.length - 1] : resDp[resDp.length - 2];
    }

    public static int addChild(Stack<TreeNode> main, Stack<TreeNode> sub) {
        int temp = 0;
        while (!main.isEmpty()) {
            TreeNode node = main.pop();
            if (node.left != null) {
                sub.add(node.left);
            }
            if (node.right != null) {
                sub.add(node.right);
            }
            temp += node.val;
        }
        return temp;
    }

    public static int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int[] nums = dfs(root);
        return Math.max(nums[0], nums[1]);
    }

    public static int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[2];
        }
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        int[] res = new int[2];
        res[0] = left[1] + right[1] + root.val;
        res[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(2);
        root.left.left.left = new TreeNode(3);
        //root.right.right = new TreeNode(1);
        System.out.println(rob(root));
    }

}
