package cn.lily.Test9_17;

import java.util.*;

public class Main1 {
    public static int finfMin(int[] nums) {
        boolean[] state = new boolean[nums.length];
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
            if (set.size() >= 3) {
                if (check(set))
                    return i;
            }
        }
        return -1;
    }

    public static boolean check(HashSet<Integer> set) {
        List<Integer> copy = new LinkedList<>();
        copy.addAll(set);
        for (int i = 0; i < copy.size(); i++) {
            for (int j = i + 1; j < copy.size(); j++) {
                if (i != j) {
                    int a = copy.get(i);
                    int b = copy.get(j);
                    int diff = Math.abs(a - b);
                    int sum = a + b;
                    for (int k = 0; k < copy.size(); k++) {
                        if (k != i && k != j) {
                            int c = copy.get(k);
                            int sum1 = a + c;
                            int sum2= c + b;
                            int diff1 =Math.abs( a - c);
                            int diff2 = Math.abs(b - c);
                            if (c > diff && c < sum) {
                                if (sum1 > b && diff1 < b && sum2 > a && diff2 < a)
                                    return true;
                            }
                            int[] temp = {a, b, c};
                            Arrays.sort(temp);
                            int total0 = temp[0] + temp[1] + temp[2];
                            int diff0 = temp[2] - temp[0] - temp[1];
                            for (int l = 0; l < copy.size(); l++) {
                                if (l != i && l != j && l != k && copy.get(l) > diff0 && copy.get(i) < total0){
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if (n < 3) System.out.println(-1);
        else {
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = scanner.nextInt();
            }
            System.out.println(finfMin(nums) + 1);
        }
    }
}
