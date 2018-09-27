package cn.lily.leetcode;

import java.util.LinkedList;

public class Test309 {
    public static int maxProfit(int[] prices) {
        int L = prices.length;
        if (L < 2) {
            return 0;
        }
        int has1_doNothing = -prices[0];
        int has1_Sell = 0;
        int has0_doNothing = 0;
        int has0_Buy = -prices[0];
        for (int i = 1; i < L; i++) {
            has1_doNothing = has1_doNothing > has0_Buy ? has1_doNothing : has0_Buy;
            has0_Buy = -prices[i] + has0_doNothing;
            has0_doNothing = has0_doNothing > has1_Sell ? has0_doNothing : has1_Sell;
            has1_Sell = prices[i] + has1_doNothing;
        }
        return has1_Sell > has0_doNothing ? has1_Sell : has0_doNothing;
    }

    public static int maxProfit1(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        int[] has0 = new int[prices.length];
        int[] has1 = new int[prices.length];
        int[] calm = new int[prices.length];
        has1[0] = -prices[0];
        has0[0] = 0;
        calm[0] = Integer.MIN_VALUE;
        for (int i = 1; i < prices.length; i++) {
            has0[i] = Math.max(has0[i - 1], calm[i - 1]);
            has1[i] = Math.max(has1[i - 1], has0[i - 1] - prices[i]);
            calm[i] = has1[i - 1] + prices[i];
        }
        return Math.max(has0[prices.length - 1], calm[prices.length - 1]);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 0, 2};
        System.out.println(maxProfit(nums));
    }
}
