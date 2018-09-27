package cn.lily.leetcode;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Test202 {
    public static boolean isHappy(int n) {
        int x = n;
        int y = n;
        while (x > 1) {
            x = cal(x);
            if(x == 1) return true;
            y = cal(cal(y));
            if (y == 1) return true;
            if (x == y) return false;
        }
        return true;
    }
    public static int cal(int n) {
        int res = 0;
        int temp = 0;
        while (n > 0) {
            temp = n % 10;
            res += temp*temp;
            n = n / 10;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(isHappy(111));
    }
}
