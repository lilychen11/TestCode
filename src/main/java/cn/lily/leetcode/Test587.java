package cn.lily.leetcode;

import java.awt.*;
import java.util.*;
import java.util.List;

public class Test587 {
    public static int orientation(Point p, Point q, Point r) {
        return (q.y - p.y) * (r.x - q.x) - (q.x - p.x) * (r.y - q.y);
    }

    public static boolean inBetween(Point p, Point i, Point q) {
        boolean a = i.x >= p.x && i.x <= q.x || i.x <= p.x && i.x >= q.x;
        boolean b = i.y >= p.y && i.y <= q.y || i.y <= p.y && i.y >= q.y;
        return a && b;
    }

    public static List<Point> outerTrees(Point[] points) {
        HashSet<Point> hull = new HashSet<>();
        if (points.length < 4) {
            for (Point p : points) {
                hull.add(p);
            }
            return new ArrayList<Point>(hull);
        }
        int left_most = 0;
        for (int i = 0; i < points.length; i++) {
            if (points[i].x < points[left_most].x) {
                left_most = i;
            }
        }
        int p = left_most;
        do {
            int q = (p + 1) % points.length;
            for (int i = 0; i < points.length; i++) {
                if (orientation(points[p], points[i], points[q]) < 0) {
                    q = i;
                }
            }
            for (int i = 0; i < points.length; i++) {
                if ( i!= p && i !=q && orientation(points[p], points[i], points[q]) == 0 && inBetween(points[p], points[i], points[q])) {
                    hull.add(points[i]);
                }
            }
            hull.add(points[q]);
            p = q;
        } while (p != left_most);
         return new ArrayList<Point>(hull);
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
