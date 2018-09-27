package cn.lily.Test9_16;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String S = scanner.nextLine();
        String P = scanner.nextLine();
        int res =lengthOfLongestSubstring(S,P);
        System.out.println(res * res);

    }

    public static int lengthOfLongestSubstring(String S, String P) {
        if (S == null || S.length() == 0) return 0;
        int start = 0, res = 0;
        while (start < S.length() - P.length() && start >= 0) {
            int len = 0;
            if (S.substring(start, start + P.length()).equals(P)) {
                len = P.length();
                start += P.length();
                while (start + P.length() <= S.length()  && S.substring(start, start + P.length()).equals(P)){
                    len += P.length();
                    start = start + P.length();
                }
                for (int i = start - 1; i > start - P.length() ; i--) {
                    if ( i + P.length() <= S.length() && S.substring(i, i + P.length()).equals(P)){
                        len +=P.length() - (start - i);
                        start = i + P.length();
                        break;
                    }
                }
                res = Math.max(res, len);
            }
            else
                start++;
        }
        return res;
    }
}
