package cl.prezdev.joyrun.model;


import java.util.ArrayList;
import java.util.List;

public class ButtonWithCommands extends Button {

    private List<String> messages;

    public ButtonWithCommands(Button button, String message) {
        super(button);
        this.messages = new ArrayList<>();
        this.messages.add(message);
    }

    public void add(String message) {
        messages.add(message);
    }

    public List<String> getMessages() {
        return messages;
    }

    public boolean equalsTo(Button button) {
        return this.getController().getName().equals(button.getController().getName()) &&
                this.getButton().getName().equals(button.getButton().getName());
    }
}
