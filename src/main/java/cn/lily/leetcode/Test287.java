package cn.lily.leetcode;

public class Test287 {
    public static int findDuplicate(int[] nums){
        if (nums == null) {
            return 0;
        }
        int[] freq = new int[nums.length + 1];
        freq[0] = 1;
        for (int num :nums) {
            if (freq[num] == 1) {
                return num;
            } else {
                freq[num] = 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 4, 2, 2};
        System.out.println(findDuplicate(nums));
    }
}
