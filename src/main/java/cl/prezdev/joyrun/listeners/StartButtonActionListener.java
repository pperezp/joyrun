package cl.prezdev.joyrun.listeners;

import cl.prezdev.joyrun.listeners.joystick.impl.ExecuteCommandsJoystickListenerPress;
import cl.prezdev.joyrun.service.impl.JoystickListenerImpl;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartButtonActionListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        JButton button = (JButton) actionEvent.getSource();
        JoystickListenerImpl.getInstance().addJoystickButtonListener(new ExecuteCommandsJoystickListenerPress());
        button.setEnabled(false);
    }
}
