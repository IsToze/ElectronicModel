package com.toze.electronic;

import com.toze.electronic.api.components.IComponent;
import com.toze.electronic.api.model.IElementModel;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ElementModel implements IElementModel {

    private final List<IComponent> elements;

    public ElementModel(ElectronicApplication electronicApplication) {
        this.elements = new ArrayList<>();
    }

    @Override
    public List<IComponent> getElements() {
        return this.elements;
    }

    @Override
    public List<IComponent> getElementsByType(Class<? extends IComponent> type) {
        return this.elements.stream().filter(type::isInstance).collect(Collectors.toList());
    }

}
