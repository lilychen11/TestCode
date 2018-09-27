
import java.util.Arrays;
import java.util.Scanner;

public class MainNew {
    public static int cal(int[] nums) {
        Arrays.sort(nums);
        int a = 0;
        int flag = 1;
        for (int i = nums.length - 1; i>= 0; i--) {
            a += nums[i] * flag;
            flag *= -1;
        }
        return  a;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
       int[] nums = new int[size];
        for (int i = 0; i < size; i++) {
            nums[i] = scanner.nextInt();
        }
        System.out.println(cal(nums));
    }

}
