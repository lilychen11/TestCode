package cn.lily.leetcode;

public class Test105 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    public static TreeNode buildTree(int[] preorder, int[] indorder) {
        if (preorder == null || indorder == null || preorder.length == 0 ||  indorder.length == 0 ||preorder.length != indorder.length) {
            return null;
        }
        int[] rootIdx = new int[1];
        TreeNode root = build(preorder, indorder, rootIdx, 0, indorder.length - 1);
        return root;
    }
    public static TreeNode build(int[] preorder, int[] inorder, int[] rootIdx, int start, int end) {
        if (rootIdx[0] >= preorder.length || start > end) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[rootIdx[0]]);
        int leftEnd = 0;

        /*if(start == end) {
            rootIdx[0]++;
            return root;
        } else {*/
            for (int i = start; i <= end ; i++) {
                if (inorder[i] == preorder[rootIdx[0]]) {
                    leftEnd = i;
                    rootIdx[0]++;
                    break;
                }
            }
        //}
        root.left = build(preorder, inorder, rootIdx, start, leftEnd - 1);
        root.right = build(preorder, inorder, rootIdx, leftEnd + 1, end);
        return root;
    }

    public static void main(String[] args) {
        int[] preorder = {1,2};
        int[] inorder = {1,2};
        System.out.println(buildTree(preorder, inorder));
    }
}
