package cn.lily.leetcode;

public class Test162 {
    public static int findPeakElement(int[] nums) {
        if (nums == null || nums.length < 1)
            return 0;
        int start = Integer.MIN_VALUE;
        int end = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int left, right;
            if (i < 1)
                left = start;
            else
                left = nums[i - 1];
            if (i + 1 >= nums.length)
                right = end;
            else
                right = nums[i + 1];
            if (nums[i] > left && nums[i] > right)
                return i;
            if (i == nums.length - 1 && start == nums[i]){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums= {1};
        System.out.println(findPeakElement(nums));
    }
}
