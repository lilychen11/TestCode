package cn.lily.leetcode;

public class Test75 {
    public static void sortColors(int[] nums) {
        if (nums == null || nums.length < 1) {
            return;
        }
        int index0 = 0, index2 = nums.length - 1;
        for (int i = 0; i <= index2; i++) {
            if (nums[i] == 0){
                swap(nums,index0++, i);
            } else if (nums[i] == 2) {
                swap(nums, i--, index2--);
            }
        }
    }
    public static void swap(int[] nums, int index1, int index2) {
        if (index1 == index2) {
            return;
        } else {
            int temp = nums[index1];
            nums[index1] = nums[index2];
            nums[index2] = temp;
        }
    }

    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0};
        sortColors(nums);
        System.out.println(nums);
    }
}
