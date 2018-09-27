package cn.lily.test;

public class Test43 {
    public static void printProbability(int number, int max) {
        if(number < 1 || max < 1) {
            return;
        }
        int maxSum = number * max;
        int[] probabilities = new int[maxSum - number + 1];
        probability(number, probabilities, max);

        double total = 1;
        for(int i = 0; i < number; i++) {
            total *= max;
        }
        System.out.println(total);
        for(int i = number; i <= maxSum; i++) {
            double ratio = probabilities[i - number] / total;
            System.out.printf("%-8.4f", ratio);
        }

        System.out.println();
    }
    private static void probability(int number, int[] probabilities, int max) {
        for(int i = 1; i <= max; i++) {
            probability(number, number, i, probabilities, max);
        }
    }
    private static void probability(int original, int current, int sum, int[] probabilities, int max) {
        if(current == 1) {
            probabilities[sum -original]++;
        }else {
            for(int i = 1; i <= max; i++) {
                probability(original, current - 1, i + sum, probabilities, max);
            }
        }
    }
    public static void printProbability2(int number, int max) {
        if(number < 1 || max < 1) {
            return;
        }
        int[][] probabilities = new int[2][max * number + 1];
        for(int i = 0; i < max * number + 1; i++) {
            probabilities[0][i] = 0;
            probabilities[1][i] = 0;
        }

        int flag = 0;

        for(int i = 1; i <= max; i++) {
            probabilities[flag][i] = 1;
        }
        for(int k = 2; k <= number; k++) {
            for(int i = 0; i < k; i++) {
                probabilities[1-flag][i] = 0;
            }
            for(int i = k; i <= max * k; i++) {
                probabilities[1 - flag][i] = 0;
                for(int j = 1; j <= i && j <= max; j++) {
                    probabilities[1 - flag][i] += probabilities[flag][i - j];
                }
            }
            flag = 1 - flag;
        }
        double total = 1;
        for(int i = 0; i < number; i++) {
            total *= max;
        }
        for(int i = number; i <= number * max; i++) {
            double ratio = probabilities[flag][i] / total;
            System.out.printf("%-8.4f", ratio);
        }
        System.out.println();
    }
    public static void main(String[] args) {
        test01();
        test02();
    }

    private static void test01() {
        printProbability(2, 4);
    }
    private static void test02() {
        printProbability2(2, 4);
    }

  /*  public static void probabilities3(int number, int max) {
        if(number < 1 || max < 1) {
            return;
        }
        int[][] probability = new int[2][max * number + 1];
        for(int i = 0; i <= max * number; i++) {
            probability[0][i] = 0;
            probability[1][i] = 0;
        }

        int flag = 0;
        for(int i = 1; i <= max; i++) {
            probability[flag][i] = 1;
        }
        for(int i = 2; i <= number; i++) {
            for(int j = 0; j < i; j++) {
                probability[1 - flag][j] = 0;
            }
            for (int k = i; k <= max * i; k++) {
                probability[1 - flag][k] = 0;
                for(int j = 1; j <= k && j <= max; j++) {
                    probability[1 - flag][k] += probability[flag][k - j];
                }
            }
            flag = 1 - flag;
        }
        double total = 1;
        total = Math.pow((double)max, (double)number);
        for(int i = number; i <= max * number; i++) {
            double ratio = probability[flag][i] / total;
            System.out.printf("%-8.4f", ratio);
        }
        System.out.println();
    }*/
}
