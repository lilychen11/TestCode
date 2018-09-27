package cn.lily;

import java.math.BigDecimal;
import java.util.Scanner;

public class MAIN {

    public static String change(int n,int m, int k) {

        if (k > m + n) {
            return -1 + " ";
        }
        return "";


    }
    public static void main(String[] args) {
        Scanner  scanner = new Scanner(System.in);
        int n  = scanner.nextInt();
        int m  = scanner.nextInt();
        int k  = scanner.nextInt();
        System.out.println(change(n,m,k));
    }

}
