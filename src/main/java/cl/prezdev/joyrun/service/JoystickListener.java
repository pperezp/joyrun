package cl.prezdev.joyrun.service;

import cl.prezdev.joyrun.listeners.joystick.JoystickPressButtonListener;

public interface JoystickListener {
    void start();

    void addJoystickButtonListener(JoystickPressButtonListener joystickPressButtonListener);
}
