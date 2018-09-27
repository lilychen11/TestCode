package cn.lily.leetcode;

import java.util.Arrays;

public class Test200 {
    public static int numIslands(char[][] grid) {
        if (grid == null || grid.length < 1) {
            return 0;
        }
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && visited[i][j] == false) {
                    visitIsland(grid, visited, i, j);
                    count++;
                }
            }
        }
        return count;
    }
    public static void visitIsland(char[][] grid, boolean[][] visited, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
            return;
        }
        if (grid[i][j] == '1' && visited[i][j] == false) {
            visited[i][j] = true;
            visitIsland(grid, visited, i + 1, j);
            visitIsland(grid, visited, i, j + 1);
            visitIsland(grid, visited, i - 1, j);
            visitIsland(grid, visited, i, j - 1);
        }
    }

    public static void main(String[] args) {
        boolean[] vidti = new boolean[1];
        char[][] grid = {
                new String("11110").toCharArray(),
                new String("11010").toCharArray(),
                new String("11000").toCharArray(),
                new String("00000").toCharArray()
        };
        char[][] grid1 = {
                new String("11000").toCharArray(),
                new String("11000").toCharArray(),
                new String("00100").toCharArray(),
                new String("00011").toCharArray()
        };
        System.out.println(numIslands(grid1));
    }
}
