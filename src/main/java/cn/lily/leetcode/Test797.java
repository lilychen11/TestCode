package cn.lily.leetcode;

import java.util.LinkedList;
import java.util.List;

public class Test797 {
    public static List<List<Integer>> allPathSourceTarget(int[][] graph) {
        List<List<Integer>> lists = new LinkedList<>();
        if (graph == null || graph.length == 0)
            return lists;
        boolean[] visit = new boolean[graph.length];
        dfs(graph, visit, 0, new LinkedList<Integer>(), lists);
        return lists;
    }

    public static void dfs(int[][] graph, boolean[] visit, int v, List<Integer> temp, List<List<Integer>> lists) {
        visit[v] = true;
        temp.add(v);
        if (v == graph.length - 1){
            lists.add(new LinkedList<>(temp)) ;
            return;
        }
        for (int node : graph[v]) {
            if (!visit[node]){
                dfs(graph, visit, node, temp, lists);
                temp.remove((Object)node);
                visit[node] = false;
            }
        }

    }

    public static void main(String[] args) {
        int[][] graph = {{1,2}, {3}, {3}, {}};
        System.out.println(allPathSourceTarget(graph));
    }
}
