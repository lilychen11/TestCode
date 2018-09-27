package cn.lily.leetcode;

import java.util.Stack;

public class Test150 {
    public static int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length < 1) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].matches("-[0-9].*") ||tokens[i].matches("[0-9]*"))
                stack.push(Integer.valueOf(tokens[i]));
            else {
                int numB = stack.pop();
                int numA = stack.pop();
                int result = cal(numA, numB, tokens[i]);
                stack.push(result);
            }
        }
        return stack.peek();
    }
    public static int cal(int a, int b, String o) {
        int result = 0;
        switch (o) {
            case "+":
                result = a + b;
                break;
            case "-":
                result = a - b;
                break;
            case "*":
                result = a * b;
                break;
            case "/":
                if (b != 0)
                result = a / b;
                break;
            default:
                result = 0;
        }
        return result;
    }

    /*public static int Operation(String o) {
        int result;
        switch (o) {
            case "+":
                result = 1;
                break;
            case "-":
                result = 2;
                break;
            case "*":
                result = 3;
                break;
            case "/":
                result = 4;
                break;
            default:
                result = 0;
        }
        return result;
    }*/
    public static void main(String[] args) {
        String[] str = {"4","3","-"};
        System.out.println(evalRPN(str));
    }
}
