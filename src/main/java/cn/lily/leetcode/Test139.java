package cn.lily.leetcode;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Test139 {
    public static List<String> wordBreak(String s, List<String> wordDict) {
        List<String> result = new LinkedList<String>();
        List<String> tmpStr = new LinkedList<String>();
        if (s == null || s.length() < 1 || wordDict.size() < 1) {
            return result;
        }
        int start = 0;
        int end = s.length();
        boolean[] dp = new boolean[s.length()];
        for (boolean b : dp) {
            b = false;
        }
        isContains(s.toLowerCase(), wordDict, start, end, dp, result, tmpStr);
        Collections.sort(tmpStr);
        return tmpStr;
    }

    public static void isContains(String s, List<String> wordDict, int start, int end, boolean[] dp, List<String> result, List<String> tmpStr) {
        if (start >= end) {
            return;
        }
        for (int i = end; i > start; i--) {
            String temp = s.substring(start, i);
            if (wordDict.contains(temp) && !dp[i - 1]) {
                result.add(temp);
                dp[i - 1] = true;
                isContains(s, wordDict, i, end, dp, result, tmpStr);
                if (!dp[s.length() - 1]) {
                    result.remove(result.size() - 1);
                    continue;
                } else {
                    if (i == end) {
                        String resultTmp = "";
                        Iterator<String> iterator = result.iterator();
                        while (iterator.hasNext()) {
                            resultTmp += iterator.next() + " ";
                        }
                        tmpStr.add(resultTmp.substring(0, resultTmp.length() - 1));

                    }

                }
                result.remove(result.size() - 1);
            }
        }
    }



    public static void main(String[] args) {
        String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
        String check00 = "aaaaaaaaaab";
        String tmp = "leetcode";
        String tmp2 = "catsanddog";
        String temp3 = "pineapplepenapple";
        String temp4 = "abcd";
        List<String> wordDict = new LinkedList<String>();
        wordDict.add("a");
        wordDict.add("abc");
        wordDict.add("b");
        wordDict.add("cd");
        /*wordDict.add("a");
        wordDict.add("aa");
        wordDict.add("aaa");
        wordDict.add("aaaa");
        wordDict.add("aaaaa");
        wordDict.add("aaaaaa");
        wordDict.add("aaaaaaa");
        wordDict.add("aaaaaaaa");
        wordDict.add("aaaaaaaaa");
        wordDict.add("aaaaaaaaaa");
        wordDict.add("aaaaaaaaaaa");
        wordDict.add("aaaaaaaaa");
        wordDict.add("aaaaaa");
        wordDict.add("aaaaaaaaa");*/
        /*wordDict.add("pine");
        wordDict.add("applepen");
        wordDict.add("pineapple");
        wordDict.add("leet");
        wordDict.add("code");
        wordDict.add("apple");
        wordDict.add("pen");
        wordDict.add("cats");
        wordDict.add("dog");
        wordDict.add("sand");
        wordDict.add("and");
        wordDict.add("cat");
        wordDict.add("b");*/
        System.out.println(wordBreak(temp4, wordDict));
    }

}
