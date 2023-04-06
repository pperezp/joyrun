package org.example;

import net.java.games.input.*;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class GuiApp extends JFrame {

    private JPanel mainPanel;
    private JLabel controllerLabel;
    private JLabel buttonLabel;
    private JTextField messageField;
    private JButton saveButton;
    private Component currentComponent;
    private final List<ButtonListener> listeners;

    public GuiApp() {
        this.add(mainPanel);
        thread();

        listeners = new ArrayList<>();

        this.controllerLabel.setText(null);
        this.buttonLabel.setText(null);

        saveButton.addActionListener(e -> {
            String message = messageField.getText();

            ButtonListener buttonListener = getButtonListener();

            if (buttonListener == null) {
                buttonListener = new ButtonListener();
                buttonListener.setComponent(currentComponent);
                listeners.add(buttonListener);
            }

            buttonListener.add(message);

            messageField.setText(null);

            print();
        });
    }

    private void print() {
        listeners.forEach(buttonListener -> {
            System.out.println(buttonListener.getComponent().getName() + " -> " + buttonListener.getMessages());
        });
    }

    private ButtonListener getButtonListener() {
        for (ButtonListener buttonListener : listeners) {
            if (buttonListener.getComponent().getName().equals(currentComponent.getName())) {
                return buttonListener;
            }
        }

        return null;
    }

    public void thread() {
        new Thread(() -> {
            while (true) {
                Controller[] controllers = ControllerEnvironment.getDefaultEnvironment().getControllers();

                if (controllers.length == 0) {
                    System.out.println("Found no controllers.");
                    System.exit(0);
                }

                for (Controller controller : controllers) {
                    controller.poll();

                    EventQueue eventQueue = controller.getEventQueue();

                    Event event = new Event();

                    while (eventQueue.getNextEvent(event)) {
                        controllerLabel.setText(controller.getName());
                        currentComponent = event.getComponent();
                        buttonLabel.setText(currentComponent.getName());
                        float value = event.getValue();

                        if (value == 0) {
                            System.out.println(currentComponent.getName() + " liberado!");
                        }
                        /*
                        if (currentComponent.isAnalog()) {
                            System.out.println("Analogo: " + value);
                        } else {
                            if (value == 1.0f) {
                                System.out.println("Presionado...");
                            } else {
                                System.out.println("Liberado...");
                            }
                        }
                         */
                    }
                }

                try {
                    Thread.sleep(20);
                } catch (InterruptedException asd) {
                    asd.printStackTrace();
                }
            }
        }).start();
    }
}
