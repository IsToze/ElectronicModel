package com.toze.electronic.panels.menu;

import java.awt.*;
import java.util.function.Consumer;

public interface MenuElement {

    String getName();

    Color getColor();

    void action();

    class MenuElementBuilder {

        private final String name;
        private final Color color;
        private final Consumer<String> action;

        public MenuElementBuilder(String name, Color color, Consumer<String> action) {
            this.name = name;
            this.color = color;
            this.action = action;
        }

        public MenuElement build() {

            return new MenuElement() {

                @Override
                public String getName() {
                    return name;
                }

                @Override
                public Color getColor() {
                    return color;
                }

                @Override
                public void action() {
                    action.accept(name);
                }

            };
        }

    }

}
