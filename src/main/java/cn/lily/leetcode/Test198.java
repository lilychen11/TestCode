package cn.lily.leetcode;

import java.util.Arrays;

public class Test198 {
    public static int max = 0;

    /*public static int rob(int[] nums){
        if (nums == null  || nums.length < 1){
            return 0;
        }
        boolean[] visit = new boolean[nums.length];
        Arrays.fill(visit,false);
        robCur(nums, visit, 0, 0);
        robCur(nums, visit, 0, 1);
        return max;
    }
    public static void robCur(int[] nums, boolean[] visit, int temp, int index){
        if (index >= visit.length){
            return;
        }
        if (index <= 1){
            visit[index] = true;
             temp += nums[index];
            if (temp > max){
                max = temp;
            }
            robCur(nums, visit, temp, index + 2);
            visit[index] = false;
        } else {
            if (!visit[index - 1]){
                for (int i = index; i < nums.length ; i++) {
                    visit[i] = true;
                    temp += nums[i];
                    if (temp > max){
                        max = temp;
                    }
                    robCur(nums, visit, temp, i + 2);
                    temp -= nums[i];
                    visit[i] = false;
                }

            }

        }
    }*/
    public static int rob(int[] nums) {
        if (nums == null || nums.length < 1){
            return 0;
        }
        if (nums.length < 2){
            return nums[0];
        }
        int[] pos = new int[nums.length];
        pos[0] = nums[0];
        pos[1] = nums[1];
        for (int i = 2; i < pos.length; i++) {
            for (int j = 0; j < i - 1; j++) {
                pos[i] = Math.max(pos[i], pos[j] + nums[i]);
            }
        }
        return Math.max(pos[nums.length - 1], pos[nums.length - 2]);
    }

    public static void main(String[] args) {
        int[] nums = {114,117,207,117,235,82,90,67,143,146,53,108,200,91,80,223,58,170,110,236,81,90,222,160,165,195,187,199,114,235,197,187,69,129,64,214,228,78,188,67,205,94,205,169,241,202,144,240};
        int[] nums1 = {1, 2, 3, 1};
        System.out.println(rob(nums1));
    }
}
