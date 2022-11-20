package com.toze.electronic;

import com.toze.electronic.panels.types.base.BasePanel;
import com.toze.electronic.panels.types.options.OptionsPanel;

import javax.swing.*;

public class ElectronicAPP {

    public ElectronicAPP() {

        final JFrame frame = new JFrame("Electronic");
        final JPanel basePanel = new BasePanel(frame);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 800);
        frame.setLocationRelativeTo(null);
        frame.add(basePanel);

        basePanel.add(new OptionsPanel());
        frame.setVisible(true);

    }

}
