package cn.lily.leetcode;

public class Test647 {
    public static int countSubString(String s){
        if (s == null || s.length() < 1){
            return 0;
        }
        int count = 0;
        for (int i = 0; i < s.length(); i++){
            count += mirrorOnLetter(s, i);
            count += mirrorBetLetter(s, i + 1);
        }
        return count;
    }
    public static int mirrorOnLetter(String s, int index){
        int count = 0;
         for (int i = index; i >= 0 && 2 * index - i < s.length() && s.charAt(i) == s.charAt(2 * index - i); i--){
             System.out.println(s.substring(i, 2 * index - i + 1) + " ");
            count++;
        }
        System.out.println();
        return count;
    }
    public static int mirrorBetLetter(String s, int index){
        int count = 0;
        for (int i = index; i > 0 && i > 2 * index - s.length() && s.charAt(i - 1) == s.charAt(2 * index - i); i--){
            System.out.println(s.substring(i - 1, 2 * index - i + 1) + " ");
            count++;
        }
        return count;

    }

    public static void main(String[] args) {
        String temp = "aaa";
        System.out.println(countSubString(temp));
    }
}
