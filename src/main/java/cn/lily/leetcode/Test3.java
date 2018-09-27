package cn.lily.leetcode;

import java.util.LinkedList;
import java.util.List;

public class Test3 {
    public static int lengthOfLongestSubString(String s) {
        if (s == null || s.length() < 1) {
            return 0;
        }
        int start = 0;
        int end = 0;
        int max = Integer.MIN_VALUE;
        List<Character> list = new LinkedList<Character>();

        while (end < s.length()) {
            if (!list.contains(s.charAt(end))) {
                list.add(s.charAt(end));
                end++;
            } else {
                int diff = end - start;
                if (diff > max) {
                    max = diff;
                }
                start++;
                end = start;
                list.clear();
            }

        }
        if (end >= s.length()){
            int diff = end - start;
            if (diff > max) {
                max = diff;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String s = "dvdf";
        System.out.println(lengthOfLongestSubString(s));
    }
}
