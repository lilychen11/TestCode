package cn.lily.leetcode;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;

public class Test560 {
    public static int subarraySumW(int[] nums, int k) {
        Arrays.sort(nums);
        int first = 0, last = first;
        int target = nums[first];
        int count = 0;
        while (first < nums.length && last < nums.length) {
            if (target < k) {
                if (last < nums.length - 1) {
                    last++;
                    target += nums[last];
                } else {
                    break;
                }

            }
            if (target >= k) {
                if (target == k) {
                    count++;
                }
                target -= nums[first];
                first++;
                if (first < nums.length) {
                    if (first > last) {
                        target = nums[first];
                        last = first;
                    }
                } else {
                    break;
                }

            }

        }
        return count;

    }

    public static int subarraySum(int[] nums, int k) {
        int count = 0;
        int[] sum = new int[nums.length + 1];
        sum[0] = 0;
        for (int i = 1; i < nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        for (int start = 0; start < nums.length; start++) {
            for (int end = start + 1; end < nums.length; end++) {
                if (sum[end] - sum[start] == k) {
                    count++;
                }
            }
        }
        return count;
    }

    public static int subarraySum1(int[] nums, int k) {
        int count = 0;
        for (int start = 0; start < nums.length; start++) {
            int sum = 0;
            for (int end = start ; end < nums.length; end++) {
                sum += nums[end];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }

    public static int subarraySum2(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, 1);
        int count = 0, sum = 0;
        for (int i = 0; i < nums.length; i++) {
             sum += nums[i];
             if (map.containsKey(k - sum)){
                 count += map.get(k - sum);
             }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {

       // int[] nums = {1, 2, 1, 2, 1};
        int[] nums = {1, 2, 3};
        int k = 3;
        System.out.println(subarraySum1(nums, k));
        //System.out.println(subarraySumW(nums, k));
    }
}
