package com.toze.electronic.api.controller;

import com.toze.electronic.api.components.ComponentType;
import com.toze.electronic.api.components.IBuildElement;
import com.toze.electronic.api.components.IComponent;

/**
 * @author Toze
 * @version 1.0
 */
public interface IElementController {

    /**
     * @return the current build element.
     */
    IBuildElement getCurrentBuild();

    /**
     * Create a new build element.
     * @param component : the component type to build.
     */
    void setBuild(ComponentType component);

    /**
     * Remove the current build element.
     */
    void removeCurrentBuild();

}
