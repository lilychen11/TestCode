package cn.lily.Test9_27;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Main2 {
    private static int count = 0;
    public static List<List<String>> lists = new LinkedList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        /*int n = 7;
        int m = 0;*/
        List<String> temp1 = new LinkedList<>();
        temp1.add("+");
        List<String> temp2 = new LinkedList<>();
        temp2.add("+");
        List<String> temp3 = new LinkedList<>();
        temp3.add("+");
        possi(n, m, 0, 1, "+", 2, " ", true, temp1);
        possi(n, m, 0, 1, "+", 2, "-", false, temp2);
        possi(n, m, 0, 1, "+", 2, "+", false, temp3);
        System.out.println(count);
    }

    public static void possi(int n, int m, int first, int second, String lastOper, int cur, String curOper, boolean flag, List<String> list) {
        if (cur > n) {
            int res = cal(first, second, lastOper);
            if (res == m && !lists.contains(list)) {
                lists.add(new LinkedList<>(list));
                count++;
            }
            return;
        }
        if (flag) {
            int curSecond = second * 10 + cur;
            list.add(" ");
            possi(n, m, first, curSecond, lastOper, cur + 1, "-", false, list);
            possi(n, m, first, curSecond, lastOper, cur + 1, "+", false, list);
            // list.remove(" ");
        } else {
            int curFirst = cal(first, second, lastOper);
            list.add(curOper);
            possi(n, m, curFirst, cur, curOper, cur + 1, " ", true, list);
            possi(n, m, curFirst, cur, curOper, cur + 1, "-", false, list);
            possi(n, m, curFirst, cur, curOper, cur + 1, "+", false, list);
        }
        list.remove(list.size() - 1);
    }
    public static int cal(int a, int b, String operation) {
        int res = 0;
        switch (operation) {
            case "+":
                res = a + b;
                break;
            case "-":
                res = a - b;
                break;
        }
        return res;
    }
}
