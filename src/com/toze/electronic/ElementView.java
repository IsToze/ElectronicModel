package com.toze.electronic;

import com.toze.electronic.api.Configuration;
import com.toze.electronic.api.view.IElementView;
import com.toze.electronic.api.view.Observer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class ElementView extends JPanel implements IElementView {

    private final List<Observer> observers;

    public ElementView(JFrame frame) {

        super();

        this.setName("ElementView");
        this.setBounds(0, 0, Configuration.FRAME_WIDTH, Configuration.FRAME_HEIGHT);
        this.setVisible(true);
        this.setLayout(null);
        this.setOpaque(false);

        this.observers = new ArrayList<>();

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
    public void removeObserver(Observer observer) {
        this.observers.remove(observer);
    }

    @Override
    public void notifyClick(MouseEvent event) {

        for (final Observer observer : this.observers)
            observer.onClick(event);

    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);



    }

}
