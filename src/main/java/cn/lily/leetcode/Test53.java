package cn.lily.leetcode;

public class Test53 {
    public int maxSubArray(int[] nums){
        if (nums == null || nums.length < 1){
            return 0;
        }
        if (nums.length < 2){
            return nums[0];
        }
        int sum = 0;
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i] = Math.max(nums[i], nums[i] + nums[i - 1]);
            if (nums[i] > max){
                max = nums[i];
            }
        }
        return max;
    }
}
