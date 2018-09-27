package cn.lily.leetcode;

import java.util.Arrays;

public class Test79 {
    public static boolean exist(char[][] board, String word) {
        if (word != null && board == null || board.length < 0) {
            return false;
        }
        boolean[][] visit = new boolean[board.length][board[0].length];
        boolean flag = false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    flag = backTrack(board, word, i, j, visit, 0);
                }
                if (flag) return flag;
            }
        }
        return false;
    }

    public static boolean backTrack(char[][] board, String word, int i, int j, boolean[][] visit, int index) {
        if (index == word.length()) {
            return true;
        }
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || visit[i][j] == true) {
            return false;
        }
        if (word.charAt(index) == board[i][j]) {
            visit[i][j] = true;
            boolean a, b, c, d;
            a = backTrack(board, word, i, j + 1, visit, index + 1);
            b = backTrack(board, word, i, j - 1, visit, index + 1);
            c = backTrack(board, word, i + 1, j, visit, index + 1);
            d = backTrack(board, word, i - 1, j, visit, index + 1);
            if (!a && !b && !c && !d) {
                visit[i][j] = false;
                return false;
            } else {
                return true;
            }

        }
        return false;
    }

    public static void main(String[] args) {
        char[][] board = {{'C', 'A', 'A'},
                {'A', 'A', 'A'},
                {'B', 'C', 'D'}};
        char[][] board1 = {{'a'}};
        String word = "AAB";
        System.out.println(exist(board, word));
    }
}
