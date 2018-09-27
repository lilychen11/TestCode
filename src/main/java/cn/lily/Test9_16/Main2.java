package cn.lily.Test9_16;

import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n  = scanner.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n; i++){
            nums[i] = scanner.nextInt();
        }
        System.out.println(findWays(nums));

    }
    public static int findWays(int[] nums){
       int result = 1;
       int sign = 0;
       int zeroNum = 0;
       int oneNum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1)
                oneNum++;
        }
        if (oneNum == 0)
            return 0;
        int i = 0, j = 0;
        for ( i = 0, j = 0; i < nums.length && j < oneNum; i++) {
            while (nums[i]==0) {
                if (sign != 0)
                    ++zeroNum;
                i++;
            }
            sign = 1;
            result *= (zeroNum + 1);
            zeroNum = 0;
            j++;
        }
        return result;
    }
}
