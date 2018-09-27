package cn.lily.leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;

public class Test394 {
    public static String decodeString(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        Stack<Integer> sDigit = new Stack<>();
        Stack<Character> sChar = new Stack<>();
        int times = 0;
        for (int i = 0; i < s.length(); ) {
            if (isDigit(s.charAt(i))) {
                times = 10 * times + Integer.parseInt(s.charAt(i) + "");
                i++;
            } else {
                if (times > 0){
                    sDigit.push(times);
                    times = 0;
                }
                if (s.charAt(i) == '['){
                    while (s.charAt(i) != ']' && !isDigit(s.charAt(i))){
                        sChar.push(s.charAt(i));
                        i++;
                    }
                  i--;
                } else if (s.charAt(i) == ']'){
                    String temp ="";
                    while (sChar.peek() != '['){
                        temp += sChar.pop();
                    }
                    sChar.pop();
                    int time = sDigit.pop();
                    for (int j = 0; j < time; j++) {
                        for (int index  = temp.length() - 1; index >= 0; index--) {
                            sChar.add(temp.charAt(index));
                        }
                    }
                } else {
                    sChar.add(s.charAt(i));
                }
                i++;
            }
        }
         StringBuffer res = new StringBuffer();
        while (sChar.size() > 0){
            res.append(sChar.pop());
        }
        return new String(res.reverse());
    }

    public static boolean isDigit(char s) {
        if (s >= '0' && s <= '9') {
            return true;
        }
        return false;
    }
    public String decodeString2(String s) {
        Deque<Integer> count = new ArrayDeque<>();
        Deque<String> result = new ArrayDeque<>();
        result.push("");
        int i = 0;
        while (i < s.length()) {
            char ch = s.charAt(i);
            if (ch >= '0' && ch <= '9') {
                int start = i;
                while (s.charAt(i + 1) >= '0' && s.charAt(i + 1) <= '9') i++;
                count.push(Integer.parseInt(s.substring(start, i + 1)));
            } else if (ch == '[') {
                result.push("");
            } else if (ch == ']') {
                int cnt = count.pop();
                String cur = result.pop();
                StringBuilder sb = new StringBuilder();
                while (cnt-- > 0) {
                    sb.append(cur);
                }
                result.push(result.pop() + sb.toString());
            } else {
                result.push(result.pop() + ch);
            }
            i++;
        }
        return result.pop();
    }
    public static void main(String[] args) {
        String s = "3[a]2[bc]";
        String s0 = "3[a2[c]]";
        String s1 = "2[abc]3[cd]ef";
        String temp = "100[leetcode]";
        System.out.println(decodeString(s));
        System.out.println(decodeString(s0));
        System.out.println(decodeString(s1));
        System.out.println(decodeString(temp));
    }
}
