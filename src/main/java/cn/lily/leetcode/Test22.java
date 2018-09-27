package cn.lily.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Test22 {
    public static List<String> list = new LinkedList<>();
    public static List<String> generateParenthesis(int n) {
        cur(n, 0, 0, "");
        return list;
    }
    public static void cur(int n, int open, int close, String temp){
        if (n * 2 == temp.length()) {
            list.add(temp);
            return;
        }
        if (open < n){
            cur(n, open + 1, close, temp + "(");
        }
        if (close < open) {
            cur(n, open, close + 1, temp + ")");
        }
    }
    public static List<String> generateParenthesis1(int n) {
        List<String> ans = new ArrayList<>();
        if (n == 0) {
            ans.add("");
        } else {
            for (int c = 0; c < n; c++) {
                for (String left : generateParenthesis1(c))
                    for (String right : generateParenthesis1(n - 1 - c))
                        ans.add("(" + left + ")" + right);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis1(3));
    }
}
