package com.toze.electronic.panels.types.component;

import com.toze.electronic.components.types.Cable;
import com.toze.electronic.panels.menu.MenuElement;
import com.toze.electronic.panels.menu.MenuPanel;

import java.awt.*;
import java.util.Arrays;

public class ComponentViewPanel extends MenuPanel {

    public ComponentViewPanel() {
        super(50, 200, "Components", Arrays.asList(
                new MenuElement.MenuElementBuilder("Cable", Color.YELLOW,
                        (app) -> app.getElementController().setBuild(Cable.class)).build()
        ));
    }


}
