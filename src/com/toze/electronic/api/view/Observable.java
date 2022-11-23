package com.toze.electronic.api.view;

import java.awt.event.MouseEvent;

public interface Observable {

    void addObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyClick(MouseEvent event);

}
