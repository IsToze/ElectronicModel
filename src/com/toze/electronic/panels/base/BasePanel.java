package com.toze.electronic.panels.base;

import com.toze.electronic.Configuration;

import javax.swing.*;
import java.awt.*;

public class BasePanel extends JPanel {

    private final JFrame frame;

    public BasePanel(JFrame frame) {
        super();
        this.frame = frame;
    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        g.setColor(new Color(15, 20, 31));
        g.fillRect(0, 0, frame.getWidth(), frame.getHeight());

        g.setColor(new Color(88, 97, 115)); // set grid color

        for(int i = 0; i < frame.getWidth(); i += Configuration.GRID_SIZE) // Vertical lines
            g.fillRect(i, 0, Configuration.LINE_SIZE, frame.getHeight());

        for(int i = 0; i < frame.getHeight(); i += Configuration.GRID_SIZE) // Horizontal lines
            g.fillRect(0, i, frame.getWidth(), Configuration.LINE_SIZE);

    }

}
