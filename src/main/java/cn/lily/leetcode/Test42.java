package cn.lily.leetcode;

import java.util.Stack;

public class Test42 {
    public static int trap(int[] height) {
        if (height == null || height.length < 1) {
            return 0;
        }
        int start = 0;
        int frontFlag = 0;
        int water = 0;
        while (start < height.length) {
            for (int i = start; i < height.length - 1; i++) {
                if (height[i] >= height[i + 1]) {
                    frontFlag = i;
                    break;
                }
            }
            int j = frontFlag;
            while (j < height.length - 1 && height[j] >= height[j + 1]) {
                j++;
            }
            int endFlag = j;
            while (endFlag < height.length - 1 && height[endFlag] <= height[endFlag + 1]) {
                endFlag++;
            }
            int minFlag = Math.min(height[frontFlag], height[endFlag]);
            if (minFlag == height[endFlag]) {
                for (int i = endFlag + 1; i < height.length; i++) {
                    if (height[endFlag] < height[i]) {
                        endFlag = i;
                        if (height[endFlag] > height[frontFlag]) {
                            break;
                        }
                    }
                }
                minFlag = Math.min(height[frontFlag], height[endFlag]);
            }
            for (int i = frontFlag; i <= endFlag &&
                    endFlag < height.length; i++) {
                water += Math.max(0, minFlag - height[i]);
            }
            start = endFlag;
            if (endFlag == height.length - 1)
                break;
        }
        return water;
    }

    public static int trap1(int[] height) {
        int ans = 0;
        int[] left_max = new int[height.length];
        left_max[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            left_max[i] = Math.max(left_max[i - 1], height[i]);
        }
        int[] right_max = new int[height.length];
        right_max[height.length - 1] = height[height.length - 1];
        for (int i = height.length - 2; i >=0 ; i--) {
            right_max[i] = Math.max(right_max[i + 1], height[i]);
        }
        for (int i = 1; i < height.length - 1; i++) {
            ans += Math.min(left_max[i], right_max[i]) - height[i];
        }
        return ans;
    }
    public static int trap2(int[] height) {
        int ans = 0, current =  0;
        Stack<Integer> stack = new Stack<>();
        while (current < height.length) {
            while (!stack.isEmpty() && height[current] > height[stack.peek()]){
                int top = stack.pop();
                if(stack.isEmpty())
                    break;
                int distance = current - stack.peek() - 1;
                int bounded_height = Math.min(height[current], height[stack.peek()]) - height[top];
                ans += distance * bounded_height;
            }
            stack.push(current++);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] height = {5, 2, 1, 5, 1, 7};
        System.out.println(trap1(height));
        System.out.println(trap2(height));
    }
}
