package cn.lily.leetcode;

import java.util.LinkedList;
import java.util.List;

public class Test412 {
    public static List<String> fizzBuzz(int n) {
        List<String> list = new LinkedList<>();
        if (n < 1)
            return list;
        int count3 = 3;
        int count5 = 5;
        for (int i = 1; i <= n; i++){
            if (i == count3 && i == count5) {
                list.add("FizzBuzz");
                count3 += 3;
                count5 += 5;
            } else if (i == count3) {
                list.add("Fizz");
                count3 += 3;
            } else if(i == count5){
                list.add("Buzz");
                count5 += 5;
            } else {
                list.add(i + "");
            }
        }
        return list;
    }

}
