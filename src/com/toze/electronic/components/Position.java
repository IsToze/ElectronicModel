package com.toze.electronic.components;

import com.toze.electronic.api.components.IPosition;

public class Position implements IPosition {

    private int x;
    private int y;

    protected Position() {
        this.x = -1;
        this.y = -1;
    }

    @Override
    public int getX() {
        return this.x;
    }

    @Override
    public void setX(int x) {
        this.x = x;
    }

    @Override
    public boolean hasX() {
        return this.x != 1;
    }

    @Override
    public int getY() {
        return this.y;
    }

    @Override
    public void setY(int y) {
        this.y = y;
    }

    @Override
    public boolean hasY() {
        return this.y != -1;
    }

}
