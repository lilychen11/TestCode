package cn.lily.leetcode;

public class Tees108 {
    public static TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length < 1)
            return null;
        return buildTree(nums, 0, nums.length - 1);
    }
    public static TreeNode buildTree(int[]nums, int start, int end){
        if (end < start) {
            return null;
        }
        if (start == end)
            return new TreeNode(nums[start]);
        int middle = (start + end + 1) / 2;
        TreeNode node = new TreeNode(nums[middle]);
        node.left = buildTree(nums, start, middle - 1);
        node.right = buildTree(nums, middle + 1, end);
        return node;
    }

    public static void main(String[] args) {
        int[] nums = {-10, -3, 0, 5, 9};
        System.out.println(sortedArrayToBST(nums));
    }
}
