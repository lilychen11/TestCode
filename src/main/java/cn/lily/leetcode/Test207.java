package cn.lily.leetcode;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Test207 {
    /*public static boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites == null || prerequisites.length < 1 || numCourses < 1) {
            return true;
        }
        Arrays.sort(prerequisites, (p, q) -> (p[1] == q[1] ? p[0]- q[0] : p[1] - q[1]));
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < prerequisites.length; ) {
            int index = 0;
            if (list.contains(prerequisites[i][1])) {
                index = list.indexOf(prerequisites[i][1]);
            } else {
                list.add(prerequisites[i][1],index);
            }
            if (list.contains(prerequisites[i][0]) && prerequisites[i][0] < prerequisites[i][1]) {

            } else {
                if ()
            }

        }
    }*/
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        int[][] matrix = new int[numCourses][numCourses];
        int[] indegree = new int[numCourses];

        for (int i = 0; i < prerequisites.length; i++) {
            int ready = prerequisites[i][0];
            int pre = prerequisites[i][1];
            if (matrix[pre][ready] == 0) {
                indegree[ready]++;
            }
            matrix[pre][ready] = 1;
        }
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0)
                queue.offer(i);
        }
        while (!queue.isEmpty()) {
            int course = queue.poll();
            count++;
            for (int i = 0; i < numCourses; i++) {
                if (matrix[course][i] != 0) {
                    if (--indegree[i] == 0) {
                        queue.offer(i);
                    }
                }
            }
        }
        return count== numCourses;
    }


    public static void main(String[] args) {
        int numCourse = 4;
        int[][] prerequisites = {{2, 0}, {1, 0}, {3, 1}, {3, 2}, {1, 3}};
        System.out.println(canFinish(numCourse, prerequisites));
    }
}
