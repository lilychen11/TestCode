import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = 4, m = 3;
        /*int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] path = new int[m][2];
        for (int i = 0; i < m; i++) {
            path[i][0] = scanner.nextInt();
            path[i][1] = scanner.nextInt();
        }*/
        int[][] path1 = {{2, 1}, {3, 2}, {4, 3}};
        int[][] graph = new int[n][n];
        for (int[] temp : graph) {
            Arrays.fill(temp, n + 1);
        }
        addPath(graph, path1);
        for (int i = 0; i < graph.length; i++) {
            DFS(graph, i, i, new int[1], new LinkedList<Integer>());
        }
        int num = 0;
        for (int i = 0; i < graph.length; i++) {
            int count = 0;
            for (int j = 0; j < graph[0].length; j++) {
                if (graph[i][j] < n + 1)
                    count++;
            }
            for (int col = 0; col < graph.length; col++) {
                if (graph[col][i] < n + 1)
                    count--;
            }
            if (count < 0)
                num++;
        }
        System.out.println(num);
    }

    public static void addPath(int[][] graph, int[][] path) {
        for (int[] road : path) {
            int city = road[0];
            graph[city - 1][road[1] - 1] = 1;
        }
        for (int i = 0; i < graph.length; i++) {
            graph[i][i] = 0;
        }
    }

    public static void DFS(int[][] graph, int sCity, int start, int[] path, List<Integer> temp) {
        if (temp.contains(sCity)) {
            return;
        }
        temp.add(sCity);
        path[0]++;
        for (int other = 0; other < graph[0].length; other++) {
            if (graph[sCity][other] != graph.length + 1) {
                graph[start][other] = Math.min(path[0], graph[start][other]);
                DFS(graph, other, start, path, temp);
            }
        }
        path[0]--;
        temp.remove(temp.size() - 1);
    }

}
