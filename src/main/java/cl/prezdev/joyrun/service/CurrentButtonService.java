package cl.prezdev.joyrun.service;

import cl.prezdev.joyrun.model.Button;

public interface CurrentButtonService {
    void setCurrentButton(Button component);

    Button getCurrentButton();
}
