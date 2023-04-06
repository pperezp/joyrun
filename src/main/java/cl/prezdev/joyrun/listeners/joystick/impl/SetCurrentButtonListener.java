package cl.prezdev.joyrun.listeners.joystick.impl;

import cl.prezdev.joyrun.model.Button;
import cl.prezdev.joyrun.service.impl.CurrentButtonServiceImpl;
import cl.prezdev.joyrun.listeners.joystick.JoystickPressButtonListener;

public class SetCurrentButtonListener implements JoystickPressButtonListener {
    @Override
    public void release(Button button) {
        CurrentButtonServiceImpl.getInstance().setCurrentButton(button);
    }

    @Override
    public void down(Button button) {

    }
}
