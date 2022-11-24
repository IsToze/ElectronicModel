package com.toze.electronic;

import com.toze.electronic.api.Configuration;
import com.toze.electronic.api.components.IComponent;
import com.toze.electronic.api.components.IPosition;
import com.toze.electronic.api.controller.IElementController;
import com.toze.electronic.api.model.IElementModel;
import com.toze.electronic.components.BuildElement;
import com.toze.electronic.components.Component;
import com.toze.electronic.utils.LogType;
import com.toze.electronic.utils.Logger;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ElementModel implements IElementModel {

    private final List<IComponent> elements;
    private final IElementController elementController;

    protected ElementModel(IElementController elementController) {
        this.elements = new ArrayList<>();
        this.elementController = elementController;
    }

    @Override
    public List<IComponent> getElements() {
        return this.elements;
    }

    @Override
    public List<IComponent> getElementsByType(Class<? extends IComponent> type) {
        return this.elements.stream().filter(type::isInstance).collect(Collectors.toList());
    }

    @Override
    synchronized public void create(BuildElement buildElement) {

        buildElement.getFrom().divide(Configuration.GRID_SIZE);
        buildElement.getTo().divide(Configuration.GRID_SIZE);

        final IComponent component = buildElement.getComponent();
        final IPosition from = buildElement.getFrom();
        final IPosition to = buildElement.getTo();

        ((Component) component).setLocation(buildElement);

        Logger.log(LogType.INTERNAL, "Created a new component (" +
                buildElement.getComponent().getClass().getSimpleName() + ")" +
                " from " + from.getX() + ":" + from.getY()
                + " to " + to.getX() + ":" + to.getY());

        this.elements.add(component);
        this.elementController.removeCurrentBuild();
        ElectronicApplication.getInstance().getViewPanel().setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

    }

}
