package cn.lily.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Test315 {
    public static List<Integer> countSmaller(int[] nums) {
        List<Integer> list = new LinkedList<>();
        if (nums == null || nums.length < 2) {
            return list;
        }
        int[][] nArray = new int[nums.length][2];
        int[] array = new int[nums.length];
        for (int i = 0;i < nums.length; i++){
            nArray[i][0] = nums[i];
            nArray[i][1] = i;
        }
        merge(nArray, 0, nArray.length - 1, array);
        for (int num : array)
            list.add(num);
        return list;
    }
    public static void merge(int[][] nums, int start, int end, int[] array) {
        if (start >= end) {
            return;
        }
        int middle = (start + end) / 2;
        merge(nums, start, middle, array);
        merge(nums, middle + 1, end, array);
        int i = start;
        int j = middle + 1;
        int[][] numsNew = new int[end - start + 1][2];
        int p = 0;
        while (i < middle + 1 && j <= end){
            if (nums[i][0] > nums[j][0]){
                for (int k = i; k < middle + 1 ; k++) {
                    array[nums[k][1]]++;
                }
                numsNew[p++] = nums[j++];
            }else {
                numsNew[p++] = nums[i++];
            }
        }
        while (i < middle + 1){
            numsNew[p++] = nums[i++];
        }
        while (j < end + 1){
            numsNew[p++] = nums[j++];
        }
        System.arraycopy(numsNew, 0, nums, start, end - start + 1);
        /*for (int k = start; k <= end; k++) {
            nums[k] = numsNew[k - start];
        }*/
    }

    public static void main(String[] args) {
        int[] array = {5, 2,  6, 1};
        System.out.println(countSmaller(array));

    }
}
