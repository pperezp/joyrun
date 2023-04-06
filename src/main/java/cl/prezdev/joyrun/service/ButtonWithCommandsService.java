package cl.prezdev.joyrun.service;

import cl.prezdev.joyrun.model.Button;

public interface ButtonWithCommandsService {
    void addButton(Button button, String text);

    void print();

    void executeCommands(Button button);
}
