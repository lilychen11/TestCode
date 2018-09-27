package cn.lily.leetcode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Test538 {
    public static Stack<Integer> stack = new Stack<>();
    public static Stack<Integer> stackAdd = new Stack<>();
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
        @Override
        public String toString(){
            return this.val + " ";
        }
    }

    public static void convert(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
           convert(root.left);
        }
        stack.add(root.val);
        if (root.right != null) {
            convert(root.right);
        }
    }
    public static void addElement(){
        //int size = stack.size();
        stackAdd.push(0);
        int max = stack.peek();
        int last = stack.pop();
        while (!stack.isEmpty()){
            int temp = stack.pop();
            if (temp < last){
                stackAdd.push(max);
            } else {
                stackAdd.add(stackAdd.peek());
            }
            max += temp;
        }
    }
    public static void change(TreeNode root){
        if (root == null){
            return;
        }
        if (root.left != null){
            change(root.left);
        }
        root.val += stackAdd.pop();
        if (root.right != null){
            change(root.right);
        }
    }
    public static TreeNode convertBST0(TreeNode root){
        if (root == null){
            return root;
        }
        convert(root);
        addElement();
        change(root);
        return root;
    }
    private static int sum = 0;
    public static TreeNode convertBST1(TreeNode root){
        if (root != null){
            convertBST1(root.right);
            sum += root.val;
            root.val = sum;
            convertBST1(root.left);
        }
        return root;
    }
    public static TreeNode convertBST2(TreeNode root){
        int sum = 0;
        TreeNode node = root;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || node != null){
            while (node != null){
                stack.push(node);
                node = node.right;
            }
            node = stack.pop();
            sum += node.val;
            node.val = sum;
            node = node.left;
        }
        return root;
    }
    private static TreeNode getSuccessor(TreeNode node){
        TreeNode succ = node.right;
        while (succ.left != null && succ.left != node){
            succ = succ.left;
        }
        return succ;
    }
    public static TreeNode convertBST(TreeNode root){
        int sum = 0;
        TreeNode node = root;
        while (node != null){
            if (node.right == null){
                sum += node.val;
                node.val = sum;
                node = node.left;
            } else {
                TreeNode succ = getSuccessor(node);
                if (succ.left == null){
                    succ.left = node;
                    node = node.right;
                } else {
                    succ.left = null;
                    sum += node.val;
                    node.val = sum;
                    node = node.left;
                }
            }
        }
        return  root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(13);
        convertBST(root);
        System.out.println(root);
    }

}
