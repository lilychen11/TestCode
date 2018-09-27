package cn.lily.leetcode;

public class Test33 {
    public static int search(int[] nums, int target) {
        if (nums == null || nums.length < 1) {
            return -1;
        }
        int index1 = 0;
        int index2 = nums.length - 1;
        int indexMid = index1;
        while (nums[index1] >= nums[index2]) {
            if (nums[indexMid] == target) {
                return indexMid;
            }
            indexMid = (index1 + index2) >> 1;
            if (nums[indexMid] >= target && target >= nums[index1]) {
                index2 = indexMid;
            } else {
                index1 = indexMid;
            }
        }
        return -1;

    }

    public static int search1(int[] nums, int target) {
        if (nums == null || nums.length < 1) {
            return -1;
        }
        int index1 = 0;
        int index2 = nums.length - 1;
        int indexMid = index1;
        while (index1 <= index2) {
            indexMid = (index1 + index2) >> 1;
            if (nums[indexMid] == target) {
                return indexMid;
            }
            if (nums[index1] <= nums[indexMid]) {
                if (nums[indexMid] > target && nums[index1] <= target) {
                    index2 = indexMid - 1;
                } else {
                    index1 = indexMid + 1;
                }
            }
            if (nums[indexMid] <= nums[index2]) {
                if (target > nums[indexMid] && target < nums[index2]) {
                    index1 = indexMid + 1;
                } else {
                    index2 = indexMid - 1;
                }
            }
        }
        return -1;

    }

    public static int searchRotate(int[] nums) {
        if (nums == null || nums.length < 1) {
            return -1;
        }
        int index1 = 0, index2 = nums.length - 1;
        int indexMid = index1;
        while (nums[index1] >= nums[index2]) {
            if (index2 - index1 == 1) {
                return nums[index2];
            }
            indexMid = (index1 + index2) >> 1;
            if (nums[index1] == nums[index2] && nums[indexMid] == nums[index1]) {
                return MinInorder(nums);
            }
            if (nums[indexMid] >= nums[index1]) {
                index1 = indexMid;
            } else if (nums[indexMid] <= nums[index2]) {
                index2 = indexMid;
            }
        }
        return nums[indexMid];
    }

    public static int MinInorder(int[] nums) {
        int min = Integer.MAX_VALUE;
        int index = -1;
        for (int i = 0; i < nums.length; i++) {
            if (min > nums[i]) {
                min = nums[i];
                index = i;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        System.out.println(search1(nums, target));
        // System.out.println(findMin(nums));

        int nums1[] = {12, 13, 14, 12, 12};
        System.out.println(searchRotate(nums1));
    }
}
