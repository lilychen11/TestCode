package cn.lily.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Test46 {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        List<Integer> temp = new LinkedList<>();
        List<Integer> surplus = new LinkedList<>();
        for (int num: nums) {
            surplus.add(num);
        }
        for (int i = 0; i <= nums.length; i++) {
            comBination(surplus, result, temp, i);
        }
        return result;
    }
    public static void permuteCur(List<Integer> surplus, List<List<Integer>> result, List<Integer> temp, int targetLength) {
        if (temp.size() == targetLength) {
            List<Integer> one = new LinkedList<>();
            one.addAll(temp);
            result.add(one);
            return;
        }
        for (int i = 0; i < surplus.size(); i++){
            temp.add(surplus.remove(i));
            permuteCur(surplus, result, temp,targetLength);
            surplus.add(i,temp.remove(temp.size() - 1));
        }
    }
    public static void comBination(List<Integer> surplus, List<List<Integer>> result, List<Integer> temp, int targetLenght){
        if (temp.size() == targetLenght){
            List<Integer> tempres = new LinkedList<>();
            tempres.addAll(temp);
            result.add(tempres);
            return;
        }
        for (int i = 0; i < surplus.size(); i++) {
            temp.add(surplus.remove(i));
            List<Integer> next = new LinkedList<>();
            for (int j = i; j < surplus.size(); j++){
                next.add(surplus.get(j));
            }
            comBination(next,result,temp, targetLenght);
            surplus.add(i,temp.remove(temp.size() - 1));
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(permute(nums));
    }
}
