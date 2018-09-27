package cn.lily.leetcode;

import java.util.Arrays;

public class Test542 {
    public static int[][] updateMatrix(int[][] matrix) {
        if (matrix == null || matrix.length < 1) {
            return matrix;
        }
        int[][] dist = new int[matrix.length][matrix[0].length];

        int row = matrix.length;
        int col = matrix[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                dist[i][j] = row + col;
                if (matrix[i][j] == 0)
                    dist[i][j] = 0;
                else {
                    if (i > 0)
                        dist[i][j] = Math.min(dist[i][j], dist[i - 1][j] + 1);
                    if (j > 0)
                        dist[i][j] = Math.min(dist[i][j], dist[i][j - 1] + 1);
                }
            }
        }
        for (int i = row - 1; i >= 0; i--) {
            for (int j = col - 1; j >= 0; j--) {
                if (i < row - 1)
                    dist[i][j] = Math.min(dist[i][j], dist[i + 1][j] + 1);
                if (j < col - 1)
                    dist[i][j] = Math.min(dist[i][j], dist[i][j + 1] + 1);
            }
        }
        return dist;
    }

    public static void main(String[] args) {
        int[][] matrix = {{0, 0, 0},{0, 1, 0},{0, 0, 0}};
        System.out.println(updateMatrix(matrix));
    }
}
