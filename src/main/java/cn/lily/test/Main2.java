package cn.lily.test;

public class Main2 {

    public static int[][] pos;
    public static int result = Integer.MAX_VALUE;


    public static void permutation(char[] chars) {
        if (chars == null || chars.length < 1) {
            return;
        }
        Permutation(chars, 0, chars.length, result);
    }

    public static void Permutation(char[] chars, int begin, int tLength, int cur) {
        if (chars == null || chars.length < 1) {
            return;
        }
        if (tLength == begin) {
            String temp = new String(chars);

        }

    }

    public static void main(String[] args) {
        char[] chars = {'a', 'a', 'z','z'};
        permutation(chars);
        System.out.println(result);
    }

}
