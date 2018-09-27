package cn.lily.leetcode;

import java.util.HashSet;

public class Test128 {
    public static int longestConsecutive(int[] nums) {
        if (nums ==  null || nums.length < 1) {
            return 0;
        }
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int max = Integer.MIN_VALUE;
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int conNum = num;
                int length = 1;
                while (set.contains(conNum + 1)) {
                    conNum++;
                    length++;
                }
                max = Math.max(length, max);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutive(nums));
    }
}
