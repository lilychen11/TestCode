package cn.lily.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

public class Test406 {
    public static int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (p1,p2) -> p1[0] == p2[0] ? p1[1] - p2[1] : p2[0] -p1[0]);
        List<int[]> result = new LinkedList<>();
        Stream<int[]> temp = Arrays.stream(people);
        System.out.print(temp);
        temp.forEach(p -> result.add(p[1],p));
       // Arrays.stream(people).forEach(p -> result.add(p[1], p));
        return result.toArray(people);
    }

    public static void main(String[] args) {
        int[][] people = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        int[][] result = reconstructQueue(people);
        System.out.println(people);
        for(int[] i : result){
            System.out.print( "{");
            for (int temp : i){
                System.out.print(temp + ",");
            }
            System.out.print( "}");
        }
    }
}
