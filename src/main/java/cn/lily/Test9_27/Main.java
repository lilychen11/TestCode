package cn.lily.Test9_27;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        scanner.nextLine();
        List<HashSet<Integer>> nums = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            String[] temp = scanner.nextLine().split(" ");
            HashSet<Integer> list = new HashSet<>();
            for (int j = 0; j < temp.length; j++) {
                list.add(Integer.parseInt(temp[j]));
            }
            nums.add(list);
        }
        int[] res = new int[2];
        if(nums.size() != 0){
            res = merge(nums);
        }

        System.out.println(res[0]);
        System.out.println(res[1]);
    }

    public static int[] merge(List<HashSet<Integer>> nums) {
        int length = 0;
        for (int i = 0; i < nums.size(); i++) {
            HashSet<Integer> idx = nums.get(i);
            for (int j = 0; j < i; j++) {
                HashSet<Integer> comp = nums.get(j);
                for (Integer num: idx) {
                    if (comp.contains(num)){
                        comp.addAll(nums.remove(i--));
                        length = Math.max(length, comp.size());
                        break;
                    }
                }
            }
        }
       return new int[]{nums.size(), length};
    }

}

