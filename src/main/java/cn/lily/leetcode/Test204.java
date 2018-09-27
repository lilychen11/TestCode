package cn.lily.leetcode;

import java.util.Arrays;

public class Test204 {
    public static int countPrime (int n) {
        if ( n <= 2) {
            return -1;
        }
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, 2, n, true);
        //isPrime[0] = isPrime[1] = false;
        for (int i = 2; i * i < n; i++) {
            if (!isPrime[i])
                continue;
            for (int j = i * i; j < n; j += i) {
                isPrime[j] = false;
            }
        }
        int count = 0;
        for (boolean b : isPrime)
            if (b)
                count++;
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countPrime(3));
    }

}
