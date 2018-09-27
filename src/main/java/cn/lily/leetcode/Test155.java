package cn.lily.leetcode;

import java.util.Stack;

public class Test155 {

    public static class MinStack {
        private Stack<Integer> stack = new Stack<>();
        private Stack<Integer> stackMin = new Stack<>();

        public MinStack() {

        }

        public void push(int x) {
            stack.push(x);
            if (stackMin.isEmpty()) {
                stackMin.push(x);
            } else if (!stackMin.isEmpty() && x < stackMin.peek()) {
                stackMin.push(x);
            } else {
                stackMin.push(stackMin.peek());
            }
        }

        public void pop() {
            stack.pop();
            stackMin.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return stackMin.peek();
        }
    }


    public static void main(String[] args) {
        MinStack obj = new MinStack();
        obj.push(3);
        obj.push(31);
        //obj.pop();
        int param_3 = obj.top();
        int param_4 = obj.getMin();
        System.out.println("param_3 is " + param_3);
        System.out.println("param_4 is " + param_4);

    }
}
