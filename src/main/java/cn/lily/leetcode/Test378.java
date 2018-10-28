package cn.lily.leetcode;

import java.util.PriorityQueue;

public class Test378 {
    public static int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        //boolean flag = false;
        PriorityQueue<Integer> pq = new PriorityQueue<>((p, q) -> (q - p));
        pq.offer(Integer.MAX_VALUE);
        for (int i = 0; i < n; i++) {
            if (pq.size() == k && matrix[i][i] > pq.peek())
                break;
            for (int j = i; j < n; j++) {
                int row = i;
                int col = j;
                while (row < n && matrix[row][j] < pq.peek()) {
                    while (pq.size() >= k)
                        pq.poll();
                    pq.offer(matrix[row][j]);
                    //flag = true;
                    row++;
                }
                while (col + 1 < n && matrix[i][col + 1] < pq.peek()) {
                    while (pq.size() >= k)
                        pq.poll();
                    pq.offer(matrix[i][col + 1]);
                    //flag = true;
                    col++;
                }
                break;
            }

        }
        return pq.peek();
    }
    public static int kthSmallest1(int[][] matrix, int k){
        int n = matrix.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((p,q)->(p[2] - q[2]));
        for (int j = 0; j <= n - 1; j++) {
            pq.offer(new int[]{0, j, matrix[0][j]});
        }
        for (int i = 0; i < k - 1; i++) {
            int[] temp = pq.poll();
            if (temp[0] == n - 1) continue;
            pq.offer(new int[]{temp[0] + 1, temp[1], matrix[temp[0] + 1][temp[1]]});
        }
        return pq.poll()[2];
    }
    public static void main(String[] args) {

        //int k = 9521;
        //System.out.println(kthSmallest(matrix, k));
        System.out.println(Integer.MAX_VALUE);
    }
}
