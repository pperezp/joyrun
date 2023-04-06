package cl.prezdev.joyrun.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import net.java.games.input.Component;
import net.java.games.input.Controller;

import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Button {

    private Controller controller;
    private Component button;
    private float value;

    public Button(Button button) {
        this.controller = button.getController();
        this.button = button.getButton();
        this.value = button.getValue();
    }

    public String print() {
        return controller.getName() + " - " + button.getName();
    }
}
