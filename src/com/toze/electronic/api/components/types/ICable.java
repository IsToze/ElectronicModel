package com.toze.electronic.api.components.types;

import com.toze.electronic.api.components.ComponentType;
import com.toze.electronic.api.components.IComponent;

/**
 * @author Toze
 * @version 1.0
 * The cable is a simple element that does not change the voltage or the intensity of the electricity.
 */
public interface ICable extends IComponent {

    @Override
    default ComponentType getType() {
        return ComponentType.CABLE;
    }

}
