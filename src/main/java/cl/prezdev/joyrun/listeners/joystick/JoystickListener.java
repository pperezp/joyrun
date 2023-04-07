package cl.prezdev.joyrun.listeners.joystick;

import cl.prezdev.joyrun.listeners.joystick.JoystickPressButtonListener;

public interface JoystickListener {
    void start();

    void addJoystickButtonListener(JoystickPressButtonListener joystickPressButtonListener);
}
