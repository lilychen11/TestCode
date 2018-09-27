import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static int findMin(int[][] matrix, int n) {
        int path = 0;
        int[] inDegree = new int[n + 1];
        int[] outDegree = new int[n + 1];
        int[] dist = new int[n + 1];
        Arrays.fill(dist, n);
        dist[1] = 0;
        for (int i = 0; i < matrix.length; i++) {
            int row = matrix[i][0];
            int col = matrix[i][1];
            inDegree[col]++;
            outDegree[row]++;
        }
        Queue<Integer> end = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (outDegree[i] == 0){
                end.offer(i);
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        while (!queue.isEmpty()) {
            int idx = queue.poll();
            for (int[] temp : matrix) {
                if (temp[0] == idx) {
                    dist[temp[1]] = Math.min(1 + dist[temp[0]], dist[temp[1]]);
                    queue.offer(temp[1]);
                }
            }
        }
        int min = Integer.MAX_VALUE;
        while (!end.isEmpty()){
            min = Math.min(min, dist[end.peek()]);
            path += dist[end.poll()];
        }
        return path + min;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] matrix = new int[n - 1][2];
        for (int i = 0; i < n - 1; i++) {
            matrix[i][0] = scanner.nextInt();
            matrix[i][1] = scanner.nextInt();

        }
        System.out.println(findMin(matrix, n));
    }
}
