package cn.lily.leetcode;

public class Test136 {
    public static int singleNumber(int[] nums){
        if (nums == null || nums.length < 1){
            return 0;
        }
        int count = 0;
        for (int temp : nums){
            count ^= temp;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] num = {1,3,5,7,1,2,3,5,7};
        System.out.println(singleNumber(num));
    }
}
