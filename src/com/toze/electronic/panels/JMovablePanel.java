package com.toze.electronic.panels;

import com.toze.electronic.Configuration;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.TimerTask;

public abstract class JMovablePanel extends JPanel implements MouseListener {

    private Double[] position;

    public JMovablePanel() {

        super();
        this.addMouseListener(this);

        new java.util.Timer().schedule(new TimerTask() {

            @Override
            public void run() {

                try {
                    JMovablePanel.this.updateLocation();
                } catch (Exception ignored) {
                }

            }

        }, 0, 1000 / Configuration.REFRESH_RATE);

    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getClickCount() == 1)
            this.position = this.getMouseLocation();
        else
            this.position = null;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        this.position = null;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    private void updateLocation() {

        if (this.position == null)
            return;

        final Double[] mouseLocation = this.getMouseLocation();
        this.setLocation((int) (this.getX() + (mouseLocation[0] - this.position[0])), (int) (this.getY() + (mouseLocation[1] - this.position[1])));
        this.position = mouseLocation;

    }

    private Double[] getMouseLocation() {
        final Point point = MouseInfo.getPointerInfo().getLocation();
        return new Double[]{
                point.getX(), point.getY()
        };
    }

}
