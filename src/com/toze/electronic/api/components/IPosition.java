package com.toze.electronic.api.components;

public interface IPosition {

    /**
     * @return the x coordinate
     */
    int getX();

    /**
     * Define the x coordinate
     */
    void setX(int x);

    /**
     * @return if the position has an x coordinate
     */
    boolean hasX();

    /**
     * @return the y coordinate
     */
    int getY();

    /**
     * Define the y coordinate
     */
    void setY(int y);

    /**
     * @return if the position has a y coordinate
     */
    boolean hasY();

    /**
     * divide the x and y coordinates by the parameter
     */
    void divide(int gridSize);

}
