package com.toze.electronic;

import com.sun.istack.internal.NotNull;
import com.toze.electronic.api.components.ComponentType;
import com.toze.electronic.api.components.IBuildElement;
import com.toze.electronic.api.components.IComponent;
import com.toze.electronic.api.controller.IElementController;
import com.toze.electronic.api.model.IElementModel;
import com.toze.electronic.api.view.IElementView;
import com.toze.electronic.components.BuildElement;
import com.toze.electronic.components.types.Cable;
import com.toze.electronic.utils.LogType;
import com.toze.electronic.utils.Logger;

import java.awt.*;

public class ElementController implements IElementController {

    private BuildElement buildElement;

    protected ElementController() {
        this.buildElement = null;
    }

    @Override
    public IBuildElement getCurrentBuild() {
        return this.buildElement;
    }

    @Override
    public void setBuild(@NotNull ComponentType component) {
        Logger.log(LogType.INTERNAL, "Setting build to " + component.getName());
        ElectronicApplication.getInstance().getViewPanel().setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
        this.buildElement = new BuildElement(this.createComponent(component));
        ElectronicApplication.getInstance().getElementView().addObserver(this.buildElement);
    }

    @Override
    public void removeCurrentBuild() {
        this.buildElement = null;
    }

    private IComponent createComponent(ComponentType type) {

        final Class<? extends IComponent> finalType;

        switch (type) {
            case CABLE:
                finalType = Cable.class;
                break;
            default:
                finalType = null;
                break;
        }

        try {
            return finalType.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }


}
