package cn.lily.leetcode;

public class Test11 {
    public static int maxArea(int[] height) {
        if (height == null || height.length < 1) {
            return 0;
        }
        int[] dp = new int[height.length + 1];
        dp[0] = 0;
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            dp[i + 1] = Integer.MIN_VALUE;
            for (int j = 0; j <= i; j++) {

                dp[i + 1] = Math.max(dp[i + 1], Math.min(height[i], height[j]) * (i - j));
            }
            max = Math.max(max, dp[i + 1]);
        }
        return max;
    }
    public static int maxArea1(int[] height) {
        int i = 0, j = height.length - 1;
        int water = 0;
        while (i < j) {
            water = Math.max(water, (j - i) * Math.min(height[i], height[j]));
            if (height[i] < height[j]){
                i++;
            } else {
                j--;
            }
        }
        return water;
    }

    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.print(maxArea(height));
    }
}
