package cn.lily.leetcode;

public class Test494 {
    public static int findTargetSumWays(int[] nums, int S) {
        if (nums == null && S != 0) {
            return 0;
        }
        int[] count = new int[1];
        count[0] = 0;
        check(nums, S, 0, 0, count);
        return count[0];
    }

    public static void check(int[] nums, int S, int i, int temp, int[] count) {
        if (i == nums.length && temp == S) {
            count[0]++;
            return;
        }
        if (i >= nums.length) {
            return;
        }
        check(nums, S, i + 1, temp - nums[i], count);
    }

    public static int findTargetSumWays1(int[] nums, int S) {
        int[] dp = new int[2001];
        dp[nums[0] + 1000] = 1;
        dp[-nums[0] + 1000] = 1;
        for (int i = 1; i < nums.length; i++) {
            int[] next = new int[2001];
            for (int sum = -1000; sum <= 1000; sum++) {
                if (dp[sum + 1000] > 0) {
                    next[sum + nums[i] + 1000] += dp[sum + 1000];
                    next[sum - nums[i] + 1000] += dp[sum + 1000];
                }
            }
            dp = next;
        }
        return dp[S + 1000];
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1};
        int S = 3;
        System.out.println(findTargetSumWays1(nums, S));
    }
}
