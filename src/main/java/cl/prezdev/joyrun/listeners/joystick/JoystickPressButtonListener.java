package cl.prezdev.joyrun.listeners.joystick;

import cl.prezdev.joyrun.model.Button;

public interface JoystickPressButtonListener {
    void release(Button button);

    void down(Button button);
}
