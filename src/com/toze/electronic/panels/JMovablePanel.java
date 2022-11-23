package com.toze.electronic.panels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public abstract class JMovablePanel extends JPanel implements MouseListener, MouseMotionListener {

    private Point currentLocation;

    public JMovablePanel() {

        super();
        this.addMouseListener(this);
        this.addMouseMotionListener(this);

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
            this.currentLocation = MouseInfo.getPointerInfo().getLocation();
        else
            this.currentLocation = null;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {

        if (this.currentLocation == null)
            return;

        final Point newLocation = MouseInfo.getPointerInfo().getLocation();
        this.setLocation(
                this.getX() + (newLocation.x - this.currentLocation.x),
                this.getY() + (newLocation.y - this.currentLocation.y)
        );
        this.currentLocation = newLocation;

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

}
