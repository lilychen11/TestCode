package cn.lily.leetcode;

public class Test289 {
    public static void gameOfLife(int[][] board) {
        int rows=board.length;
        int cols=board[0].length;
        for(int i=0;i<rows;++i){
            for(int j=0;j<cols;++j){
                int neighbors = getNeighbour(board, i, j);
                if(board[i][j]==1){
                    if(neighbors==2 || neighbors==3)
                        board[i][j]=3;
                }else{
                    if(neighbors==3)
                        board[i][j]=2;
                }
            }
        }
        for(int i=0;i<rows;++i){
            for(int j=0;j<cols;++j){
                board[i][j]>>=1;
            }
        }
    }

    private static int getNeighbour(int[][] board, int row, int col){
        int cnt=0;
        for(int i=row-1;i<=row+1;++i){
            for(int j=col-1;j<=col+1;++j){
                if(i>=0 && i<board.length && j>=0 && j<board[0].length){
                    cnt += board[i][j]&1;
                }
            }
        }
        cnt-=board[row][col]&1;
        return cnt;
    }

    public static void gameOfLife1(int[][] board) {
        if (board == null || board.length < 1) return;
        int[] last = new int[board.length];
        for (int i = 0; i < board.length; i++) {
            int[] cur = board[i].clone();
            for (int j = 0; j < board[0].length; j++) {
                check(last, cur, board, i, j);
            }
            last = cur;
        }
    }
    public static void check(int[] last, int[] cur, int[][] board, int i, int j) {
        int count= 0;

        count += last(last, board, i - 1, j);
        count += last(last, board, i - 1, j + 1);
        count += last(last, board, i - 1, j - 1);

        count += cur(cur, board, i, j + 1);
        count += cur(cur, board, i, j - 1);

        count += down(board, i + 1, j + 1);
        count += down(board, i + 1, j);
        count += down(board, i + 1, j - 1);
        if (board[i][j] == 1) {
            if (count < 2 || count > 3) board[i][j] = 0;
        } else {
            if (count == 3) board[i][j] = 1;
        }
    }
    public static int last(int[] last, int[][] board, int i, int j){
        if (i < 0 || j < 0 || i >= board.length || j >= last.length) return 0;
        if (last[j] == 1)
            return 1;
        return 0;
    }
    public static int cur(int[] cur, int[][] board, int i, int j){
        if (i < 0 || j < 0 || i >= board.length || j >= cur.length) return 0;
        if (cur[j] == 1)
            return 1;
        return 0;
    }
    public static int down(int[][] board, int i, int j){
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) return 0;
        if (board[i][j] == 1)
            return 1;
        return 0;
    }

    public static void main(String[] args) {
        int[][] board = {{0,1,0},
                {0,0,1},
                {1,1,1},
                {0,0,0}};
        gameOfLife(board);
        System.out.println(board);
    }
}
