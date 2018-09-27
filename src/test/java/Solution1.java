import java.util.*;
import java.io.IOException;
import java.util.Scanner;

public class Solution1 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        String l = "";
        int[] number = new int[10000000];
        int num_len = 0;
        int n = 1;
        for (int i = 0; i < s.length(); i++) {
            if (s.substring(i, i + 1).equals(l)) {
                n = n + 1;
            } else {
                number[num_len++] = n;
                l = s.substring(i, i + 1);
                n = 1;
            }
        }
        number[num_len++] = n;
        int start = 0;
        int max = 0;
        for (int i = 0; i <= num_len - 2; i++) {
            if (number[i] > number[i + 1] && number[i + 2] > number[i + 1] && 2 * Math.min(number[i], number[i + 2]) + number[i + 1] > max) {
                max = 2 * Math.min(number[i], number[i + 2]) + number[i + 1];
                start = i;
            }
        }
        int x = 0;
        for (int i = 1; i < start; i++) {
            x = x + number[i];
        }
        if (max == 0) {
            System.out.println("NULL");
        } else {
            System.out.print(s.substring(x, x + max));
        }

    }


}
