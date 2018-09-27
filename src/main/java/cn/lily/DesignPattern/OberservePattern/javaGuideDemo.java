package cn.lily.DesignPattern.OberservePattern;

import javax.swing.*;
import java.awt.*;

public class javaGuideDemo {
    public static void main(String arg[]){
        JFrame f=new JFrame("JAVA界面程序1");
        JLabel l=new JLabel("欢迎您",JLabel.CENTER);
        f.add(l);
        f.setSize(500,400);
        f.setLocation(400,200);
        f.setBackground(Color.WHITE);
        f.setVisible(true);

    }
}
