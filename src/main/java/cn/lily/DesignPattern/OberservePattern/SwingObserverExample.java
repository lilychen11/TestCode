package cn.lily.DesignPattern.OberservePattern;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingObserverExample {
    JFrame frame;

    public static void main(String[] args) {
        SwingObserverExample example = new SwingObserverExample();
        example.go();
    }

    public void go() {
        frame = new JFrame("SwingObserverExample");
        JButton button = new JButton("Should I do it");
        button.addActionListener(new AngelListener());
        button.addActionListener(new DevilListener());
        frame.setSize(500, 400);
        frame.setLocation(400, 200);
        frame.setBackground(Color.WHITE);
        frame.getContentPane().add(BorderLayout.CENTER, button);
        frame.setVisible(true);

    }

    class AngelListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            System.out.println("Don't do it, you might regret it!");
        }
    }

    class DevilListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Come on, do it!");
        }
    }
}
