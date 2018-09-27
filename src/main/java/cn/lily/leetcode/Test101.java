package cn.lily.leetcode;

public class Test101 {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    public boolean isSymmetric(TreeNode root) {
        return compareTree(root, root);
    }
    public boolean compareTree(TreeNode root1, TreeNode root2){
        if (root1 == null && root2 == null){
            return true;
        }
        if (root1 == null || root2 == null){
            return false;
        }
        if (root1.val == root2.val){
            return compareTree(root1.left, root2.right) && compareTree(root1.right, root2.left);
        } else {
            return false;
        }

    }
}
