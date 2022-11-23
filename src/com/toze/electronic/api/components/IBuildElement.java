package com.toze.electronic.api.components;

public interface IBuildElement {

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
