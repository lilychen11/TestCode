package cn.lily.Test9_17;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main3 {
    private static List<String> list = new LinkedList<>();
    public static int cur  = 0;
    public static void Permutation(char[] chars, int begin, int tLength) {
        if (chars == null || chars.length < 1) {
            return;
        }
        if (tLength == begin) {
            for (int i = 1; i <= tLength; i++) {
                cur += Math.abs(chars[i] - chars[i - 1]);
            }
            cur %= (int) Math.pow(10,9) + 7;

            String temp = new String(chars);
            list.add(temp);
        } else {
            char tmp;
            for (int i = begin; i < chars.length; i++) {
                if (begin != i && chars[begin] == chars[i]) {
                    continue;
                } else {
                    char temp = chars[begin];
                    chars[begin] = chars[i];
                    chars[i] = temp;
                    Permutation(chars, begin + 1, tLength);
                    temp = chars[begin];
                    chars[begin] = chars[i];
                    chars[i] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        char[] nums = new char[n];
        for (int i = 0; i < n; i++) {
            nums[i] = (char)scanner.nextInt();
        }
        Permutation(nums,0, nums.length - 1);
        System.out.println(cur);
    }
}
