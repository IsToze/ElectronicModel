package com.toze.electronic.panels.types.options;

import com.toze.electronic.panels.menu.MenuElement;
import com.toze.electronic.panels.menu.MenuPanel;

import java.awt.*;
import java.util.Collections;

public class OptionsViewPanel extends MenuPanel {

    public OptionsViewPanel() {

        super(50, 50, "Options", Collections.singletonList(
                new MenuElement.MenuElementBuilder("Quit", Color.RED, (name) -> System.exit(0)).build()
        ));

    }

}
