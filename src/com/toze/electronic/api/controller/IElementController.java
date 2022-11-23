package com.toze.electronic.api.controller;

import com.toze.electronic.api.components.IBuildElement;
import com.toze.electronic.api.components.IComponent;

/**
 * @author Toze
 * @version 1.0
 */
public interface IElementController {

    IBuildElement getCurrentBuild();

    void setBuild(Class<? extends IComponent> component);

}
