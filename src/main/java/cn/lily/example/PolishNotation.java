package cn.lily.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

class Operation {
    private static int ADDITION = 1;
    private static int SUBTRACTION = 1;
    private static int MULTIPLICATION = 2;
    private static int DIVISION = 2;

    public static int getValue(String operation) {
        int result;
        switch (operation){
            case "+" :
                result = ADDITION;
                break;
            case "-" :
                result = SUBTRACTION;
                break;
            case  "*" :
                result = MULTIPLICATION;
                break;
            case "/":
                result = DIVISION;
                break;
            default:
                result = 0;
        }
        return result;
    }
}

public class PolishNotation {
    public static List<String> toInfixExpression(String s) {
        List<String> ls = new ArrayList<String>();
        int i = 0;
        String str;
        char c;
        do {
            if ((c = s.charAt(i)) < 48 || (c = s.charAt(i)) > 57) {
                ls.add("" + c);
                i++;
            } else {
                str = "";
                while (i < s.length() && (c = s.charAt(i)) >= 48 && (c = s.charAt(i)) <= 57) {
                    str += c;
                    i++;
                }
                ls.add(str);
            }
        } while (i < s.length());
        return ls;
    }
    public static List<String > parseSuffixExpression(List<String> ls) {
        Stack<String> s1 = new Stack<>();//operation
        Stack<String> s2 = new Stack<>();// nums
        List<String> lss = new ArrayList<>();
        for (String ss : ls) {
            if (ss.matches("\\d+")) {
                s2.push(ss);
            } else if ((ss.equals("(")) || s1.isEmpty()) {
                s1.push(ss);
            } else if (ss.equals(")")) {
                while (!s1.peek().equals("(")) {
                    s2.add(s1.pop());
                }
                s1.pop();
            } else {
                while (s1.size() != 0 && Operation.getValue(s1.peek()) > Operation.getValue(ss))
                    s2.add(s1.pop());
                s1.push(ss);
            }
        }
        while (s1.size() > 0){
            s2.add(s1.pop());
        }
        while (!s2.isEmpty()){
            lss.add(0,s2.pop());
        }
        return lss;
    }
    public static int calculate(List<String> ls) {
        Stack<String> s = new Stack<>();
        for (String str: ls) {
            if (str.matches("\\d+")) {
                s.push(str);
            } else {
                int b = Integer.parseInt(s.pop());
                int a = Integer.parseInt(s.pop());
                int result = 0;
                if (str.equals("+")) {
                    result = a + b;
                } else if (str.equals("-")) {
                    result = a - b;
                } else if (str.equals("*")) {
                    result = a * b;
                } else if (str.equals("/")) {
                    result = a / b;
                }
                s.push("" + result);
            }
        }
        System.out.println(s.peek());
        return Integer.parseInt(s.pop());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("please input expression");
        String expression = scanner.nextLine();
        List<String> zx = toInfixExpression(expression);
        List<String> rpn = parseSuffixExpression(zx);
        String rpnStr = "";
        for (String str : rpn) {
            rpnStr += str;
        }
        System.out.println(rpnStr);
        System.out.println("The result is " + calculate(rpn));

    }
}
