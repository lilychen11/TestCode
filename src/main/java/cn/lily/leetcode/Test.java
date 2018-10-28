package cn.lily.leetcode;

import java.util.*;

public class Test {
    public static int cal(int n) {
        List<Integer> list = new LinkedList<>();
        list.add(1);
        //int add = 0;
        int idx = 0;
        for (int i = 1; i <= n; i++) {
            idx = 0;
            int add = 0;
            while (idx < list.size()) {
                int temp = list.remove(idx);
                temp *= i;
                temp += add;
                list.add(idx++, temp % 10);
                add = temp / 10;
            }
            if (add > 0)
                list.add(list.size(), add);
        }
        int res = 0;
        for (int i : list) {
            res += i;
        }
        return res;
    }

    public static int longestSubstring(String s, int k) {
        int[] map = new int[26];
        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i) - 'a']++;
        }
        int length = 0;
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < map.length; i++) {
            if (map[i] > 0 && map[i] < k)
                set.add((char)('a' + i));
        }
        int start = 0;
        int end = start;
        while (end < s.length()){
            if (!set.contains(s.charAt(end))){
                end++;
            } else {
                length = Math.max(length, end - start);
                start = end + 1;
                end = start;
            }
            if (end == s.length()){
                length = Math.max(length,end - start);
            }
        }
        return length;
    }

    public static int longestSubstring2(String s, int k) {
        char[] str = s.toCharArray();
        return helper(str, 0, s.length(), k);
    }

    private static int helper(char[] str, int start, int end, int k) {
        if (end - start < k) return 0;//substring length shorter than k.
        int[] count = new int[26];
        for (int i = start; i < end; i++) {
            int idx = str[i] - 'a';
            count[idx]++;
        }
        for (int i = 0; i < 26; i++) {
            if (count[i] < k && count[i] > 0) { //count[i]=0 => i+'a' does not exist in the string, skip it.
                for (int j = start; j < end; j++) {
                    if (str[j] == i + 'a') {
                        int left = helper(str, start, j, k);
                        int right = helper(str, j + 1, end, k);
                        return Math.max(left, right);
                    }
                }
            }
        }
        return end - start;
    }

    public static void main(String[] args) {
        String s = "cccddd";
        int k = 3;
        //System.out.println(longestSubstring(s,k));

        System.out.println(longestSubstring(s, k));

    }
}
