package com.toze.electronic.panels.types.base;

import com.toze.electronic.api.Configuration;

import javax.swing.*;
import java.awt.*;

public class BaseViewPanel extends JPanel {

    private final JFrame frame;

    public BaseViewPanel(JFrame frame) {
        super();
        this.setName("BasePanel");
        this.setLayout(null);
        this.frame = frame;
    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        g.setColor(new Color(15, 20, 31)); // Background color
        g.fillRect(0, 0, frame.getWidth(), frame.getHeight()); // Background set

        g.setColor(new Color(88, 97, 115)); // set grid color

        for (int i = 0; i < frame.getWidth(); i += Configuration.GRID_SIZE) // Vertical lines
            g.fillRect(i, 0, Configuration.LINE_SIZE, frame.getHeight());

        for (int i = 0; i < frame.getHeight(); i += Configuration.GRID_SIZE) // Horizontal lines
            g.fillRect(0, i, frame.getWidth(), Configuration.LINE_SIZE);

    }

}
