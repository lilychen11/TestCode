package cn.lily.leetcode;

public class Test35 {
    public static int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0] >= target ? 0 : 1;
        }
        return BinarySearch(nums, target, 0, nums.length - 1);
    }

    public static int BinarySearch(int[] nums, int target, int start, int end) {
        if (start > end){
            return start;
        }
        if (start == end) {
            if (nums[start] >= target){
                return start;
            }
            return start + 1;
        }
        int middle = (start + end + 1) / 2;
        if (nums[middle] == target) {
            return middle;
        } else if (nums[middle] > target) {
            return BinarySearch(nums, target, start, middle - 1);
        } else {
            return BinarySearch(nums, target, middle + 1, end);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6, 7, 8, 9};
        int target = 10;
        System.out.println(searchInsert(nums, target));
    }
}
