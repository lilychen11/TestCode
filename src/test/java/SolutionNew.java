import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SolutionNew {
    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        int i = 0, j = 0;
        while (i < words.length) {
            j = i;
            int currWidth = words[i].length();
            while (j+1 < words.length && (currWidth + words[j+1].length() +j+1-i) <= maxWidth) {
                j++;
                currWidth += words[j].length();
            }
            int spaces = 0, remain = 0;
            if (j > i) {
                spaces = (maxWidth - currWidth) / (j - i);
                remain = (maxWidth - currWidth) - spaces * (j - i);
            }
            StringBuilder stringBuilder = new StringBuilder();
            for (int k = i; k <= j; k++) {
                stringBuilder.append(words[k]);

                if (j == words.length - 1 && stringBuilder.length() < maxWidth) {
                    stringBuilder.append(" ");
                } else if (k != j) {
                    for (int l = 0; l < spaces; l++)stringBuilder.append(" ");
                    if (remain-- > 0)stringBuilder.append(" ");
                }
            }
            int l = stringBuilder.length();
            for (int k = 0; k < maxWidth-l; k++) {
                stringBuilder.append(" ");
            }
            res.add(stringBuilder.toString());
            i = j+1;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] words = str.split(",");
        int maxWidth = scanner.nextInt();
        List<String> res = fullJustify(words,maxWidth);
        for (String temp : res)
            System.out.println(temp);
    }
}