package org.example;

import net.java.games.input.Component;

import java.util.ArrayList;
import java.util.List;

public class ButtonListener {

    private Component component;
    private List<String> messages;

    public ButtonListener() {
        this.messages = new ArrayList<>();
    }

    public void add(String message) {
        messages.add(message);
    }

    public Component getComponent() {
        return component;
    }

    public void setComponent(Component component) {
        this.component = component;
    }

    public List<String> getMessages() {
        return messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }
}
