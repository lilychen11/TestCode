package cn.lily.leetcode;

import java.util.Arrays;

public class Test329 {

    public static int max = 0;

    public static int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length < 1) {
            return 0;
        }
        int[][] path = new int[matrix.length + 1][matrix[0].length + 1];
        for (int[] temp : path)
            Arrays.fill(temp, 1);
        Arrays.fill(path[0], 0);
        for (int i = 0; i < path.length; i++) {
            path[i][0] = 0;
        }
        int[][] pathDown = new int[matrix.length + 1][];
        for (int i = 0; i < path.length; i++) {
            pathDown[i] = path[i].clone();
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++)
                DP(matrix, path, pathDown, i, j);
        }
        return max;
    }

    public static void DP(int[][] matrix, int[][] path, int[][] pathDown, int row, int col) {
        if (row > 0) {
            if (matrix[row][col] > matrix[row - 1][col])
                path[row + 1][col + 1] = Math.max(path[row][col + 1] + 1, path[row + 1][col + 1]);
            if (matrix[row][col] < matrix[row - 1][col])
                pathDown[row + 1][col + 1] = Math.max(pathDown[row][col + 1] + 1, pathDown[row + 1][col + 1]);
        }
        if (col > 0) {
            if (matrix[row][col] > matrix[row][col - 1])
                path[row + 1][col + 1] = Math.max(path[row + 1][col] + 1, path[row + 1][col + 1]);
            if (matrix[row][col] < matrix[row][col - 1])
                pathDown[row + 1][col + 1] = Math.max(pathDown[row + 1][col] + 1, pathDown[row + 1][col + 1]);
        }
        max = Math.max(max, path[row + 1][col + 1]);
        max = Math.max(max, pathDown[row + 1][col + 1]);
    }

    public static void main(String[] args) {
        int[][] nums = {{9, 9, 4}, {6, 6, 8}, {2, 1, 1}};
        //int[][] nums = {{3, 4, 5}, {3, 2, 6}, {2, 2, 1}};
        System.out.println(longestIncreasingPath(nums));

    }
}

