package cn.lily.leetcode;

public class Test221 {
    public static int maximalSquare(char[][] matrix) {
        int rows = matrix.length, cols = matrix.length > 0 ? matrix[0].length : 0;
        int[][] dp = new int[rows + 1][cols + 1];
        int maxsqlen = 0;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
                    maxsqlen = Math.max(maxsqlen, dp[i][j]);
                }
            }
        }
        return maxsqlen * maxsqlen;
    }

    public static int maximalSquare1(char[][] matrix) {
        int rows = matrix.length, cols = matrix.length > 0 ? matrix[0].length : 0;
        int[] dp = new int[cols + 1];
        int maxsqLen = 0, prev = 0;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                int temp = dp[j];
                if (matrix[i - 1][j - 1] == '1') {
                    dp[j] = Math.min(Math.min(dp[j], dp[j - 1]), prev) + 1;
                    maxsqLen = Math.max(dp[j], maxsqLen);
                } else {
                    dp[j] = 0;
                }

                prev = temp;
            }
        }
        return maxsqLen * maxsqLen;
    }

    public static void main(String[] args) {
        char[][] matrix = {{'1', '0', '1', '1', '1'},
                {'0', '1', '0', '1', '0'},
                {'1', '1', '0', '1', '1'},
                {'1', '1', '0', '1', '1'},
                {'0', '1', '1', '1', '1'}};
        char[][] matrix2 = {{'1', '1'},{'1', '1'}};
        System.out.println(maximalSquare1(matrix));
    }

}
