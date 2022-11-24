package com.toze.electronic.api.components;

import com.toze.electronic.api.components.IComponent;
import com.toze.electronic.api.components.types.ICable;
import com.toze.electronic.components.types.Cable;

public enum ComponentType {

    CABLE("Cable", ICable.class);

    private final String name;
    private final Class<? extends IComponent> type;

    ComponentType(String name, Class<? extends IComponent> type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public Class<? extends IComponent> getType() {
        return type;
    }

}
