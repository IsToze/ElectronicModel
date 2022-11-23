package com.toze.electronic.components.types;

import com.toze.electronic.api.components.Setup;
import com.toze.electronic.api.components.SetupType;
import com.toze.electronic.api.components.types.ICable;

public class Cable implements ICable {

    private double intensity;
    private double voltage;

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

    @Override
    public Setup getSetup() {
        return new Setup(SetupType.LINE);
    }

}
