package cn.lily.example;

import java.util.Stack;

public class Test {
    public static int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length < 1 || matrix[0].length < 1) {
            return 0;
        }
        int max = 0;
        int[] height = new int[matrix[0].length];
        for(int i = 0; i < matrix.length; i++) {
            setHeight(matrix, height, i);
            max = Math.max(findMaxArea(height), max);
        }
        return max;
    }
    private static void setHeight(char[][] matrix, int[] height, int i){
        for(int j = 0; j < matrix[0].length; j++){
            if(matrix[i][j] == '1')
                height[j]++;
            else
                height[j] = 0;
        }
    }
    private static int findMaxArea(int[] height) {
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i <= height.length; i++) {
            int num;
            if(i == height.length)
                num = 0;
            else
                num = height[i];

            while(!stack.isEmpty() && height[stack.peek()] > num) {
                int top = stack.pop();
                int temp = (i -  (stack.isEmpty() ? 0 : stack.peek() + 1 )) *  height[top];
                max = Math.max(max, temp);
            }
            stack.push(i);
        }
        return max;
    }

    public static void main(String[] args) {
        char[][] matrix = {{'1','1'}};
        System.out.println(maximalRectangle(matrix));
    }
}
