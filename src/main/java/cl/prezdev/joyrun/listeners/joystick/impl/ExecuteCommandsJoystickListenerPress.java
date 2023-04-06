package cl.prezdev.joyrun.listeners.joystick.impl;

import cl.prezdev.joyrun.model.Button;
import cl.prezdev.joyrun.service.impl.ButtonWithCommandsServiceImpl;
import cl.prezdev.joyrun.listeners.joystick.JoystickPressButtonListener;

public class ExecuteCommandsJoystickListenerPress implements JoystickPressButtonListener {
    @Override
    public void release(Button button) {

    }

    @Override
    public void down(Button button) {
        ButtonWithCommandsServiceImpl.getInstance().executeCommands(button);
    }
}
