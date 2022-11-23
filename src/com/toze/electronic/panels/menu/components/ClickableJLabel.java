package com.toze.electronic.panels.menu.components;

import com.toze.electronic.panels.menu.MenuElement;
import com.toze.electronic.panels.menu.MenuPanel;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.concurrent.atomic.AtomicLong;

public class ClickableJLabel extends JLabel implements MouseListener, MouseMotionListener {

    private final MenuElement element;
    private final MenuPanel menuPanel;
    private final AtomicLong delay = new AtomicLong(0);

    public ClickableJLabel(MenuElement element, MenuPanel menuPanel) {

        super("» " + element.getName());

        this.element = element;
        this.menuPanel = menuPanel;

        this.setForeground(element.getColor());
        this.setHorizontalAlignment(SwingConstants.CENTER);
        this.setVerticalAlignment(SwingConstants.CENTER);

        this.addMouseListener(this);
        this.addMouseMotionListener(this);

    }

    @Override
    public void mousePressed(MouseEvent e) {
        this.menuPanel.mousePressed(e);
        this.delay.set(System.currentTimeMillis());
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        this.menuPanel.mouseClicked(e);
    }

    @Override
    public void mouseReleased(MouseEvent e) {

        this.menuPanel.mouseReleased(e);

        if (System.currentTimeMillis() - this.delay.get() < 200)
            this.element.action();

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        this.menuPanel.mouseEntered(e);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        this.menuPanel.mouseExited(e);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        this.menuPanel.mouseDragged(e);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        this.menuPanel.mouseMoved(e);
    }
}
