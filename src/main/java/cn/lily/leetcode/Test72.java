package cn.lily.leetcode;

public class Test72 {
    public static int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int[][] cost = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++)
            cost[i][0] = i;
        for (int i = 0; i <= n; i++)
            cost[0][i] = i;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (word1.charAt(i) == word2.charAt(j))
                    cost[i + 1][j + 1] = cost[i][j];
                else {
                    int a = cost[i][j];
                    int b = cost[i][j + 1];//delete
                    int c = cost[i + 1][j];//insert
                    cost[i + 1][j + 1] = Math.min(Math.min(a, b), c) + 1;
                }
            }
        }
        return cost[m][n];
    }

    public static void main(String[] args) {
        String str1 = "";
        String str2 = "a";
        System.out.println(minDistance(str1, str2));
    }
}
