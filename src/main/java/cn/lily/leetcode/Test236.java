package cn.lily.leetcode;

import java.util.LinkedList;

public class Test236 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return val + " ";
        }
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        LinkedList<TreeNode> route1 = new LinkedList<TreeNode>();
        findPath(root, p, route1, new boolean[1]);
        LinkedList<TreeNode> route2 = new LinkedList<TreeNode>();
        findPath(root, q, route2, new boolean[1]);
        int length = Math.min(route1.size(), route2.size());
        int i = 0;
        while (i < length && route1.get(i) == route2.get(i)) {
            i++;
        }
        return route1.get(i - 1);
    }

    public static void findPath(TreeNode root, TreeNode p, LinkedList<TreeNode> list, boolean[] find) {
        if (root == null || find[0]) {
            return;
        }
        list.add(root);
        if (root.val == p.val) {
            find[0] = true;
            return;
        }
        findPath(root.left, p, list, find);
        findPath(root.right, p, list, find);
        if (!find[0]) {
            list.remove(list.size() - 1);
        }
    }
    public static TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        return find(root, p, q);
    }

    private static TreeNode find(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        if(root == p) return p;
        if(root == q) return q;

        TreeNode l = find(root.left, p, q);
        TreeNode r = find(root.right, p, q);
        if(l != null && r != null) return root;
        return l == null ? r : l;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        System.out. println(lowestCommonAncestor1(root, root.left, root.left.right.right));
    }

}
