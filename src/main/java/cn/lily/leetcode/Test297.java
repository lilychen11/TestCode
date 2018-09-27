package cn.lily.leetcode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Test297 {
   static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    public static String serialize(TreeNode root) {
        if (root == null)
            return "null";
        StringBuffer result = new StringBuffer();
        buildString(root, result);
        return result.toString();
    }
    public static void buildString(TreeNode root, StringBuffer temp){
        if (root == null){
            temp.append("null ");
            return;
        }
        temp.append(root.val + " ");
        buildString(root.left, temp);
        buildString(root.right,temp);
    }
    public static TreeNode deserialize(String data) {
        if (data == null || data.length() < 1) {
            return null;
        }
        Deque<String> nodes = new LinkedList<>();
        ((LinkedList<String>) nodes).addAll(Arrays.asList(data.split(" ")));
        return buildTree(nodes);

    }
    public static TreeNode buildTree(Deque<String> nodes) {
        String val = nodes.remove();
        if (val.equals("null")) {
            return null;
        } else {
            TreeNode node = new TreeNode(Integer.valueOf(val));
            node.left = buildTree(nodes);
            node.right = buildTree(nodes);
            return node;
        }
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(4);
        root.right.left.left = new TreeNode(3);
        root.right.left.right = new TreeNode(1);
        System.out.println(deserialize(serialize(root)));
    }
}
