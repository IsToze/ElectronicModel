package com.toze.electronic.api.model;

import com.sun.istack.internal.NotNull;
import com.toze.electronic.api.components.IComponent;
import com.toze.electronic.api.components.IPosition;
import com.toze.electronic.components.BuildElement;

import java.util.List;

/**
 * @author Toze
 * @version 1.0
 */
public interface IElementModel {

    /**
     * @return all the elements of the view.
     */
    List<IComponent> getElements();

    /**
     * @param type : the type of the elements to return.
     * @return all the elements of the view that are of the type.
     */
    List<IComponent> getElementsByType(Class<? extends IComponent> type);

    /**
     * Create a new element.
     * @param buildElement : the build element with information likes coordinates or their type.
     */
    void create(@NotNull BuildElement buildElement);

}
