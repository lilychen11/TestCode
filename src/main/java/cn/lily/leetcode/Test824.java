package cn.lily.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test824 {
    public static String toGoatLatin(String S) {
        if (S == null || S.length() < 1) {
            return S;
        }
        StringBuffer res = new StringBuffer();
        List<Character> vowel = Arrays.asList('a', 'e', 'i', 'o', 'u');
        String[] words = S.split(" ");
        StringBuffer fix = new StringBuffer("ma");
        for (String word : words) {
            char first = word.charAt(0);
            StringBuffer buffer = new StringBuffer();
            if (!vowel.contains(first)) {
                buffer.append(word.substring(1 ));
                buffer.append(word.charAt(0));
            } else {
                buffer.append(word);
            }
            fix.append('a');
            buffer.append(fix);
            res.append(buffer).append(" ");
        }
        return new String(res).trim();
    }

    public static void main(String[] args) {
        String S = "The quick brown fox jumped over the lazy dog";
        System.out.println(toGoatLatin(S));
    }
}
