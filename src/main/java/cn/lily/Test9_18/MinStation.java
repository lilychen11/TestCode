package cn.lily.Test9_18;

import java.util.Stack;

public class MinStation {
    public static int findMin(int numOfGS, int[] distOfGs, int[] allowedGasoline, int distance, int initialGasoline) {
        int[] distOfGsNew = new int[distOfGs.length + 2];
        distOfGsNew[0] = 0;
        distOfGsNew[distOfGsNew.length - 1] = distance;
        System.arraycopy(distOfGs, 0, distOfGsNew, 1, distOfGs.length);
        int[] Gas = new int[numOfGS + 2];
        Gas[0] = initialGasoline;
        System.arraycopy(allowedGasoline, 0, Gas, 1, allowedGasoline.length);
        int[] count = new int[1];
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{initialGasoline, 0});
        return BFS(count, distOfGsNew, Gas, stack, distance);
    }

    public static int BFS(/*int curDist, int curGs, int idx,*/ int[] count, int[] distOfGsNew, int[] Gas, Stack<int[]> stack, int distance) {
        Stack<int[]> stackCur = new Stack<>();
        while (!stack.isEmpty()) {
            int[] state = stack.pop();
            int curGs = state[0];
            int idx = state[1];
            if (idx == distOfGsNew.length - 1 || curGs >= distance) {
                return count[0];
            }
            for (int i = idx + 1; i < distOfGsNew.length; i++) {
                if (distOfGsNew[i] > curGs)
                    break;
                int[] newState = new int[2];
                newState[0] = curGs + Gas[i];
                newState[1] = i;
                stackCur.push(newState);
            }
        }
        count[0]++;
        if (stackCur.isEmpty())
            return -1;
        return BFS(count, distOfGsNew, Gas, stackCur, distance);
    }

    public static void main(String[] args) {
        int numOfGs = 4;
        int[] distOfGS = {5, 7, 8, 10};
        int[] allowedGasoline = {2, 3, 1, 5};
        int distance = 16;
        int initalGasoline = 5;
        System.out.println(findMin(numOfGs, distOfGS, allowedGasoline, distance, initalGasoline));
    }
}
