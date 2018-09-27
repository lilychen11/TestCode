package cn.lily.leetcode;

import java.util.Arrays;

public class Test38 {
    public static String countAndSay(int n) {
        if (n < 1) {
            return "";
        }
        String[] str = new String[n + 1];
        Arrays.fill(str, "");
        str[1] = "1";
        for (int i = 2; i <= n; i++) {
            String cur = str[i - 1];
            char letter = cur.charAt(0);
            int count = 0;
            for (int j = 0; j < cur.length(); j++) {
                if (cur.charAt(j) == letter)
                    count++;
                else {
                    str[i] += count + "" + letter;
                    letter = cur.charAt(j);
                    count = 1;
                }
            }
            str[i] += count + "" + letter;
        }
        return str[n];
    }

    public static void main(String[] args) {
        System.out.println(countAndSay(4));
    }
}
