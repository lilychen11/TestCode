package cn.lily.leetcode;

public class Test31 {
    public static void nextPermutation(int[] nums) {
        if (nums == null || nums.length < 1) {
            return;
        }
        int i = nums.length - 1;
        while (i > 0) {
            if (nums[i] <= nums[i - 1]) {
                i--;
            } else {
                break;
            }
        }
        if (i > 0) {
            int j = nums.length - 1;
            while (nums[j] <= nums[i - 1]){
                j--;
            }
            int temp = nums[j];
            nums[j] = nums[i - 1];
            nums[i - 1] = temp;

        }
        swap(nums, i, nums.length - 1);

    }
    public static void swap(int[] nums, int start, int end) {
        while (start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 1};
        nextPermutation(nums);
        for (int num: nums
             ) {
            System.out.print(num + " ");
        }
    }
}
