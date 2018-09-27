package cn.lily.example;

import java.awt.dnd.DnDConstants;
import java.util.*;

public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String DNA = scanner.next();
        DNA = DNA.toUpperCase();
        /*int n = DNA.length() / 2;
        while (n >= 4) {
            List<String> res = findRepeatedDnaSequences(DNA, n);
            if (res.size() > 0) {
                System.out.println(res.get(0) + " " + res.get(0).length());
                break;
            }
            n--;
        }

        if (n < 4) System.out.println(" " + 0);*/
        System.out.println(findRepeatedDnaSequences(DNA));
    }

    public static List<String> findRepeatedDnaSequences(String s) {
        List<String> temp = new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        if(s.length() < 10)
            return temp;
        for(int i = 0; i < s.length() - 10; i++) {
            String str = s.substring(i, i + 10);
            if(!set.add(str))
                temp.add(str);
            else
                set.add(str);
        }
        return temp;
    }
    public static List<String> findRepeatedDnaSequences(String s, int length) {
        Set<String> result = new HashSet<>();
        Set<String> set = new HashSet<>();
        for (int i = 0; i + length - 1 < s.length(); i++) {
            if (result.size() > 0) {
                break;
            }
            if (!set.contains(s.substring(i, i + length)))
                set.add(s.substring(i, i + length));
            else result.add(s.substring(i, i + length));
        }
        return new ArrayList<>(result);
    }
   /*public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       String word = sc.nextLine();

       int n = word.length();
       int[][] dp = new int[n+1][n+1];

       for (int i = 1; i <= n; i++) {
           for (int j = 1; j <= n; j++) {
               if (word.charAt(i-1) == word.charAt(j-1) && i != j) {
                   dp[i][j] = 1 + dp[i-1][j-1];
               } else {
                   dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
               }
           }
       }
       String res = "";
       int i = n, j = n;
       while (i > 0 && j > 0) {
           if (dp[i][j] == dp[i-1][j-1] + 1) {
               res = res + word.charAt(i-1);
               i--;j--;
           } else if (dp[i][j] == dp[i-1][j]){
               i--;
           } else {
               j--;
           }
       }
       String ans = new StringBuilder(res).reverse().toString();
       System.out.println(ans + " " + dp[n][n]);
   }*/
}
