package com.toze.electronic.panels;

import javax.swing.border.Border;
import java.awt.*;

public class RoundedBorder implements Border {

    private final int radius;
    private final Color color;

    public RoundedBorder(int radius, Color color) {
        this.radius = radius;
        this.color = color == null ? Color.BLACK : color;
    }

    public RoundedBorder(int radius) {
        this(radius, null);
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        g.setColor(this.color);
        g.drawRoundRect(x, y, width - 1, height - 1, radius, radius);
    }

    @Override
    public Insets getBorderInsets(Component c) {
        return new Insets(this.radius + 1, this.radius + 1, this.radius + 2, this.radius);
    }

    @Override
    public boolean isBorderOpaque() {
        return false;
    }

    public Color getBorderColor() {
        return color;
    }

}
