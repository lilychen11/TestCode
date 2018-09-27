package cn.lily.leetcode;

public class Test76_2 {
    public static String minWindow(String s, String t) {
        int[] map = new int[128];
        for (int i = 0; i < t.length(); i++) map[t.charAt(i)] += 1;
        int counter = t.length();
        int begin = 0, end = 0, d = Integer.MAX_VALUE, head = 0;
        while (end < s.length()) {
            if (map[s.charAt(end++)]-- > 0) counter--;
            while (counter == 0) {
                if (end - begin < d) d = end - (head = begin);
                if (map[s.charAt(begin++)]++ == 0) counter++;
            }
        }
        return d == Integer.MAX_VALUE ? "" : s.substring(head, head + d);
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindow(s, t));
    }
}
