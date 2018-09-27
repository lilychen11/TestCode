package cn.lily.leetcode;

import java.util.PriorityQueue;

public class Test215 {
    public static int findKthLargest(int[] nums, int k){
        if (nums == null || nums.length < 1){
            return 0;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(/*(p,q)-> (p - q)*/);
        for (int num : nums) {
            if (pq.size() < k){
                pq.offer(num);
            } else {
                if (num > pq.peek()) {
                    pq.poll();
                    pq.offer(num);
                }
            }
        }
        return pq.poll();
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        int k = 2;
        int[] nums1 = {3,2,3,1,2,4,5,5,6};
        int k0 = 4;
        System.out.println(findKthLargest(nums1, k0));
    }
}
