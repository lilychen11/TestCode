package cn.lily.leetcode;

import java.util.*;

public class Test140 {
    public static List<String> wordBreak(String s, List<String > wordDict){
        Map<Integer, List<String>> dp = new HashMap<Integer, List<String>>();
        return DFS(s, 0, wordDict, dp);
    }
    public  static List<String> DFS(String s, int index, List<String> wordDict, Map<Integer, List<String>> dp) {
        if (dp.get(index) != null){
            return dp.get(index);
        }
        if (index == s.length()){
            List l = new ArrayList<String>();
            l.add("");
            dp.put(index, l);
            return  dp.get(index);
        }
        List<String> list = new ArrayList<String>();
        for (int i = index + 1; i <= s.length(); i ++){
            String leftS = s.substring(index, i);
            if (wordDict.contains(leftS)) {
                for (String str : DFS(s, i, wordDict, dp)) {
                    list.add(leftS + ((str.length() > 0) ? " " : "") + str);
                }
            }
        }
        dp.put(index, list);
        return dp.get(index);
    }
    public static List<String> wordBreak1(String s, List<String> wordDict) {
        return backtrack(s,wordDict,new HashMap<String, List<String>>());
    }
    // backtrack returns an array including all substrings derived from s.
    public static List<String> backtrack(String s, List<String> wordDict, Map<String,List<String>> mem){
        if(mem.containsKey(s)) return mem.get(s);
        List<String> result = new ArrayList<String>();
        for(String word: wordDict)
            if(s.startsWith(word)) {
                String next = s.substring(word.length());
                if(next.length()==0) result.add(word);
                else for(String sub: backtrack(next, wordDict, mem)) result.add(word+" "+sub);
            }
        mem.put(s, result);
        return result;
    }
    public static List<String> wordBreak3(String s, List<String > wordDict){
        Map<Integer, List<String>> map = new HashMap<Integer, List<String>>();
        return helper(s, wordDict, map, 0);
    }

    public static List<String> helper(String s, List<String> wordDict, Map<Integer, List<String>> map, int cur) {
        if(map.containsKey(cur)) return map.get(cur);
        List<String> list = new ArrayList<String>();
        if(cur == s.length()) {
            list.add("");
            return list;
        }
        for(String word : wordDict) {
            if(s.startsWith(word, cur)) {
                List<String> next = helper(s, wordDict, map, cur+word.length());
                for(String n : next) list.add(word+(n.length() == 0 ? "":" ")+n);
            }
        }
        map.put(cur, list);
        return list;
    }
    public static void main(String[] args) {
        String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
        String s1 = s.substring(0,s.length() - 1);
        String check00 = "aaaaaaaaaab";
        String tmp = "leetcode";
        String tmp2 = "catsanddog";
        String tmp3 = "pineapplepenapple";
        String tmp4 = "abcd";
        List<String> wordDict = new LinkedList<String>();
        wordDict.add("a");
        wordDict.add("abc");
        wordDict.add("b");
        wordDict.add("cd");
        wordDict.add("a");
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
        wordDict.add("aaaaaaaaa");
        wordDict.add("pine");
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
        wordDict.add("b");
        System.out.println(wordBreak3(tmp3, wordDict));
    }
}
