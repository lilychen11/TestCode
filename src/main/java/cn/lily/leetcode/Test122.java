package cn.lily.leetcode;

public class Test122 {
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length < 1)
            return 0;
        int max = 0;
        int[] profit = new int[prices.length + 1];
        profit[0] = 0;
        profit[1] = 0;
        for (int i = 1; i < prices.length; i++) {
            profit[i + 1] = profit[i];
            for (int j = 0; j < i; j++) {
                profit[i + 1] = Math.max(profit[i + 1], prices[i] - prices[j] + profit[j]);
                max = Math.max(max, profit[i + 1]);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] prices = {3, 2, 6, 5, 0, 3};
        System.out.println(maxProfit(prices));
    }
}
