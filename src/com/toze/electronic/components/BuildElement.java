package com.toze.electronic.components;

import com.toze.electronic.ElectronicApplication;
import com.toze.electronic.api.Configuration;
import com.toze.electronic.api.components.IBuildElement;
import com.toze.electronic.api.components.IComponent;
import com.toze.electronic.api.components.IPosition;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import java.util.List;

public class BuildElement implements IBuildElement {

    private final IComponent component;
    private final IPosition from;
    private final IPosition to;

    public BuildElement(IComponent component) {
        this.component = component;
        this.from = new Position();
        this.to = new Position();
    }

    @Override
    public IComponent getComponent() {
        return this.component;
    }

    @Override
    public IPosition getFrom() {
        return this.from;
    }

    @Override
    public boolean hasFrom() {
        return this.from.hasX() && this.from.hasY();
    }

    @Override
    public IPosition getTo() {
        return this.to;
    }

    @Override
    public void onClick(MouseEvent event) {

        final int x = event.getX();
        final int y = event.getY();
        final Point point = this.getCorners(x, y).stream()
                .filter(i -> i.distance(x, y) <= Configuration.GRID_SIZE / 5.0).findFirst().orElse(null); // 1/5 = distance max to the corner

        if (point == null)
            return;

        if (!this.hasFrom()) {
            this.from.setX(point.x);
            this.from.setY(point.y);
            return;
        }

        if (this.from.getX() == point.x && this.from.getY() == point.y)
            return;

        this.to.setX(point.x);
        this.to.setY(point.y);

        ElectronicApplication.getInstance().getElementModel().create(this);

        ElectronicApplication.getInstance().getElementView().removeObserver(this);

    }

    private List<Point> getCorners(int x, int y) {

        final int gridSize = Configuration.GRID_SIZE;

        final int xMod = x % gridSize;
        final int yMod = y % gridSize;

        x = x - xMod;
        y = y - yMod;

        return Arrays.asList(
                new Point(x, y),
                new Point(x, y + gridSize),
                new Point(x + gridSize, y),
                new Point(x + gridSize, y + gridSize)
        );

    }

}
