package cn.lily.leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class Test227 {
    public static int calculates(String s) {
        Deque<Integer> num = new LinkedList<>();
        Deque<Character> oper = new LinkedList<>();
        boolean isNum = true;
        for (int i = 0; i <= s.length(); i++) {
            if (i != s.length() && s.charAt(i) == ' ')
                continue;
            if (i != s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                if (isNum && !num.isEmpty()) {
                    num.addLast(num.removeLast() * 10 + Integer.parseInt(s.charAt(i) + ""));
                } else
                    num.addLast(Integer.parseInt(s.charAt(i) + ""));
                isNum = true;
            } else {
                isNum = false;
                if (i != s.length() && !oper.isEmpty() && ((s.charAt(i) == '*' || s.charAt(i) == '/') && oper.getLast() != '*' && oper.getLast() != '/')) {
                    oper.addLast(s.charAt(i));
                } else {
                    if (i != s.length() && oper.isEmpty()) {
                        oper.addLast(s.charAt(i));
                        continue;
                    }
                    while (oper.size() > 0 && (oper.getLast() == '*' || oper.getLast() == '/')) {
                        int num2 = num.removeLast();
                        int num1 = num.removeLast();
                        int res = cal(num1, num2, oper.removeLast());
                        num.addLast(res);
                    }
                    if ((i != s.length() && s.charAt(i) != '*' && s.charAt(i) != '/') || i == s.length()) {
                        while (oper.size() > 0) {
                            int num1 = num.removeFirst();
                            int num2 = num.removeFirst();
                            int res = cal(num1, num2, oper.removeFirst());
                            num.addFirst(res);
                        }
                    }
                    if (i != s.length())
                        oper.addLast(s.charAt(i));
                }
            }
        }
        return num.peek();
    }

    public static int cal(int num1, int num2, char oper) {
        int res = 0;
        switch (oper) {
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num1 - num2;
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num1 / num2;
                break;
        }
        return res;
    }

    public static void main(String[] args) {
        String expression = "2995-9/3*3*3-138*9";
        System.out.println(calculates(expression));
    }
}
