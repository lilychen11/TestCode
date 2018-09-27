package cn.lily.leetcode;

public class Test124 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static int maxPathSum(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int[] res = new int[1];
        res[0] = Integer.MIN_VALUE;
        pathCur(root, res);
        return res[0];
    }
    public static int pathCur(TreeNode root, int[] max) {
        if(root == null) {
            return 0;
        }
        int leftTmp = pathCur(root.left, max);
        int rightTmp = pathCur(root.right, max);
        int big = Math.max(leftTmp, rightTmp);
        int temp = root.val + (big > 0 ? big : 0);
        max[0] = Math.max(max[0], temp);
        max[0] = Math.max(max[0], temp + leftTmp + rightTmp - big);
        return temp;
    }

    public static void main(String[] args) {
        /*TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);*/
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(maxPathSum(root));
    }
}
