package com.toze.electronic.api.components;

public class Setup {

    private final SetupType type;
    private final int size;

    public Setup(SetupType type, int size) {
        this.type = type;
        this.size = size;
    }

    public Setup(SetupType type) {
        this(type, -1);
    }

    public SetupType getType() {
        return type;
    }

    public int getSize() {
        return size;
    }

}
