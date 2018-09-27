package cn.lily.Test9_18;

import cn.lily.DesignPattern.FactoryPattern.Pizza;

import java.math.BigDecimal;
import java.util.*;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int target = scanner.nextInt();
        int diff = n - Math.abs(target);
        int shift = diff / 2;
        if (diff % 2 == 1) {
            System.out.println(0);
        } else {
            int balls = shift;
            int box = n - shift;
            //if (balls == box)
            System.out.println(cal(balls + box - 1, box - 1));
        }
    }

    public static BigDecimal cal(int down, int up) {
        if (down < up){
            return new BigDecimal(-1);
        }
        if (down == up || up == 0)
            return new BigDecimal(1);
        if (up > down - up)
            up = down - up;
        int count = up;
        BigDecimal top = new BigDecimal(1);
        BigDecimal bottom = new BigDecimal(1);
        // double bottom = 1;
        while (count > 0) {
            top = top.multiply(new BigDecimal(count));
            bottom = bottom.multiply(new BigDecimal(down));
            //bottom *= down;
            down--;
            count--;
        }
        return bottom.divide(top);
    }
}
