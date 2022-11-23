package com.toze.electronic.panels.menu;

import com.toze.electronic.api.Configuration;
import com.toze.electronic.panels.RoundedBorder;
import com.toze.electronic.panels.menu.components.ClickableJLabel;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class MenuInteractivePanel extends JPanel {

    private final MenuPanel menuPanel;
    private final JLabel title;
    private final List<MenuElement> elements;
    private final AtomicBoolean showing;

    protected MenuInteractivePanel(MenuPanel panel, List<MenuElement> elements) {

        super();

        this.menuPanel = panel;
        this.title = panel.getTitle();
        this.elements = elements;
        this.showing = new AtomicBoolean(false);

        this.setLayout(null);
        this.setBackground(new Color(5, 10, 40));
        this.setBorder(new RoundedBorder(20, new Color(10, 69, 91)));
        this.setBounds(0, Configuration.MENU_ELEMENT_HEIGHT, 200, 30 * elements.size());
        this.setVisible(false);

        // Show elements
        for (int i = 0; i < elements.size(); i++) {

            final MenuElement element = elements.get(i);
            final JLabel text = new ClickableJLabel(element, this.menuPanel);

            text.setBounds(0, 30 * i, 200, 30);
            this.add(text);

        }

    }

    public void update() { // Show or hide the panel
        if (showing.get()) {
            this.showing.set(false);
            this.hidePanel();
        } else {
            this.showing.set(true);
            this.showPanel();
        }
    }

    private void hidePanel() { // Hide the panel
        this.setVisible(false);
        this.title.setForeground(this.menuPanel.getHideColor());
        this.menuPanel.setBounds(this.menuPanel.getX(), this.menuPanel.getY(), 200, Configuration.MENU_ELEMENT_HEIGHT); // Reset the size of the (parent) panel
    }

    private void showPanel() { // Show the panel
        this.setVisible(true);
        this.title.setForeground(this.menuPanel.getShowColor());
        this.menuPanel.setBounds(this.menuPanel.getX(), this.menuPanel.getY(), 200, Configuration.MENU_ELEMENT_HEIGHT + 30 * elements.size()); // Set the size of the (parent) panel
    }


}
