package cn.lily.leetcode;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.Arrays;

public class Test64 {
    public static int minPath = Integer.MAX_VALUE;

    public static int minPathSum(int[][] grid) {
        if (grid == null || grid.length < 0) {
            return 0;
        }
        minPathCur(grid, 0, 0, 0);
        return minPath;
    }

    public static void minPathCur(int[][] grid, int cur, int i, int j) {
        if (i >= grid.length || j >= grid[0].length || cur > minPath) {
            return;
        }
        cur += grid[i][j];
        if (i == grid.length - 1 && j == grid[0].length - 1 && minPath > cur) {
            minPath = cur;
            return;
        }
        minPathCur(grid, cur, i + 1, j);
        minPathCur(grid, cur, i, j + 1);
    }

    public static int minPathSumDP(int[][] grid) {
        int[] dp = new int[grid[0].length + 1];
        Arrays.fill(dp, 0);
        for (int i = 0; i < grid.length; i++) {
            if (i == 0){
               for (int p = 1; p <= grid[0].length; p++){
                   dp[p] = dp[p - 1] + grid[i][p - 1];
               }
               continue;
            }
            int[] next = dp.clone();
            for (int j = 1; j <= grid[0].length; j++) {
                if (j == 1){
                    next[j] = dp[j] + grid[i][j - 1];
                    continue;
                }
                next[j] = Math.min(dp[j], next[j - 1]) + grid[i][j - 1];
            }
            dp = next;
        }
        return dp[grid[0].length];
    }

    public static void main(String[] args) {
        int[][] grid = {
                {1, 2, 5},
                {3, 2, 1}//,
              //  {4, 2, 1}
        };
        System.out.println(minPathSumDP(grid));
    }

}
