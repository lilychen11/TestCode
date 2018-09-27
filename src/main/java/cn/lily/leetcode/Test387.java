package cn.lily.leetcode;

import java.util.*;

public class Test387 {
    public static int firstUniqChar(String s) {
        if (s == null || s.length() < 1) {
            return -1;
        }
        HashMap<Character, int[]> map = new HashMap<>();
        int i = 0;
        while (i < s.length()){
            if (map.containsKey(s.charAt(i))){
                int[] temp = map.get(s.charAt(i));
                temp[1]++;
                map.put(s.charAt(i++),temp);
            } else {
                map.put(s.charAt(i),new int[]{i++,1});
            }
        }
        Iterator<Map.Entry<Character,int[]>> iter = map.entrySet().iterator();
        int idx = s.length();
        while (iter.hasNext()) {
            int[] res = iter.next().getValue();
            if (res[1] == 1){
                if (idx > res[0])
                    idx = res[0];
            }
        }
        return idx;
    }

    public static void main(String[] args) {
        String str = "leetcode";
        System.out.println(firstUniqChar(str));
    }
}
