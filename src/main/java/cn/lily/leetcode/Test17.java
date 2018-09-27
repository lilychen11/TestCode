package cn.lily.leetcode;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Test17 {
    public static String[] maps = {"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public static List<String > list = new LinkedList<>();
    public static List<String> letterCombination(String digits){
        if (digits == null || digits.length() < 1){
            return list;
        }
        combin(digits, 0, digits.length(), new LinkedList<>());
        Collections.sort(list);
        return list;
    }
    public static void combin(String digits, int index, int length, List<Character> temp) {
        if (index >= length) {
            StringBuffer str = new StringBuffer();
            Iterator<Character> iterator = temp.listIterator();
            while (iterator.hasNext()) {
                str.append(iterator.next());
            }
            list.add(new String(str));
            return;
        }
        int cur = Integer.parseInt(digits.charAt(index) + "");
        if (cur > 1 && cur < 10) {
            String nowMap = maps[cur - 2];
            for (int i = 0; i < nowMap.length(); i++) {
                temp.add((char)nowMap.charAt(i));
                combin(digits, index + 1, length, temp);
                temp.remove(temp.size() - 1);
            }
        } else {
            throw new IllegalArgumentException("Illegal input");
        }
    }

    public static void main(String[] args) {
        String temp = "999";
        System.out.println(letterCombination(temp));
    }
}
