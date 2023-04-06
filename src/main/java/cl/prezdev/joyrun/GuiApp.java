package cl.prezdev.joyrun;

import cl.prezdev.joyrun.listeners.joystick.impl.PrintInfoInLabelsListener;
import cl.prezdev.joyrun.listeners.SaveButtonActionListener;
import cl.prezdev.joyrun.listeners.joystick.impl.SetCurrentButtonListener;
import cl.prezdev.joyrun.listeners.StartButtonActionListener;
import cl.prezdev.joyrun.service.impl.JoystickListenerImpl;
import lombok.Getter;

import javax.swing.*;

@Getter
public class GuiApp extends JFrame {

    private JPanel mainPanel;
    private JLabel controllerLabel;
    private JLabel buttonLabel;
    private JTextField messageField;
    private JButton saveButton;
    private JButton startButton;

    public GuiApp() {
        this.add(mainPanel);
        init();
        initButtonListeners();
        initJoystickListeners();
    }

    private void init() {
        this.controllerLabel.setText(null);
        this.buttonLabel.setText(null);
    }

    private void initButtonListeners() {
        saveButton.addActionListener(new SaveButtonActionListener(messageField));
        startButton.addActionListener(new StartButtonActionListener());
    }

    private void initJoystickListeners() {
        JoystickListenerImpl.getInstance().start();
        JoystickListenerImpl.getInstance().addJoystickButtonListener(new PrintInfoInLabelsListener(this));
        JoystickListenerImpl.getInstance().addJoystickButtonListener(new SetCurrentButtonListener());
    }
}
