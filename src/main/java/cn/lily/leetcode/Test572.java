package cn.lily.leetcode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Test572 {
    static  class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static boolean isSubtree(TreeNode s, TreeNode t) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(s);
        boolean flag = false;
        while (!queue.isEmpty() && !flag){
            TreeNode temp = queue.poll();
            if (temp.val == t.val){
                flag = isSubtreeCur(temp, t);
            }
            if (flag){
                break;
            }
            if (temp.left != null){
                queue.add(temp.left);
            }
            if (temp.right != null){
                queue.add(temp.right);
            }
        }
        return flag;
    }
    public static boolean isSubtreeCur(TreeNode s, TreeNode t){
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        if (s.val == t.val) {
            return isSubtreeCur(s.left, t.left) && isSubtreeCur(s.right, t.right);
        }
        return false;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        TreeNode temp = new TreeNode(4);
        temp.left = new TreeNode(1);
        temp.right = new TreeNode(2);
        System.out.println(isSubtree(root, temp));
    }
}
