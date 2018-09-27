package cn.lily.Test9_16;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t  = scanner.nextInt();
        long[] nums = new long[t];
        for(int i = 0; i < t; i++){
            nums[i] = scanner.nextLong();
        }
        for (int i = 0; i < t; i++) {
            if (isHamo(nums[i]))
                System.out.println("Yes");
            else
                System.out.println("No");
        }
    }
    public static boolean isHamo(long n){
        int sum = 0;
        long nums = n;
        while (nums > 0){
            int digit = (int)nums % 10;
            nums = nums / 10;
            sum += digit;
        }
        if (n % sum == 0)
            return true;
        return false;
    }

}
