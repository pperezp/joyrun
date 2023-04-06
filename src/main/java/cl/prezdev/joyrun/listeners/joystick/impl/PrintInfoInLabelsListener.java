package cl.prezdev.joyrun.listeners.joystick.impl;

import cl.prezdev.joyrun.GuiApp;
import cl.prezdev.joyrun.model.Button;
import cl.prezdev.joyrun.listeners.joystick.JoystickPressButtonListener;
import net.java.games.input.Component;
import net.java.games.input.Controller;

import javax.swing.*;

public class PrintInfoInLabelsListener implements JoystickPressButtonListener {

    private final JLabel buttonLabel;
    private final JLabel controllerLabel;

    public PrintInfoInLabelsListener(GuiApp guiApp) {
        this.buttonLabel = guiApp.getButtonLabel();
        this.controllerLabel = guiApp.getControllerLabel();
    }

    @Override
    public void release(Button button) {

    }

    @Override
    public void down(Button button) {
        Controller controller = button.getController();
        Component component = button.getButton();

        controllerLabel.setText(controller.getName());
        buttonLabel.setText(component.getName());
    }
}
