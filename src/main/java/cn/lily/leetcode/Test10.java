package cn.lily.leetcode;

public class Test10 {
    public static boolean isMatch(String s, String p) {
        /*if (p == null || p.length() < 1) {
            return true;
        }*/
        if (p == null || s == null) {
            return false;
        }
        return matchCur(s, p, 0, 0);
    }

    public static boolean matchCur(String s, String p, int i, int j) {
        if (i >= s.length() && j >= p.length()) {
            return true;
        } else if (i < s.length() &&  j >= p.length()){
            return false;
        }
        if (j < p.length() - 1 && p.charAt(j + 1) == '*') {
            if (i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.'))
                return matchCur(s, p, i, j + 2) || matchCur(s, p, i + 1, j) || matchCur(s, p, i + 1, j + 2);
            return matchCur(s, p, i, j + 2);
        } else {
            if (i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.')) {
                return matchCur(s, p, i + 1, j + 1);
            }
            return false;
        }
    }

    public static void main(String[] args) {
        String s = "";
        String p = "c*c*";
        System.out.println(isMatch(s, p));
    }
}
