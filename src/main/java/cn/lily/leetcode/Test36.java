package cn.lily.leetcode;

import java.util.HashSet;

public class Test36 {
    public static boolean isValidSudoku(char[][] board) {
        if (board == null || board.length == 0)
            return false;
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j]!= '.'){
                    if (!set.add(board[i][j] + "in row" + i) || !set.add(board[i][j] + "in col" + j) || !set.add(board[i][j] + "in block" + i / 3 + "-" + j / 3)){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
