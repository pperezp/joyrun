package cl.prezdev.joyrun.service.impl;

import cl.prezdev.joyrun.model.Button;
import cl.prezdev.joyrun.model.ButtonWithCommands;
import cl.prezdev.joyrun.model.ButtonDoNotExistException;
import cl.prezdev.joyrun.service.ButtonWithCommandsService;

import java.util.ArrayList;
import java.util.List;

public class ButtonWithCommandsServiceImpl implements ButtonWithCommandsService {

    private static ButtonWithCommandsService instance;
    private final List<ButtonWithCommands> buttonsWithCommands;

    private ButtonWithCommandsServiceImpl() {
        buttonsWithCommands = new ArrayList<>();
    }

    public static synchronized ButtonWithCommandsService getInstance() {
        if (instance == null) {
            instance = new ButtonWithCommandsServiceImpl();
        }
        return instance;
    }

    @Override
    public void addButton(Button button, String message) {
        try {
            ButtonWithCommands buttonWithCommands = getButtonWithCommands(button);
            buttonWithCommands.add(message);
        } catch (ButtonDoNotExistException e) {
            ButtonWithCommands buttonWithCommands = new ButtonWithCommands(button, message);
            buttonsWithCommands.add(buttonWithCommands);
        }
    }

    @Override
    public void print() {
        buttonsWithCommands.forEach(buttonWithCommands ->
                System.out.println(buttonWithCommands.print() + " -> " + buttonWithCommands.getMessages()));
    }

    @Override
    public void executeCommands(Button button) {
        try {
            ButtonWithCommands buttonWithCommands = this.getButtonWithCommands(button);
            System.out.println(buttonWithCommands.getMessages());
        } catch (ButtonDoNotExistException e) {
            System.out.println(button + " no mapped");
        }
    }

    private ButtonWithCommands getButtonWithCommands(Button button) throws ButtonDoNotExistException {
        return buttonsWithCommands.stream()
                .filter(bwc -> bwc.equalsTo(button))
                .findFirst()
                .orElseThrow(ButtonDoNotExistException::new);
    }

}

