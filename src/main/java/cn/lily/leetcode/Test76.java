package cn.lily.leetcode;

import java.util.Vector;

public class Test76 {
    public static String lengthofLongestSubstring(String s, String t) {
        int[] map = new int[128];
        for (int i = 0; i < t.length(); i++)
            map[t.charAt(i)]++;
        int counter = t.length(), begin = 0, end = 0, d = Integer.MAX_VALUE, head = 0;
        while (end < s.length()) {
            if (map[s.charAt(end++)]-- > 0) {
                counter--;
            }
            while (counter == 0) {
                if (end - begin < d) {
                    head = begin;
                    d = end - head;
                }
                if (map[s.charAt(begin++)]++ == 0){
                    counter++;
                }
            }
        }
        return d == Integer.MAX_VALUE ? "null" : s.substring(head, head + d);
    }
    public static int lengthOfLongestSubstringTwoDistinct (String s) {
        Vector<Integer> map = new Vector<>(128);
        int counter = 0;
        return 0;
    }

    public static void main(String[] args) {
        String S = "ADOBECODEBANC", T = "ABC";
        System.out.println(lengthofLongestSubstring(S, T));
    }
}
