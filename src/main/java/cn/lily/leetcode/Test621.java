package cn.lily.leetcode;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.*;

public class Test621 {
    public static int leastInterval1(char[] task, int n){
        int[] map = new int[26];
        for (char c : task) {
            map[c -'A']++;
        }
        Arrays.sort(map);
        int time = 0;
        while (map[25] > 0) {
            int i = 0;
            while (i <= n) {
                if (map[25] == 0) {
                    break;
                }
                if (i < 26 && map[25 - i] > 0) {
                    map[25 - i]--;
                }
                time++;
                i++;
            }
            Arrays.sort(map);
        }
        return time;
    }
    public static int leastInterval2(char[] tasks, int n) {
        int[] map = new int[26];
        for (char c : tasks){
            map[c - 'A']++;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(26, Collections.reverseOrder());
        for (int f: map) {
            if (f > 0) {
                queue.add(f);
            }
        }
        int time = 0;
        while (!queue.isEmpty()) {
            int i = 0;
            List<Integer> temp = new ArrayList<>();
            while (i <= n) {
                if (!queue.isEmpty()) {
                    if (queue.peek() > 1) {
                        temp.add(queue.poll() - 1);
                    } else {
                        queue.poll();
                    }
                }
                time++;
                if (queue.isEmpty() && temp.size() == 0) {
                    break;
                }
                i++;
            }
            for (int l : temp) {
                queue.add(l);
            }
        }
        return time;
    }

    public static int leastInterval3(char[] tasks, int n) {
        int[] map = new int[26];
        for (char c : tasks) {
            map[c - 'A']++;
        }
        Arrays.sort(map);
        int max_val = map[25] - 1, idle_slots = max_val * n;
        for (int i = 24; i >= 0 && map[i] > 0; i--) {
            idle_slots -= Math.min(max_val, map[i]);
        }
        return idle_slots > 0 ? idle_slots + tasks.length : tasks.length;
    }

    public static void main(String[] args) {
        char[] tasks = {'A','A','A','B','B','B'};
        int n = 2;
        System.out.println(leastInterval1(tasks, n));
        System.out.println(leastInterval2(tasks, n));
        System.out.println(leastInterval3(tasks, n));

    }
}
