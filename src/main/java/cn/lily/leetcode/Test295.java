package cn.lily.leetcode;

import java.util.PriorityQueue;

public class Test295 {
    static class MedianFinder{
        private PriorityQueue<Integer> pq1 = new PriorityQueue<>((p, q) -> (q - p));
        private PriorityQueue<Integer> pq2 = new PriorityQueue<>((p, q) -> (p - q));
        public MedianFinder(){

        }
        public void addNum(int num) {
            if (pq1.size() == pq2.size()) {
                if (!pq2.isEmpty()  && pq2.peek() < num){
                    pq1.offer(pq2.poll());
                    pq2.offer(num);
                } else
                    pq1.offer(num);

            } else {
                if (!pq1.isEmpty() &&pq1.peek() > num){
                    pq2.offer(pq1.poll());
                    pq1.offer(num);
                } else
                    pq2.offer(num);
            }
        }
        public double findMedian() {
            double median = 0;
            if (pq1.size() == pq2.size()){
                median = (pq1.peek() + pq2.peek()) / 2.0;
            } else {
                median = pq1.peek();
            }
            return median;
        }
    }

    public static void main(String[] args) {
        MedianFinder obj = new MedianFinder();
        obj.addNum(1);
        System.out.println(obj.findMedian());
        obj.addNum(2);
        System.out.println(obj.findMedian());
        obj.addNum(3);
        System.out.println(obj.findMedian());
    }

}
