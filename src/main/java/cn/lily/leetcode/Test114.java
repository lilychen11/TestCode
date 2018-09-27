package cn.lily.leetcode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Test114 {
    public static Queue<TreeNode> queue = new LinkedList<>();
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    public static void flatten(TreeNode root) {
        addNode(root);
        TreeNode nRoot = root;
        queue.poll();
        TreeNode head = root;
        while (!queue.isEmpty()){
            head.left = null;
            head.right = null;
            head.right = queue.poll();
            head = head.right;
        }
        //root = nRoot.right;

    }
    public static void addNode(TreeNode root) {
        if (root == null) {
            return;
        }
        queue.offer(root);
        addNode(root.left);
        addNode(root.right);
    }
    private static TreeNode prev = null;
    public static void flatten1(TreeNode root) {
        if (root == null) {
            return;
        }
        flatten1(root.right);
        flatten1(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode( 4);
        root.right.right =new TreeNode(6);
        flatten1(root);
        //System.out.print(queue);
    }


}
