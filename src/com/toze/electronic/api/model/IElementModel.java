package com.toze.electronic.api.model;

import com.toze.electronic.api.components.IComponent;

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

}
