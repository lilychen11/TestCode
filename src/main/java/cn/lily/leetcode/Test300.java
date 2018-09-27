package cn.lily.leetcode;

import java.util.Map;

public class Test300 {
    public static int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        int maxLen = 1;
        int[] result = new int[nums.length];
        result[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            result[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {

                    if (result[j] + 1> result[i]){
                        result[i] = result[j] + 1;
                    }
                }
            }

            maxLen = Math.max(result[i], maxLen);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLIS(nums));
    }
}
