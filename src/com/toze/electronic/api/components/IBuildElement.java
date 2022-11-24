package com.toze.electronic.api.components;

import com.toze.electronic.api.view.Observer;

public interface IBuildElement extends Observer {

    /**
     * @return The element that is being built.
     */
    IComponent getComponent();

    /**
     * @return the starting position of the element.
     */
    IPosition getFrom();

    /**
     * @return if the BuildElement contains a starting position.
     */
    boolean hasFrom();

    /**
     * @return the ending position of the element
     */
    IPosition getTo();

}
