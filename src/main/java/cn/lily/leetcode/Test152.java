package cn.lily.leetcode;

public class Test152 {
    public static int maxProduct(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        int[] pos = new int[nums.length];
        pos[0] = nums[0];
        int first = nums[0] < 0 ? 0 : - 1;
        int max = pos[0];
        for (int i = 1; i < nums.length; i++) {
            pos[i] = Math.max(nums[i], pos[i - 1] * nums[i]);
            if (nums[i] < 0 && first < 0) {
                first = i;
            } else if (nums[i] < 0 && first >= 0) {
                int last = i;
                int product = 1;
                if (first > 0 && pos[first - 1] > 0) {
                        product = pos[first - 1];
                }
                for (int j = first; j <= last; j++) {
                    product *= nums[j];
                }
                first = last;
                pos[i] = Math.max(product, pos[i]);
            }
            max = Math.max(max, pos[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {2, -5, -2, -4, 3};
        System.out.println(maxProduct(nums));
    }
}
