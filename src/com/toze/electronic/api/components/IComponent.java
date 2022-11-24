package com.toze.electronic.api.components;

/**
 * @author Toze
 * @version 1.0
 */
public interface IComponent {

    /**
     * @return the position of the component.
     */
    ComponentType getType();

    /**
     * Define the tension in input of the component.
     */
    void setTensionInput(double tension);

    /**
     * Define the intensity in input of the component.
     */
    void setIntensityInput(double intensity);

    /**
     * @return component input current.
     */
    double getTensionOutput();

    /**
     * @return component output current.
     */
    double getIntensityOutput();

}
