package com.toze.electronic;

import com.sun.istack.internal.NotNull;
import com.toze.electronic.api.components.IBuildElement;
import com.toze.electronic.api.components.IComponent;
import com.toze.electronic.api.controller.IElementController;
import com.toze.electronic.api.model.IElementModel;
import com.toze.electronic.api.view.IElementView;
import com.toze.electronic.components.BuildElement;
import com.toze.electronic.utils.LogType;
import com.toze.electronic.utils.Logger;

import java.awt.*;

public class ElementController implements IElementController {

    private final ElectronicApplication electronicApplication;
    private final IElementModel elementModel;
    private final IElementView elementView;

    private BuildElement buildElement;

    public ElementController(ElectronicApplication electronicApplication, IElementModel elementModel,
                             IElementView elementView) {
        this.electronicApplication = electronicApplication;
        this.elementModel = elementModel;
        this.elementView = elementView;
    }

    @Override
    public IBuildElement getCurrentBuild() {
        return null;
    }

    @Override
    public void setBuild(@NotNull Class<? extends IComponent> component) {
        Logger.log(LogType.INTERNAL, "Setting build to " + component.getSimpleName());
        this.electronicApplication.getView().setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
        this.buildElement = new BuildElement(this.createComponent(component));
        this.elementView.addObserver(this.buildElement);
    }

    private IComponent createComponent(Class<? extends IComponent> component) {
        try {
            return component.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }


}
