package cn.lily.leetcode;

import java.util.LinkedList;
import java.util.List;

public class Test5 {
    public static String longestPalinadrome(String s) {
        if (s == null) {
            return "";
        }
        List<Character> list = new LinkedList<Character>();
        int start = 0;
        int end = 0;
        char[] temp = s.toCharArray();
        for (char c : temp) {
            end++;
            if (list.contains(c)) {
                start = list.indexOf(c);
                list.add(c);
                break;
            } else {
                list.add(c);

            }
        }
        return s.substring(start, end);
    }

    public static String longestPalinadrome2(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = check(s, i, i);
            int len2 = check(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start + 1){
                start = i - (len - 1) / 2 ;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    public static int check(String s, int left, int right) {
        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            } else {
                break;
            }
        }
        return right - left - 1;
    }

    public static void main(String[] args) {
        String s = "babad";
        System.out.println(longestPalinadrome2(s));
    }
}
