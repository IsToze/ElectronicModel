package com.toze.electronic.panels.menu;

import com.toze.electronic.Configuration;
import com.toze.electronic.panels.RoundedBorder;

import javax.swing.*;
import java.awt.*;

public class MenuButton extends JPanel {

    protected MenuButton(MenuPanel menuPanel) {

        super();

        final JLabel title = menuPanel.getTitle();

        this.setBounds(0, 0, 200, Configuration.MENU_ELEMENT_HEIGHT);
        this.setBackground(new Color(5, 10, 40));
        this.setBorder(new RoundedBorder(20, new Color(10, 69, 91)));
        this.setLayout(null);
        this.add(title);

        title.setBounds(0, 0, 200, Configuration.MENU_ELEMENT_HEIGHT);
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setVerticalAlignment(SwingConstants.CENTER);

        this.setVisible(true);

    }

}
