package cn.lily.leetcode;

import java.util.Stack;

public class Test581 {
    public static int findUnsortedSubarray(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        int start = 0;
        int end = nums.length - 1;
        boolean flagS = false;
        boolean flagE = false;
        while (start < end && nums[start] <= nums[end]) {
            if (nums[start] <= nums[start + 1]) {
                start++;
            } else {
                flagS = true;
            }
            if (nums[start] > nums[end]) {
                return end - start + 1;
            }
            if (nums[end] >= nums[end - 1]) {
                end--;
            } else {
                flagE = true;
            }
            if (nums[start] > nums[end]) {
                return end - start + 1;
            }
            if (start == end) {
                return 0;
            }
            if (flagE && flagS) {
                return end - start + 1;
            }

        }
        if (start == end) {
            return 0;
        }

        return end - start + 1;
    }

    public static int find(int[] nums) {
        Stack<Integer> stack = new Stack<Integer>();
        int l = nums.length, r = 0;
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
                l = Math.min(l, stack.pop());
            }
            stack.push(i);
        }
        stack.clear();
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                r = Math.max(r, stack.pop());
            }
            stack.push(i);
        }
        return r - l > 0 ? r - l + 1 : 0;
    }
    public static int find2(int[] nums){
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        boolean flag = false;
        for (int i = 1; i < nums.length; i++){
            if (nums[i] < nums[i - 1]){
                flag = true;
            }
            if (flag){
                min = Math.min(min, nums[i]);
            }
        }
        flag = false;
        for (int i = nums.length - 2; i >= 0 ; i--) {
            if (nums[i] > nums[i + 1]){
                flag = true;
            }
            if (flag){
                max = Math.max(max, nums[i]);
            }
        }
        int l, r;
        for (l = 0; l < nums.length; l++) {
            if (nums[l] > min){
                break;
            }
        }
        for (r = nums.length - 1; r >= 0; r--) {
            if (nums[r] < max){
                break;
            }
        }
        return r - l > 0 ? r - l + 1 : 0;
    }

    public static void main(String[] args) {
        //int[] nums = {2, 6, 4, 8, 10, 9, 15};
        // int[] nums = {1, 3, 2, 2, 2};
        int[] nums = {2, 1};
        int[] nums2 = {1};
        int[] nums3 = {1, 2, 5, 3, 4};
        System.out.println(find2(nums3));
    }
}
