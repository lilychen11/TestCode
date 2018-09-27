package cn.lily.leetcode;

import java.util.HashMap;
import java.util.Stack;

public class Test20 {
    public static boolean isValid(String s) {
        HashMap<Character, Character> mapLeft = new HashMap<>();
        mapLeft.put('(', ')');
        mapLeft.put('{', '}');
        mapLeft.put('[', ']');
        if (s == null || s.length() < 1) {
            return true;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (mapLeft.containsKey(s.charAt(i))) {
                stack.add(s.charAt(i));
                continue;
            }
            if (mapLeft.containsValue(s.charAt(i))) {
                if (!stack.isEmpty() && mapLeft.get(stack.peek()) == s.charAt(i)) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        if (stack.isEmpty()) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String temp = "()";
        String temp1 = "()[]{}";
        String temp2 = "(]";
        String temp3 = "([)]";
        String temp4= "{[]}";
        System.out.println(isValid(temp));
        System.out.println(isValid(temp1));
        System.out.println(isValid(temp2));
        System.out.println(isValid(temp3));
        System.out.println(isValid(temp4));

    }
}
