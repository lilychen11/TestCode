package cn.lily.leetcode;

import java.util.Arrays;

public class Test322 {
    public static int coinChange(int[] coins, int amount) {
        if (amount < 1) {
            return 0;
        }
        Arrays.sort(coins);
        int max = amount + 1;
        int dp[] = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] == max ? -1 : dp[amount];

    }

    public static int coinChangeT2B(int[] coins, int amount) {
        if (amount < 0) {
            return -1;
        }
        return coinChangeCur(coins, amount, new int[amount]);
    }

    public static int coinChangeCur(int[] coins, int amount, int[] dp) {
        if (amount == 0) {
            return 0;
        } else if (amount < 0) {
            return -1;
        }
        if (dp[amount - 1] != 0) return dp[amount - 1];
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = coinChangeCur(coins, amount - coin, dp);
            if (res >= 0 && res < min) {
                min = 1 + res;
            }
        }
        dp[amount - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
        return dp[amount - 1];
    }

    public static void main(String[] args) {
        int[] coins = {186, 419, 83, 408};
        System.out.println(coinChange(coins, 6249));
    }
}
