package cn.lily.leetcode;

public class Test134 {
    public static int canComplete(int[] gas, int[] cost) {
        int[] surplus = new int[gas.length];
        for (int i = 0; i < gas.length; i++) {
            surplus[i] = gas[i] - cost[i];
        }
        for (int i = 0; i < gas.length; i++) {
            if (surplus[i] >= 0) {
                if (check(surplus, i))
                    return i;
            }
        }
        return -1;
    }

    public static boolean check(int[] surplus, int idx) {
        int count = 0;
        int n = surplus.length;
        int cur = 0;
        while (count < surplus.length) {
            cur += surplus[(idx + count++) % n];
            if (cur < 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};
        int[] gas1 = {2, 3, 4};
        int[] cost1 = {3, 4, 3};
        System.out.println(canComplete(gas1, cost1));
    }
}
