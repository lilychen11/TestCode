package cn.lily.example;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        double prince_temp = scan.nextDouble();
        int prince = (int)(prince_temp * 100);

        long sum1 = factory1(n, prince);
        long sum2 = factory2(n, prince);

        int factory;
        if (sum1 == sum2) factory = 0;
        else if (sum1 < sum2) factory = 1;
        else factory = 2;
        System.out.println(factory);
    }

    private static long factory1(int n, int prince) {
        if(n <=0 || prince <=0) {
            return 0;
        }
        long sum = (long)n * prince;
        if (n >= 3) sum *= 0.7;
        if (sum < 5000) sum += 1000;
        return sum;
    }

    private static long factory2(int n, int prince) {
        if(n <=0 || prince <=0) {
            return 0;
        }
        long sum = (long)n * prince;
        sum -= ((int)(sum / 1000)) * 200;
        if (sum < 9900) sum += 600;
        return sum;
    }
}
