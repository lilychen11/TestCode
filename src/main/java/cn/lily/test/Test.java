package cn.lily.test;

import java.util.Scanner;

public class Test {


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        int[] map = new int[256];
        for (int i = 0; i < str.length(); i++) map[str.charAt(i)]++;
        int len = str.length();
        int sum = 0;
        for (int i = 0; i < 26; i++) {
            sum += len + 1 - map[i + 'a'];
        }
        System.out.println("test1 " + sum);
        System.out.println("test2 " + (str.length() * 25 + 26));
    }

}
