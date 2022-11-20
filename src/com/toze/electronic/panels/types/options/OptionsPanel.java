package com.toze.electronic.panels.types.options;

import com.toze.electronic.panels.menu.MenuElement;
import com.toze.electronic.panels.menu.MenuPanel;

import java.awt.*;
import java.util.Arrays;
import java.util.Collections;

public class OptionsPanel extends MenuPanel {

    public OptionsPanel() {

        super(200, 200, "Options", Color.RED, Color.YELLOW, Collections.singletonList(
                new MenuElement.MenuElementBuilder("Quit", Color.RED, (name) -> System.exit(0)).build()
        ));

    }

}
