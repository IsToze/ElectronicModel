package com.toze.electronic;

import com.toze.electronic.api.Configuration;
import com.toze.electronic.api.controller.IElementController;
import com.toze.electronic.api.model.IElementModel;
import com.toze.electronic.api.view.IElementView;
import com.toze.electronic.panels.types.base.BaseViewPanel;
import com.toze.electronic.panels.types.component.ComponentViewPanel;
import com.toze.electronic.panels.types.options.OptionsViewPanel;
import com.toze.electronic.utils.LogType;
import com.toze.electronic.utils.Logger;
import com.toze.electronic.utils.RapidityCheck;

import javax.swing.*;

public class ElectronicApplication {

    private static ElectronicApplication instance;
    private final Logger logger = new Logger();
    private final BaseViewPanel baseView;
    private final ElementView elementView;
    private final IElementModel elementModel;
    private final IElementController elementController;

    private ElectronicApplication() {

        RapidityCheck.register("startup");
        Logger.log(LogType.INTERNAL, "Startup..");
        Logger.log(LogType.INTERNAL, "Creating a empty frame");

        final JFrame frame = getMainFrame();

        this.baseView = new BaseViewPanel(frame);
        this.elementController = new ElementController();
        this.elementModel = new ElementModel(this.elementController);
        this.elementView = new ElementView(frame, this.elementModel, this.elementController);

        this.addViews(frame);
        frame.setVisible(true);

        RapidityCheck.checkLog("Startup", "startup");

    }

    public static ElectronicApplication getInstance() {

        if (instance == null)
            instance = new ElectronicApplication();

        return instance;

    }

    private JFrame getMainFrame() {
        final JFrame frame = new JFrame("Electronic");
        frame.setSize(Configuration.FRAME_WIDTH, Configuration.FRAME_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        return frame;
    }

    private void addViews(JFrame frame) {

        frame.add(baseView);

        baseView.add(new OptionsViewPanel());
        baseView.add(new ComponentViewPanel());
        baseView.add(elementView);

    }

    public Logger getLogger() {
        return logger;
    }

    public BaseViewPanel getViewPanel() {
        return baseView;
    }

    public IElementView getElementView() {
        return elementView;
    }

    public IElementController getElementController() {
        return elementController;
    }

    public IElementModel getElementModel() {
        return elementModel;
    }

}
