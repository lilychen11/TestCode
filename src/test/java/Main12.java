import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main12 {
    public static int longStr(char[] chars){
        int[] string = new int[chars.length];
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'b')
                string[i] = 0;
            else
                string[i] = 1;
        }
        int[] strcopy = Arrays.copyOf(string, string.length);
        int cur = string[0];
        int length = 1;
        int count = 1;
        int idx = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        for (int i = 1; i < chars.length; i++) {
            if (string[i] == string[i - 1]){
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()){
            idx = queue.poll();

            string = strcopy.clone();
            cur = string[idx];
            while (idx < string.length - 1){
                 for (int i = idx + 1; i < string.length; i++) {
                    if (cur != string[i]){
                        count++;
                        length = Math.max(count, length);
                        cur = string[i];
                    } else {
                        idx = i - 1;
                        break;
                    }
                    if (i == string.length - 1){
                        idx = i;
                    }
                }

                if (idx!= string.length - 1 && string[idx] != string[string.length - 1]){
                    int start = idx + 1;
                    int end = string.length - 1;
                    while (start < end) {
                        int temp = string[start];
                        string[start++] = string[end];
                        string[end--] = temp;
                    }
                } else {
                    count = 1;
                    idx++;
                    string = strcopy.clone();
                    if (idx < string.length)
                        cur = string[idx];
                }

            }
        }

        return length;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        char[] chars = str.toCharArray();
        System.out.println(longStr(chars));
    }
}
