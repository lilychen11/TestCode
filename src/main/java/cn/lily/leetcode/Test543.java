package cn.lily.leetcode;


import java.util.LinkedList;
import java.util.Queue;

public class Test543 {
    public static int depth(Test572.TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(depth(root.left), depth(root.right));
    }

    public static int diameterOfBinaryTree(Test572.TreeNode root) {
        if (root == null){
            return 0;
       }
        int maxDiameter = Integer.MIN_VALUE;
        Queue<Test572.TreeNode> queue = new LinkedList<Test572.TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Test572.TreeNode temp = queue.poll();
            if (temp.left != null) {
                queue.add(temp.left);
            }
            if (temp.right != null) {
                queue.add(temp.right);
            }
            int dRoot = depth(temp.right) + depth(temp.left);
            if (dRoot > maxDiameter) {
                maxDiameter = dRoot;
            }
        }
        return maxDiameter;
    }

    public static void main(String[] args) {
        Test572.TreeNode root = new Test572.TreeNode(1);
        root.left = new Test572.TreeNode(2);
        root.right = new Test572.TreeNode(3);
        root.left.left = new Test572.TreeNode(4);
        root.left.right = new Test572.TreeNode(5);
        System.out.println(diameterOfBinaryTree(root));
    }
}
