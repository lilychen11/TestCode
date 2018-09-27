package cn.lily.leetcode;

public class Test91 {
    public static int numDecodings(String s) {
        if(s == null || s.length() < 1 || s.charAt(0) == '0'){
            return 0;
        }
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = 1;
        if ( 1 >= s.length())
            return dp[1];
        for (int i = 2; i <= s.length(); i++) {
            int temp = Integer.parseInt(s.substring(i - 2, i));
            if (temp == 0 ||(temp > 27 && s.charAt(i - 1) == '0'))
                return 0;
            if (temp >= 27 && s.charAt(i - 1) != '0')
                dp[i] = dp[i - 1];
            else if (temp > 0 && temp < 27 && s.charAt(i - 1) != '0' && s.charAt(i - 2) != '0')
                dp[i] = dp[i - 2] + dp[i - 1];
            else
                dp[i] = dp[i - 2];
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        String s = "110";
        System.out.println(numDecodings(s));
    }

}
