package cn.lily.leetcode;

import java.util.LinkedList;
import java.util.List;

public class Test {
    public static int cal(int n) {
        List<Integer> list = new LinkedList<>();
        list.add(1);
        //int add = 0;
        int idx = 0;
        for (int i = 1; i <= n; i++) {
            idx = 0;
            int add = 0;
            while (idx < list.size()) {
                int temp = list.remove(idx);
                temp *= i;
                temp += add;
                list.add(idx++, temp % 10);
                add = temp / 10;
            }
            if (add > 0)
                list.add(list.size(), add);
        }
        int res = 0;
        for (int i : list) {
            res += i;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(cal(7));
    }
}
