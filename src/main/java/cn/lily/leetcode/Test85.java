package cn.lily.leetcode;

import java.util.Arrays;
import java.util.Stack;

public class Test85 {
    /*public static int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length < 1)
            return 0;
        int max = 0;
        int[][][] area = new int[matrix.length][matrix[0].length][2];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int slide = 0;
                if (i == 0) {
                    area[i][j][0] = matrix[i][j] - '0';
                    area[i][j][1] = matrix[i][j] - '0';
                    if (matrix[i][j] == '1' && j > 0){
                        area[i][j][0] = area[i][j - 1][0] + 1;
                    }

                } else if (j == 0) {
                    area[i][j][0] = matrix[i][j] - '0';
                    area[i][j][1] = matrix[i][j] - '0';
                    if (matrix[i][j] == '1')
                        area[i][j][1] = area[i - 1][j][1] + 1;

                } else {
                    if (matrix[i][j] == '1') {
                        area[i][j][0] = area[i][j - 1][0] + 1;
                        area[i][j][1] = area[i - 1][j][1] + 1;
                    }
                    if (matrix[i][j] == '1' && matrix[i - 1][j] == '1' && matrix[i][j - 1] == '1' && matrix[i - 1][j - 1] == '1') {
                        int height = Math.min(area[i - 1][j - 1][1], area[i - 1][j][1]) + 1;
                        int width = Math.min(area[i - 1][j - 1][0], area[i][j - 1][0]) + 1;
                        slide = height * width;
                        max = Math.max(slide, max);
                    }
                }
                max = Math.max(max, (area[i][j][0] > area[i][j][1] ? area[i][j][0] : area[i][j][1]));
            }
        }
        return max;
    }*/
    public static int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int[] height = new int[matrix[0].length];
        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i] == '1') height[i] = 1;
        }
        int result = largestInLine(height);
        for (int i = 1; i < matrix.length; i++) {
            resetHeight(matrix, height, i);
            result = Math.max(result, largestInLine(height));
        }
        return result;
    }
    private static void resetHeight(char[][] matrix, int[] height, int idx) {
        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[idx][i] == '1') height[i] += 1;
            else height[i] = 0;
        }
    }
    public static int largestInLine(int[] height) {
        if (height == null || height.length == 0) return 0;
        int len = height.length;
        Stack<Integer> s = new Stack<>();
        int maxArea = 0;
        for (int i = 0; i <= len; i++) {
            int h = (i == len ? 0 : height[i]);
            if (s.isEmpty() || h >= height[s.peek()]) {
                s.push(i);
            } else {
                int tp = s.pop();
                maxArea = Math.max(maxArea, height[tp] * (s.isEmpty() ? i : i - 1 - s.peek()));
                i--;
            }
        }
        return maxArea;
    }
    public static int maximalRectangle1(char[][] matrix) {
        if (matrix == null && matrix.length < 1)
            return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[] left = new int[n];
        int[] right = new int[n];
        int[] height = new int[n];
        //Arrays.fill(left, 0);
        Arrays.fill(right, n);
        //Arrays.fill(height, 0);
        int maxA = 0;
        for (int i = 0; i < m; i++) {
            int cur_left  = 0, cur_right = n;
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1')
                    height[j]++;
                else
                    height[j] = 0;
            }
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') left[j] = Math.max(left[j], cur_left);
                else {
                    left[j] = 0;
                    cur_left = j + 1;
                }
            }
            for (int j = n - 1; j >= 0; j--) {
                if (matrix[i][j] == '1')
                    right[j] = Math.min(right[j], cur_right);
                else {
                    right[j] = n;
                    cur_right = j;
                }
            }
            for (int j = 0; j < n; j++) {
                maxA = Math.max(maxA, (right[j] - left[j]) * height[j]);
            }
        }
        return maxA;
    }

    public static void main(String[] args) {
        char[][] matrix = {
                {'0', '1', '1', '0', '1'},
                {'1', '1', '0', '1', '0'},
                {'0', '1', '1', '1', '0'},
                {'1', '1', '1', '1', '0'},
                {'1', '1', '1', '1', '1'}
        };
        char[][] matrix1 = {{'0', '0'}, {'0', '0'}};
        char[][] matrix2 = {{'1','1','1','1','1','1','1','1'},{'1','1','1','1','1','1','1','0'},{'1','1','1','1','1','1','1','0'},{'1','1','1','1','1','0','0','0'},{'0','1','1','1','1','0','0','0'}};
        char[][] matrix3 = {{'1'}};
        System.out.println(maximalRectangle(matrix3));
    }
}
