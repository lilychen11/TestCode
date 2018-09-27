package cn.lily.leetcode;

public class Test279 {
    public static int numSquares(int n) {
        if (n < 1) {
            return 0;
        }
       int[] A = new int[n + 1];
        A[1] = 1;
        for (int i = 2; i <= n; i++) {
            int minSteps = Integer.MAX_VALUE;
            int j = 1;
            while (j * j <= i) {
                if (A[i - j* j] < minSteps) {
                    minSteps = A[i - j * j];
                }
                j++;
            }
            A[i] = minSteps + 1;
        }
        return A[n];
    }

    public static void main(String[] args) {
        System.out.println(numSquares(12));
    }
}
