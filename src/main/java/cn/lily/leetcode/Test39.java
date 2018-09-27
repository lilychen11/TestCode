package cn.lily.leetcode;

import java.util.*;

public class Test39 {
    public static List<List<Integer>> lists = new LinkedList<>();
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {

        if (candidates.length < 1) {
            return lists;
        }
        Arrays.sort(candidates);
        List<Integer> realCan = new LinkedList<>();
        for (int candidate: candidates) {
            if (candidate <= target){
                realCan.add(candidate);
            }
        }
        Integer[] can = new Integer[realCan.size()] ;
        realCan.toArray(can);
        combination(can, target, 0, new ArrayList<Integer>());
        return lists;
    }
    public static void combination(Integer[] candidates, int target, int index, List<Integer> list){
        if (target <= 0){
            if (target == 0){
                lists.add(new ArrayList<>(list));
            }
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            list.add(candidates[i]);
            combination(candidates, target - candidates[i], i, list);
            list.remove(candidates[i]);
        }
    }
    public static List<List<Integer>> combinationSum1(int[] candidates, int target) {
        if (candidates == null || candidates.length < 1) {
            return lists;
        }
        combination1(candidates, target, 0, new ArrayList<Integer>());
        return lists;
    }
    public static void combination1(int[] candidates, int target, int index, List<Integer> list) {
        if (target <= 0) {
            if (target == 0) {
                lists.add(new ArrayList<>(list));
            }
            return;
        }
        for(int i = index; i < candidates.length; i++) {
            if (target - candidates[i] < 0){
                break;
            }
            list.add(candidates[i]);
            combination1(candidates, target - candidates[i], i, list);
            list.remove((Object)candidates[i]);
        }
    }

    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
       // System.out.println(combinationSum(candidates, target));
        System.out.print(combinationSum1(candidates, target));
    }
}
