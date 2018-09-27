package cn.lily.leetcode;

import java.util.LinkedList;
import java.util.List;

public class Test104 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static int Depth(TreeNode root) {
        int left = 0;
        int right = 0;

        if (root.left != null) {
            left = 1 + Depth(root.left);
        }
        if (root.right != null) {
            right = 1 + Depth(root.right);
        }
        return left > right ? left : right;
    }

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int depth = 1 + Depth(root);
        return depth;
    }

    public static TreeNode invertTree(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return root;
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    public static void moveZeroes(int[] nums) {
        if (nums == null || nums.length < 1) {
            return;
        }
        int point = nums.length - 1;
        int zero = nums.length;
        while (point >= 0) {
            if (nums[point] == 0) {
                zero--;
                if (zero >= 0 && zero != point) {
                    //int temp = nums[point];
                    int end = nums[point];
                    int temp = point;
                    while (temp < zero) {
                        nums[temp] = nums[temp + 1];
                        temp++;
                    }
                    nums[temp] = end;
                }
            }
            point--;
        }

    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new LinkedList<Integer>();
        if (nums == null || nums.length < 0) {
            return result;
        }
        int i = 0;
        while (i < nums.length) {
            while (nums[i] > 0 && (nums[i] - 1) != i) {
                if (nums[nums[i] - 1] != nums[i]) {
                    int temp = nums[nums[i] - 1];
                    nums[nums[i] - 1] = nums[i];
                    nums[i] = temp;
                } else {
                    nums[i] = 0;
                }
            }
            i++;
        }
        for (int j = 1; j <= nums.length; j++) {
            if (nums[j - 1] != j) {
                result.add(j);
            }
        }
        return result;
    }

    public static int majorityElement(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }

        int start = 0;
        int end = nums.length - 1;
        int middle = (end - start + 1) / 2;
        int index = Partition(nums, start, end);
        while (index != middle){
            if (index < middle) {
                start += 1;
                index = Partition(nums, start, end);
            } else {
                end -= 1;
                index = Partition(nums, start, end);

            }
        }

        return nums[index];
    }

    public static int Partition(int[] array, int start, int end) {

        int base = array[end];
        while (start < end) {
            while (start < end && array[start] <= base) {
                start++;
            }
            array[end] = array[start];
            while (end > start && array[end] > base) {
                end--;
            }
            array[start] = array[end];
        }
        array[end] = base;
        return end;

    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(9);
        node.right = new TreeNode(20);
        node.right.left = new TreeNode(15);
        node.right.right = new TreeNode(7);
        /*invertTree(node);
        System.out.println(maxDepth(node));*/
        int[] nums = {1, 2, 2, 2, 2, 6, 7, 4, 6, 2, 2, 2};
       // System.out.println(findDisappearedNumbers(nums));
        System.out.println(majorityElement(nums));

    }
}
