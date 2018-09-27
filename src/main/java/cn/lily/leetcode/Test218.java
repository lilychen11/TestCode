package cn.lily.leetcode;

import java.lang.reflect.Array;
import java.util.*;

public class Test218 {
    public static List<int[]> getSkyline (int[][] buildings) {
        List<int[]> list = new LinkedList<>();
        if (buildings == null || buildings.length < 1)
            return list;
        int[][] bound = new int[buildings.length * 2][3];
        for (int i = 0; i < buildings.length; i++) {
            bound[i * 2] = new int[]{buildings[i][0], buildings[i][2], 1};
            bound[i* 2 + 1] = new int[]{buildings[i][1], buildings[i][2], -1};
        }
        Arrays.sort(bound, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]){
                    return (o1[2] > 0 ? -o1[1] :o1[1]) - (o2[2] > 0 ? -o2[1] : o2[1]);
                }
                return o1[0] - o2[0];
            }
        });
        TreeMap<Integer, Integer> map = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        int max = 0;
        int prev = max;
        map.put(0,1);
        list.add(new int[]{0, 0});
        for (int i = 0; i < bound.length; i++) {
            int[] num = bound[i];
            if (num[2] == 1) {
                map.put(num[1], map.getOrDefault(num[1], 0) + 1);
            } else {
             map.put(num[1], map.get(num[1]) - 1);
             if (map.get(num[1]) == 0)
                 map.remove(num[1]);
            }
            max = map.firstKey();
            if (prev != max){
                list.add(new int[]{num[0], max});
                prev = max;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[][] buildings = {{2, 9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 20}, {19, 24, 8}};
        System.out.println(getSkyline(buildings));
    }
}
