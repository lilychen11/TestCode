package cn.lily.leetcode;

import java.awt.*;
import java.util.*;
import java.util.List;

public class Test587_3 {
    public static int orientation (Point p, Point q, Point r) {
        return (q.y - p.y) * (r.x - q.x) - (q.x - p.x) * (r.y - q.y);
    }
    public static List<Point> outerTrees(Point[] points) {
        Arrays.sort(points, (p, q) -> (q.x - p.x) == 0 ? - (q.y - p.y) : -(q.x - p.x));
        Stack<Point> hull = new Stack<>();
        for (int i = 0; i < points.length; i++) {
            while (hull.size() >= 2 && orientation(hull.get(hull.size() - 2), hull.get(hull.size() - 1), points[i]) > 0){
                hull.pop();
            }
            hull.push(points[i]);
        }
       // hull.pop();
        for (int i = points.length - 2; i >= 0; i--) {
            while (hull.size() >=2 && orientation(hull.get(hull.size() - 2), hull.get(hull.size() - 1), points[i]) > 0) {
                hull.pop();
            }
            hull.push(points[i]);
        }
        return new ArrayList<>(new HashSet<>(hull));
    }

    public static void main(String[] args) {
        Point[] points = new Point[6];
        points[0] = new Point(1,1);
        points[1] = new Point(2,2);
        points[2] = new Point(2,0);
        points[3] = new Point(2,4);
        points[4] = new Point(3,3);
        points[5] = new Point(4,2);
        System.out.println(outerTrees(points));
    }
}
