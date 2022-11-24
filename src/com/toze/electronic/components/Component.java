package com.toze.electronic.components;

import com.toze.electronic.api.components.IComponent;
import com.toze.electronic.api.components.IPosition;

public abstract class Component implements IComponent {

    private final IPosition from;
    private final IPosition to;

    public Component() {
        this.from = new Position();
        this.to = new Position();
    }

    public IPosition getFrom() {
        return from;
    }

    public IPosition getTo() {
        return to;
    }

    public void setLocation(BuildElement buildElement) {
        this.from.setX(buildElement.getFrom().getX());
        this.from.setY(buildElement.getFrom().getY());
        this.to.setX(buildElement.getTo().getX());
        this.to.setY(buildElement.getTo().getY());
    }

}
