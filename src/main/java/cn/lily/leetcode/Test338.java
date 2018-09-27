package cn.lily.leetcode;

public class Test338 {
    public static int[] countBits(int num) {
        if (num < 0) {
            return null;
        }
        int[] result = new int[num + 1];
        result[0] = 0;
        result[1] = 1;
        int base = 2;
        for (int i = 2; i <= num; i++) {
            if (i >= base){
                result[i] = 1;
                base = base << 1;
                continue;
            }
            result[i] = result[base >> 1] + result[i - (base >> 1)];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] result = countBits(16);
        for (int i : result) {
            System.out.print(i + " ");
        }

    }
}
