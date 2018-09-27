package cn.lily.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class Test56 {
    public static class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    public static List<Interval> merge(List<Interval> intervals) {
        PriorityQueue<Interval>  priorityQueue = new PriorityQueue<Interval>(
                (p, q) -> (p.start - q.start)
        );
        int index = 0;
        while (index < intervals.size()) {
            priorityQueue.add(intervals.get(index));
            index++;
        }
        LinkedList<Interval> result = new LinkedList<Interval>();
        if (priorityQueue.size() < 2) {
            if (priorityQueue.size() == 1) {
                result.offer(priorityQueue.poll());
            }
            return result;
        }
        result.add(priorityQueue.poll());
        while (!priorityQueue.isEmpty()) {
            Interval last = result.get(result.size() - 1);
            Interval cur = priorityQueue.poll();
            if (cur.start <= last.end) {
                last.end = Math.max(cur.end,last.end);
                //last.start = Math.min(last.start, cur.start);
            } else {
                result.add(cur);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Interval> intervals = new LinkedList<>();
        intervals.add(new Interval(15,18));
        intervals.add(new Interval(1,3));
        intervals.add(new Interval(2,6));
        intervals.add(new Interval(8,10));

        System.out.println(merge(intervals));
    }


}
