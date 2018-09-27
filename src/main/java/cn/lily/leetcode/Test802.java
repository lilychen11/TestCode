package cn.lily.leetcode;

import java.util.LinkedList;
import java.util.List;

public class Test802 {
    public static List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> list = new LinkedList<>();
        if (graph == null || graph.length < 1)
            return list;
        int[] visit = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            /*if (visit[i])
                continue;*/
            if (!hasCycle(graph, visit, i)) {
                list.add(i);
            }
        }
        return list;
    }

    public static boolean hasCycle(int[][] graph, int[] visit, int idx) {
        if (visit[idx] == 1)
            return true;
        visit[idx] = 1;
        for (int tId : graph[idx]) {
            if (visit[tId] == 2)
                continue;
            if(visit[tId] ==1 || hasCycle(graph, visit, tId))
                return true;
        }
        visit[idx] = 2;
        return false;
    }

    public static void main(String[] args) {
        int[][] graph = {{1,2},{2,3},{5},{0},{5},{},{}};
        System.out.println(eventualSafeNodes(graph));
    }
}
