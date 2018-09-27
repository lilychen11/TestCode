package cn.lily.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Test210 {
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] res = new int[numCourses];
        if (numCourses < 1) {
            return null;
        }
        int[] inDegree = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            int idx = prerequisites[i][0];
            inDegree[idx]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0)
                queue.offer(i);
        }
        int count = 0;
        while (!queue.isEmpty()) {
            int course = queue.peek();
            res[count++] = queue.poll();
            for (int[] pre : prerequisites) {
                if (pre[1] == course) {
                    if (inDegree[pre[0]]-- == 1)
                        queue.offer(pre[0]);
                }
            }
        }
        if (count == numCourses)
            return res;
        else
            return new int[0];
    }

    public static void main(String[] args) {
        int numCourese = 2;
        int[][] pre = {{1,0}, {0,1}};
        System.out.println(findOrder(numCourese, pre));
    }
}
