package cn.lily.leetcode;

import java.util.Arrays;
import java.util.Stack;

public class Test84 {
    public static int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length < 1) {
            return 0;
        }
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        while (i <= heights.length) {
            int h = (i == heights.length ? 0 : heights[i]);
            if (stack.isEmpty() || heights[stack.peek()] <= h) {
                stack.push(i);
                i++;
            } else {
                int top = stack.pop();
                int cur = (i - 1 - (stack.isEmpty() ? -1 : stack.peek())) * heights[top];
                max = Math.max(max, cur);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] heights = {2,1,5,6,2,3};
        System.out.println(largestRectangleArea(heights));
    }
}
