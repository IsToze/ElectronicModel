package com.toze.electronic.components;

import com.toze.electronic.api.components.IBuildElement;
import com.toze.electronic.api.components.IComponent;
import com.toze.electronic.api.components.IPosition;
import com.toze.electronic.api.view.Observer;
import com.toze.electronic.utils.LogType;
import com.toze.electronic.utils.Logger;

import java.awt.event.MouseEvent;

public class BuildElement implements IBuildElement, Observer {

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
        return null;
    }

    @Override
    public void onClick(MouseEvent event) {

        Logger.log(LogType.INTERNAL, "Clicking at " + event.getX() + ", " + event.getY());

    }

}
