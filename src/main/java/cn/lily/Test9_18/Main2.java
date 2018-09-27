package cn.lily.Test9_18;

import javafx.geometry.Point3D;

import javax.swing.*;

import java.awt.*;
import java.util.*;
import java.util.List;

public class Main2 {
    public static int line = 0;

   public static class DrawComponent extends JComponent {
       private Point3D[] points;
        public DrawComponent(Point3D[] points){
            this.points = points;
        }
        @Override
        protected void paintComponent(Graphics g) {
            for (int i = 0; i < points.length; i++) {
                g.drawOval((int)points[i].getX() * 50, (int)points[i].getY() * 50, 20, 20);
                //g.drawLine((int)points[i].getX() * 50, (int)points[i].getY() * 50, (int)points[i].getX() * 50, (int)points[i].getY() * 50);
            }
           // g.drawLine(-1000, 0, 100, 1000);
            g.setColor(Color.BLUE);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Points");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(250, 200);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        //int[][] array ={{1, 1},{-1, -1},{2,2},{1,2},{3,3},{2,4}};
        int[][] array = {{1, 4}, {2, 3}, {2, 1}, {3, 2}, {4, 1}, {5, 0}, {4, 3}, {5, 4},{4,2}, {2,4}};

        Point3D[] points = new Point3D[array.length];
        for (int i = 0; i < array.length; i++) {
            points[i] = new Point3D(array[i][0], array[i][1], i);
        }
        frame.add(new DrawComponent(points));
        boolean[] state = new boolean[points.length];
        for (int i = 0; i < points.length; i++) {
            if (state[i])
                continue;
            HashMap<Double, List<Point3D>> map = new HashMap<>();
            for (int j = i + 1; j < points.length; j++) {
                if (state[j])
                    continue;
                double radio = ratio(points[i], points[j]);
                if (map.containsKey(radio)) {
                    map.get(radio).add(points[j]);
                } else {
                    List<Point3D> tlist = new LinkedList<Point3D>();
                    tlist.add(points[j]);
                    map.put(radio, tlist);
                }
            }
            Iterator<Map.Entry<Double, List<Point3D>>> iterator = map.entrySet().iterator();
            int count = 0;
            Double key = 0.0;
            while (iterator.hasNext()) {
                Map.Entry<Double, List<Point3D>> entry = iterator.next();
                if (entry.getValue().size() > count) {
                    count = entry.getValue().size();
                    key = entry.getKey();
                }
            }
            if (count > 1) {
                state[(int) points[i].getZ()] = true;
                for (Point3D point : map.get(key)) {
                    state[(int) point.getZ()] = true;
                }
                line++;
            }
        }
        int unCol = 0;
        for (boolean s : state) {
            if (!s)
                unCol++;
        }
        if (unCol > 0 && unCol < 2) {
            line++;
        } else if (unCol > 0){
            line += unCol - 1;
        }
        System.out.println(line);
    }

    public static double ratio(Point3D a, Point3D b) {
        if (Math.abs(a.getX() - b.getX()) <= 1e-6)
            return Integer.MAX_VALUE;
        return (a.getY() - b.getY()) / (a.getX() - b.getX());

    }
}
