import java.util.PriorityQueue;
import java.util.Scanner;

public class Main3 {
    public static int minCost(int[][] voters, int[] candidates){
        int tWin = winT(candidates);
        int last = tWin;
        if (tWin == 0) return 0;
        int cost = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((p,q)->(p[1] - q [1]));
        PriorityQueue<int[]> pqWin = new PriorityQueue<>((p,q)->(p[1] - q [1]));
        for (int[] voter: voters) {
            if (voter[0]!= 1)
                pq.offer(voter);
            if (voter[1] == tWin)
                pqWin.offer(voter);
        }
        while (tWin != 0){
            if (candidates[tWin] - candidates[0] == 1){
                int[] tempW = pqWin.peek();
                int[] tp = pq.poll();
                if (tempW[0] == tp[0] && tempW[1] == tp[1]){
                    cost = tempW[1] + cost;
                    candidates[tWin]--;
                } else {
                    int tempC = cost + tempW[1];
                    int temp1 = cost+ tp[1] + pq.peek()[1];
                    cost = Math.min(tempC,temp1);
                }
            } else {
                int[] tv = pq.poll();
                cost += tv[1];
                candidates[tv[0] - 1]--;
            }
            tWin = winT(candidates);
            if (tWin != last){
                pqWin.clear();
                for (int[] voter: pq) {
                    if (voter[0] == last)
                        pqWin.offer(voter);
                }
            }
        }
        return cost;
    }
    public static int winT(int[] candidates) {
        int idx = 0;
        int res = candidates[0];
        for (int i = 1; i < candidates.length; i++) {
            if (candidates[i] > res) {
                res = candidates[i];
                idx = i;
            }
        }
        return idx;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[][] voters = new int[n][2];
        int[] candidates = new int[k];
        for (int i = 0; i < n; i++) {
            voters[i][0] = scanner.nextInt();
            voters[i][1] = scanner.nextInt();
            candidates[voters[i][0] - 1]++;
        }
        System.out.println(minCost(voters, candidates));
    }
}
