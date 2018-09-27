package cn.lily.leetcode;

import cn.lily.leetcode.Test572.TreeNode;

public class Test98 {
    public static TreeNode prev = null;
    public static boolean flag = true;

    public static boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        isValidCur(root);
        return flag;
    }

    public static boolean isValidBST1(TreeNode root) {
        return isValidCur1(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public static boolean isValidCur1(TreeNode root, long minVal, long maxVal) {
        if (root == null) {
            return true;
        }
        if (root.val <= minVal || root.val >= maxVal) {
            return false;
        }
        return isValidCur1(root.left, minVal, root.val) && isValidCur1(root.right, root.val, maxVal);
    }

    public static void isValidCur(TreeNode root) {

        if (root.left != null) {
            isValidCur(root.left);
        }
        if (prev == null) {
            prev = root;
        } else if (flag && root.val > prev.val) {
            prev = root;
        } else {
            flag = false;
        }
        if (flag && root.right != null) {
            isValidCur(root.right);
        }
    }

    public boolean isValidBST(TreeNode root, long minVal, long maxVal) {
        if (root == null) {
            return true;
        }
        if (root.val >= maxVal || root.val <= minVal) {
            return false;
        }
        return isValidBST(root.left, minVal, root.val) && isValidBST(root.right, root.val, maxVal);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(2);

        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(6);
        System.out.println(isValidBST(root));
        TreeNode root1 = new TreeNode(-2147483648);
        root1.right = new TreeNode(2147483647);
        System.out.println(isValidBST1(root1));

    }
}
