package com.toze.electronic.panels.menu;

import com.toze.electronic.api.Configuration;
import com.toze.electronic.panels.JMovablePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.List;

public class MenuPanel extends JMovablePanel {

    private final JLabel title;
    private final Color hideColor;
    private final Color showColor;
    private final List<MenuElement> elements;

    private final MenuInteractivePanel interactivePanel;

    public MenuPanel(int x, int y, String title, Color hideColor, Color showColor, List<MenuElement> elements) {

        super();

        this.title = new JLabel(title);
        this.title.setFont(new Font("Arial", Font.BOLD, 20));
        this.title.setForeground(hideColor);

        this.hideColor = hideColor;
        this.showColor = showColor;
        this.elements = elements;

        this.setBounds(x, y, 200, Configuration.MENU_ELEMENT_HEIGHT);
        this.setVisible(true);
        this.setLayout(null);
        this.setOpaque(false);

        this.add(new MenuButton(this));

        this.interactivePanel = new MenuInteractivePanel(this, this.elements);
        this.add(this.interactivePanel);

    }

    public MenuPanel(int x, int y, String title, List<MenuElement> elements) {
        this(x, y, title, Color.RED, Color.YELLOW, elements);
    }

    public JLabel getTitle() {
        return title;
    }

    public Color getHideColor() {
        return hideColor;
    }

    public Color getShowColor() {
        return showColor;
    }

    public List<MenuElement> getElements() {
        return elements;
    }

    @Override
    public void mousePressed(MouseEvent e) {

        super.mousePressed(e);

        final Point point = MouseInfo.getPointerInfo().getLocation();
        SwingUtilities.convertPointFromScreen(point, this);

        if (point.getY() <= Configuration.MENU_ELEMENT_HEIGHT && e.getClickCount() == 2)
            this.interactivePanel.update();

    }

}
