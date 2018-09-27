package cn.lily.leetcode;

public class Test55 {
    public static boolean canJump(int[] nums) {
        if (nums == null || nums.length < 1) {
            return false;
        }
        boolean[] pos = new boolean[nums.length];
        pos[0] = true;
        for (int i = 0; i < nums.length; i++) {
            int posStep = nums[i];
            if (pos[i]) {
                int j = i + 1;
                while (posStep > 0 && j < pos.length) {
                    if (!pos[j]) {
                        pos[j] =true;
                    }
                    j++;
                    posStep--;
                }
            }
        }
        return pos[pos.length - 1];
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        int[] nums1= {3, 2, 1, 0, 4};
        System.out.println(canJump(nums1));
    }

}
