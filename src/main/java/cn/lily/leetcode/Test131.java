package cn.lily.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Test131 {
    List<List<String>> resultList;
    ArrayList<String> curList;
    public List<List<String>> partition(String s){
        resultList = new ArrayList<List<String>>();
        curList = new ArrayList<String>();
        backTrack(s, 0);
        return resultList;
    }
    public void backTrack(String s, int l){
        if (curList.size() > 0 && l >= s.length()){
            List<String> r = (ArrayList<String>)curList.clone();

            resultList.add(r);
        }
        for (int i = l; i < s.length(); i++) {
            if (isPalidrom(s,l, i)){
                if (l == i){
                    curList.add(s.charAt(i) + "");
                } else {
                    curList.add(s.substring(l, i + 1));
                }
                backTrack(s, i + 1);
                curList.remove(curList.size() - 1);
            }
        }
    }
    public boolean isPalidrom(String s, int l, int r){
        if (l == r)
            return true;
        while (l < r){
            if(s.charAt(l) != s.charAt(r))
                return false;
            l++;
            r--;
        }
        return true;
    }
}
