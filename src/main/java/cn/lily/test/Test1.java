package cn.lily.test;

import java.util.Arrays;
import java.util.Scanner;

public class Test1 {
    public static int maxScore(int n, int k, int[] scores, int[] states) {
        if (n < 1 || k < 1 || scores.length != n || states.length != n) {
            return 0;
        }
        if (n <= k) {
            int temp = 0;
            for (int i = 0; i < n; i++) {
                temp += scores[i];
            }
            return temp;
        }
        int stemp = 0;
        for (int i = 0; i < n; i++) {
            if (states[i] == 1) {
                stemp += scores[i];
            }
        }
        int max = stemp;
        int[] dp = new int[n];
        Arrays.fill(dp, stemp);
        for (int i = 0; i < n - k; i++) {
            for (int j = i + 1; j <= i + k ; j++) {
                if (states[j] == 0) {
                    dp[i] += scores[j];
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        if (n < 1 || k < 1) {
            throw new IllegalArgumentException("Illegal input");
        }
        int[] scores = new int[n];
        int[] states = new int[n];
        for (int i = 0; i < n; i++) {
            scores[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            states[i] = scanner.nextInt();
        }
        System.out.println(maxScore(n,k, scores, states));
    }
}