package com.toze.electronic.components.types;

import com.toze.electronic.api.components.types.ICable;
import com.toze.electronic.components.BuildElement;
import com.toze.electronic.components.Component;

public class Cable extends Component implements ICable {

    private double intensity;
    private double voltage;

    public Cable() {
        super();
    }

    @Override
    public void setTensionInput(double tension) {
        this.voltage = tension;
    }

    @Override
    public void setIntensityInput(double intensity) {
        this.intensity = intensity;
    }

    @Override
    public double getTensionOutput() {
        return this.voltage;
    }

    @Override
    public double getIntensityOutput() {
        return this.intensity;
    }

}
