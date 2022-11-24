package com.toze.electronic;

import com.toze.electronic.api.Configuration;
import com.toze.electronic.api.components.IBuildElement;
import com.toze.electronic.api.components.IComponent;
import com.toze.electronic.api.components.IPosition;
import com.toze.electronic.api.controller.IElementController;
import com.toze.electronic.api.model.IElementModel;
import com.toze.electronic.api.view.IElementView;
import com.toze.electronic.api.view.Observer;
import com.toze.electronic.components.Component;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.*;
import java.util.List;
import java.util.Timer;
import java.util.concurrent.CopyOnWriteArrayList;

public class ElementView extends JPanel implements IElementView, MouseListener {

    private final CopyOnWriteArrayList<Observer> observers;
    private final IElementController controller;
    private final IElementModel model;
    private Point mousePosition;

    protected ElementView(JFrame frame, IElementModel elementModel, IElementController elementController) {

        super();

        this.setName("ElementView");
        this.setBounds(0, 0, Configuration.FRAME_WIDTH, Configuration.FRAME_HEIGHT);
        this.setVisible(true);
        this.setLayout(null);
        this.setOpaque(false);
        this.addMouseListener(this);

        this.observers = new CopyOnWriteArrayList<>();

        this.controller = elementController;
        this.model = elementModel;

        new Timer().schedule(new TimerTask() {

            @Override
            public void run() {
                ElementView.this.repaint();
            }

        }, 0, 1000 / Configuration.REFRESH_RATE);


    }

    @Override
    public void addObserver(Observer observer) {
        this.observers.add(observer);
    }

    @Override
    synchronized public void removeObserver(Observer observer) {
        this.observers.remove(observer);
    }

    @Override
    public void notifyClick(MouseEvent event) {

        for (final Observer observer : this.observers)
            observer.onClick(event);

    }

    @Override
    synchronized protected void paintComponent(Graphics gl) {

        super.paintComponent(gl);
        this.updateMousePosition();
        final Graphics2D g = (Graphics2D) gl;

        placeBuildElement(g);
        placeAllElements(g);

    }

    private void placeAllElements(Graphics2D g) {

        g.setStroke(new BasicStroke(1));

        for(final IComponent element : this.model.getElements()) {

            final Component component = (Component) element;
            final IPosition from = component.getFrom();
            final IPosition to = component.getTo();

            g.setColor(Color.YELLOW);
            g.drawLine(from.getX() * Configuration.GRID_SIZE, from.getY() * Configuration.GRID_SIZE,
                    to.getX() * Configuration.GRID_SIZE, to.getY() * Configuration.GRID_SIZE);

        }

    }

    private void updateMousePosition() {
        this.mousePosition = MouseInfo.getPointerInfo().getLocation();
        SwingUtilities.convertPointFromScreen(this.mousePosition, this);
    }

    private void placeBuildElement(Graphics2D g) {

        final IBuildElement buildElement = this.controller.getCurrentBuild();

        if(buildElement == null)
            return;

        if(buildElement.hasFrom()){
            final IPosition from = buildElement.getFrom();
            g.setStroke(new BasicStroke(Configuration.LINE_SIZE + 4));
            g.setColor(Color.YELLOW);
            g.drawLine(from.getX(), from.getY(), this.mousePosition.x, this.mousePosition.y);
        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    synchronized public void mousePressed(MouseEvent e) {
        for(final Observer observer : this.observers) // Notify all the observers like BuildElement
            observer.onClick(e);
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

}
