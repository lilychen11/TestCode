package cn.lily.leetcode;

import java.util.*;

public class Test49 {
    public static List<List<String>> lists = new LinkedList<>();

    public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length < 1) {
            return lists;
        }
        Map<String, Integer> map = new HashMap<>();
        int count = 0;
        for (String str : strs) {
            int index = -1;
            char[] temp = str.toCharArray();
            Arrays.sort(temp);
            String key = new String(temp);
            if (map.containsKey(key)) {
                index = map.get(key);
            } else {
                map.put(key, count);
                index = count;
                count++;
            }
            if (lists.size() <= index) {
                List<String> res = new LinkedList<>();
                res.add(str);
                lists.add(res);
            } else {
                List<String> res = lists.get(index);
                res.add(str);
            }
        }
        return lists;
    }
    public static List<List<String>> group(String[] strs) {
        if (strs == null ||strs.length == 0) {
            return new ArrayList<>();
        }
        Map<String, List> ans = new HashMap<>();
        for (String str: strs) {
            char[] ca = str.toCharArray();
            Arrays.sort(ca);
            String key = String.valueOf(ca);
            if (!ans.containsKey(key)){
                ans.put(key, new ArrayList<>());
            }
            ans.get(key).add(str);
        }
        return new ArrayList(ans.values());
    }

    public static void main(String[] args) {
        String strs[] = {"eat", "tea", "tan", "ate", "nat", "bat"};
        String tes[] = {};
        System.out.println(groupAnagrams(strs));
        System.out.println(group(tes));
    }
}
