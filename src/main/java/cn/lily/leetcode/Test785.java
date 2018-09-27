package cn.lily.leetcode;

public class Test785 {
    public static boolean isBipartite(int[][] graph) {
        if (graph == null || graph.length < 1)
            return false;
        boolean[] visit = new boolean[graph.length];
        int[] colors = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!visit[i])
                if(!dfs(graph, visit, colors, i))
                    return false;
        }
        return true;
    }

    public static boolean dfs(int[][] graph, boolean[] visit, int[] color, int vIdx) {
        visit[vIdx] = true;
        for (int idx : graph[vIdx]) {
            if (!visit[idx]) {
                //visit[idx] = true;
                color[idx] = 1 - color[vIdx];
                dfs(graph, visit, color, idx);
            } else if (color[idx] == color[vIdx])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] graph = {{1},{0,3},{3},{1,2}};
        System.out.println(isBipartite(graph));
    }

}
