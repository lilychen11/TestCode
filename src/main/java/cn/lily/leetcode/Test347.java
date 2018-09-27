package cn.lily.leetcode;

import jdk.internal.util.xml.impl.Input;

import java.util.*;

public class Test347 {
    public static List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> list = new LinkedList<>();
        if (k < 1 || nums == null || nums.length < 1) {
            return list;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((p, q) -> q.getValue() - p.getValue());
        for (Map.Entry<Integer, Integer> keySet : map.entrySet()) {
            pq.offer(keySet);
        }
        while (k > 0) {
            list.add(pq.poll().getKey());
            k--;
        }
        return list;
    }

    public static List<Integer> topKFrequent1(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        TreeMap<Integer, List<Integer>> freqMap = new TreeMap<>();
        for (int num : map.keySet()
                ) {
            int freq = map.get(num);
            if (!freqMap.containsKey(freq)) {
                freqMap.put(freq, new LinkedList<>());
            }
            List<Integer> temp = freqMap.get(freq);
            temp.add(num);
        }
        List<Integer> res = new ArrayList<>();
        while (res.size() < k) {
            Map.Entry<Integer, List<Integer>> entry = freqMap.pollLastEntry();
            res.addAll(entry.getValue());
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        System.out.println(topKFrequent1(nums, k));
    }

}
