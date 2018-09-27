package cn.lily.leetcode;

public class Test34 {
    public static int[] result = {-1, -1};

    public static int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length < 1) {
            return result;
        }
        result[0] = findFirst(nums, target);
        result[1] = findLast(nums, target);

        return result;
    }

    public static int findFirst(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int middle = 0;
        while (low < high) {
            middle = (low + high + 1) >> 1;
            if (nums[middle] == target && nums[middle - 1] < target) {
                return middle;
            } else if (nums[middle] == target && nums[middle - 1] == target) {
                high = middle - 1;
            } else if (nums[middle] > target) {
                high = middle - 1;
            } else {
                low = middle + 1;
            }
        }
        middle = (low + high) / 2;
        if (nums[middle] == target) {
            return middle;
        } else {
            return -1;
        }
    }

    public static int findLast(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int middle = 0;
        while (low < high) {
            middle = (low + high - 1) >> 1;
            if (nums[middle] == target && nums[middle + 1] > target) {
                return middle;
            } else if (nums[middle] == target && nums[middle + 1] == target) {
                low = middle + 1;
            } else if (nums[middle] > target) {
                high = middle - 1;
            } else {
                low = middle + 1;
            }
        }
        middle = (low + high) / 2;
        if (nums[middle] == target) {
            return middle;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 2};
        int target = 2;
        System.out.println(searchRange(nums, target));
    }
}
