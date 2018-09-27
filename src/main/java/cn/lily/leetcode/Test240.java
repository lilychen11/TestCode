package cn.lily.leetcode;

public class Test240 {
    /*public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length < 1) {
            return false;
        }
        int cols = matrix[0].length - 1, rows = matrix.length - 1;
        return searchCur(matrix, target, 0 , 0 ,rows, cols);
    }

    public static boolean searchCur(int[][] matrix, int target, int rowStart, int colStart, int rows, int cols) {
        if (rows == rowStart && cols != colStart) {
            for (int i = 0; i <= cols; i++) {
                if (matrix[rows][i] == target) {
                    return true;
                }
                if (matrix[rows][i] > target) {
                    return false;
                }
            }
        }
        if (cols == colStart) {
            for (int i = 0; i <= rows; i++) {
                if (matrix[i][cols] == target) {
                    return true;
                } else
                if (matrix[i][cols] > target) {
                    return false;
                }
            }
        }
        int temp = Integer.MAX_VALUE;
        int row = rows, col = cols;
        while (temp >= target && rowStart < row && colStart < col) {
            temp = matrix[row][col];
            if (temp == target) {
                return true;
            }
            row--;
            col--;
        }

        return searchCur(matrix, target, row + 1, 0, rows, col ) || searchCur(matrix, target, 0, col + 1, row, cols);
    }
*/
    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length < 1) {
            return false;
        }
        int row = 0, col = matrix[0].length - 1;
        while (col >= 0 && row < matrix[0].length) {
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] < target) {
                row++;
            } else {
                col--;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[][] matrix = {{}};
        int target = -2;
        System.out.println(searchMatrix(matrix, target));
    }
}
