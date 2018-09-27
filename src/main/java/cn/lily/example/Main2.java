package cn.lily.example;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main2 {
    public static int longestValidParentheses(String s) {
        if(s == null || s.length() < 0){
            return -1;
        }
        int maxans = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '(' && s.charAt(i) != ')') {
                stack.clear();
                stack.push(i);
                continue;
            }
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.empty()) {
                    stack.push(i);
                } else {
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }
        return maxans;
    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String input = br.readLine().trim();
            System.out.println(longestValidParentheses(input));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
