package com.toze.electronic;

import com.toze.electronic.panels.base.BasePanel;

import javax.swing.*;

public class ElectronicAPP {

    public ElectronicAPP(){

        final JFrame frame = new JFrame("Electronic");
        final JPanel panel = new BasePanel(frame);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 800);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.add(panel);

    }

}
