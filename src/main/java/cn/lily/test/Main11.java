package cn.lily.test;

import java.util.Scanner;

public class Main11 {
    public static int[] merge(int[] numA, int[] numB) {
        if (numA.length == 0)
            return numB;
        if (numB.length == 0)
            return numA;
        int a = 0, b = 0;
        int[] res = new int[numA.length + numB.length];
        int idx = 0;
        while (a < numA.length && b < numB.length) {
            if (numA[a] <= numB[b])
                res[idx++] = numA[a++];
            else
                res[idx++] = numB[b++];
        }
        if (a < numA.length){
            while (idx < res.length){
                res[idx++] = numA[a++];
            }
        }
        if (b < numB.length) {
            while (idx < res.length){
                res[idx++] = numB[b++];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1  = sc.nextLine();
        String[] strA = str1.split(",");
        int[] numA = new int[strA.length];
        for (int i = 0; i < strA.length; i++) {
            numA[i] = Integer.parseInt(strA[i]);
        }

        String str2 = sc.hasNextLine()? sc.nextLine() : "";
        if (!str2.equals("")){
            String[] strB = str2.split(",");
            int[] numB = new int[strB.length];
            for (int i = 0; i < strB.length; i++) {
                numB[i] = Integer.parseInt(strB[i]);
            }
            int[] result = merge(numA, numB);
            String res = "";
            for (int i = 0; i < result.length; i++) {
                res += result[i];
                if (i != result.length - 1){
                    res += ",";
                }
            }
            System.out.println(res);
        } else {
            System.out.println(str1);
        }
        String temp = "";
        System.out.println("--------------:"+temp.split(",")[0].length()+":--------------");


    }
}
