package cn.lily.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Test239 {
    public static int[] maxSlidingWindow(int[] a, int k) {
        if (a == null || k < 1) {
            return new int[0];
        }
        int n = a.length;
        int[] r = new int[n - k + 1];
        int ri = 0;
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < a.length; i++) {
            while (!q.isEmpty() && q.peek() < i - k + 1){
                q.poll();
            }
            while (!q.isEmpty() && a[q.peekLast()] < a[i]) {
                q.pollLast();
            }
            q.offer(i);
            if (i >= k - 1) {
                r[ri++] = a[q.peek()];
            }
        }
        return r;
    }

    public static void main(String[] args) {
        int[] nums = {7, 2, 4};
        int k = 2;
        System.out.println(maxSlidingWindow(nums, k));
    }
}
