package cn.lily.leetcode;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Test416 {
    public static boolean canPartition(int[] nums){
        if (nums == null || nums.length < 1){
            return false;
        }
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if ((sum & 1) == 1){
            return false;
        }
        int[] posNum = new int[sum + 1];
        Arrays.fill(posNum, 0);
        posNum[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            int[] next = posNum.clone();
            for (int j = 0; j < posNum.length - nums[i]; j++){
                next[j + nums[i]] = posNum[j];
            }
            if (next[sum >> 1] >0){
                return true;
            }
            posNum = next;
        }
        return false;
    }
    public static boolean canPartition1(int[] nums){
        int sum = 0;
        for(int i : nums){
            sum += i;
        }
        if (sum % 2 == 1){
            return false;
        }
        return helper(nums, nums.length - 1, sum >> 1);
    }
    public static boolean helper(int[] nums, int i, int sum){
        if (sum == 0){
            return  true;
        }
        if (i < 0 || sum < 0 || sum < nums[i]){
            return  false;
        }
        return  helper(nums, i - 1, sum - nums[i]) || helper(nums, i - 1, sum);
    }

    public static void main(String[] args) {
        int[] nums = {1, 5, 11, 5};
        System.out.println(canPartition(nums));
        System.out.println(canPartition1(nums));
    }
}
