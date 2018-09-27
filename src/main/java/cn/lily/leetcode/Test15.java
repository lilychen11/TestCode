package cn.lily.leetcode;

import java.util.*;

public class Test15 {
    public static List<List<Integer>> lists = new ArrayList<>();

    /*public static List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return lists;
        }
        permute(nums, 0, 3, new ArrayList<>(), 0, 0, 0);
        return lists;
    }

    public static void permute(int[] nums, int cur, int target, List<Integer> list, int sum, int curSum, int startIdx) {

        if (cur == target && curSum == sum) {
            List<Integer> temp = new ArrayList<>(list);
            Collections.sort(temp);
            Iterator<List<Integer>> iterator = lists.iterator();
            while (iterator.hasNext()) {
                List<Integer> pastList = iterator.next();
                if (pastList.containsAll(temp) && temp.containsAll(pastList)){
                    return;
                }
            }
            lists.add(temp);
            return;
        }
        if (cur >= target) {
            return;
        }
        for (int i = startIdx; i < nums.length; i++) {
            curSum += nums[i];
            list.add(nums[i]);
            permute(nums, cur + 1, target, list, sum, curSum, i + 1);
            curSum -= nums[i];
            list.remove(list.size() - 1);
        }
    }*/
    public static List<List<Integer>> threeSum(int[] num) {
        if (num == null || num.length < 3) {
            return lists;
        }
        Arrays.sort(num);
        for (int i = 0; i < num.length; i++) {
            if (i == 0 || (i > 0 && num[i] != num[i - 1])) {
                int lo = i + 1, hi = num.length - 1, sum = 0 - num[i];
                while (lo < hi) {
                    if (num[lo] + num[hi] == sum) {
                        lists.add(Arrays.asList(num[i], num[lo], num[hi]));
                        while (lo < hi && num[lo] == num[lo + 1]) lo++;
                        while (lo < hi && num[hi] == num[hi - 1]) hi--;
                        lo++;
                        hi--;
                    } else if (num[lo] + num[hi] < sum) {
                        lo++;
                    } else {
                        hi--;
                    }
                }
            }
        }
        return lists;
    }

    public static void main(String[] args) {
        int[] nums = {-4, -2, 1, -5, -4, -4, 4, -2, 0, 4, 0, -2, 3, 1, -5, 0};
        System.out.println(threeSum(nums));
    }
}
