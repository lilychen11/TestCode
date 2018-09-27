package cn.lily.leetcode;

import java.awt.*;
import java.util.*;
import java.util.List;

public class Test587_2 {
    public static int orientation(Point p, Point q, Point r) {
        return (q.y - p.y) * (r.x - q.x) - (q.x - p.x) * (r.y - q.y);
    }
    public static int distance(Point p, Point q) {
        return (p.x - q.x) * (p.x - q.x) + (p.y - q.y) * (p.y - q.y);
    }
    private static Point bottomLeft(Point[] points) {
        Point bottomLeft = points[0];
        for (Point p : points) {
            if (p.y < bottomLeft.y) {
                bottomLeft = p;
            }
        }
        return bottomLeft;
    }
    public static List<Point> outerTrees(Point[] points) {
        if (points.length <= 1) {
            return Arrays.asList(points);
        }
        Point bm = bottomLeft(points);
        Arrays.sort(points, (p, q) -> {
            double diff = orientation(bm, p, q) - orientation(bm, q, p);
                    if (diff== 0)
                        return distance(bm, p) - distance(bm,q);
                    else
                        return diff > 0 ? 1 : -1;}
        );
        int i = points.length - 1;
        while (i >= 0 && orientation(bm, points[points.length - 1], points[i]) == 0) {
            i--;
        }
        for (int l = i + 1, h = points.length - 1; l < h; l++, h--) {
            Point temp = points[l];
            points[l] = points[h];
            points[h] = temp;
        }
        Stack<Point> stack = new Stack<>();
        stack.push(points[0]);
        stack.push(points[1]);
        for (int j = 2; j < points.length; j++) {
            Point top = stack.pop();
            while (orientation(stack.peek(), top, points[j]) > 0) {
                top = stack.pop();
            }
            stack.push(top);
            stack.push(points[j]);
        }
        return new ArrayList<>(stack);
    }
    public static void main(String[] args) {
        Point[] points = new Point[6];
        points[0] = new Point(1,1);
        points[1] = new Point(2,2);
        points[2] = new Point(2,0);
        points[3] = new Point(2,4);
        points[4] = new Point(3,3);
        points[5] = new Point(4,2);
        List<Point> arrayList = outerTrees(points);
        Collections.sort(arrayList, (p, q) -> (p.x - q.x));
        System.out.println(arrayList);
    }
}
