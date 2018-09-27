package cn.lily.leetcode;

import java.util.ArrayList;
import java.util.Stack;

public class Test121 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 1){
            return 0;
        }
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = prices.length - 1; i >= 0; i--) {
            if (stack.isEmpty()){
                stack.push(prices[i]);
            } else {
                if (prices[i] > stack.peek()){
                    stack.push(prices[i]);
                } else {
                    stack.push(stack.peek());
                }
            }
        }
        for (int i = 0; i < prices.length; i++) {
            int temp = stack.pop() - prices[i];
            if (temp > max){
                max = temp;
            }
        }
        return max;
    }
}
