package cl.prezdev.joyrun.service.impl;

import cl.prezdev.joyrun.model.Button;
import cl.prezdev.joyrun.listeners.joystick.JoystickPressButtonListener;
import cl.prezdev.joyrun.service.JoystickListener;
import lombok.SneakyThrows;
import net.java.games.input.*;

import java.util.ArrayList;
import java.util.List;

public class JoystickListenerImpl implements JoystickListener, Runnable {

    private static JoystickListener instance;

    private List<JoystickPressButtonListener> joystickPressButtonListeners;

    public static synchronized JoystickListener getInstance() {
        if (instance == null) {
            instance = new JoystickListenerImpl();
        }
        return instance;
    }

    @Override
    public void start() {
        this.joystickPressButtonListeners = new ArrayList<>();
        new Thread(this).start();
    }

    @Override
    public void addJoystickButtonListener(JoystickPressButtonListener joystickPressButtonListener) {
        this.joystickPressButtonListeners.add(joystickPressButtonListener);
    }

    @Override
    @SneakyThrows
    public void run() {
        while (true) {
            ControllerEnvironment defaultEnvironment = ControllerEnvironment.getDefaultEnvironment();
            Controller[] controllers = defaultEnvironment.getControllers();

            if (controllers.length == 0) {
                System.out.println("Found no controllers.");
                System.exit(0);
            }

            for (Controller controller : controllers) {
                controller.poll();

                EventQueue eventQueue = controller.getEventQueue();
                Event event = new Event();

                while (eventQueue.getNextEvent(event)) {
                    Component component = event.getComponent();

                    float value = event.getValue();

                    Button button = new Button(controller, component, value);

                    if (value == 0) {
                        notifyButtonRelease(button);
                    } else {
                        notifyButtonDown(button);
                    }
                }
            }

            Thread.sleep(20);
        }
    }

    private void notifyButtonRelease(Button button) {
        joystickPressButtonListeners.forEach(
                joystickPressButtonListener -> joystickPressButtonListener.release(button)
        );
    }

    private void notifyButtonDown(Button button) {
        joystickPressButtonListeners.forEach(
                joystickPressButtonListener -> joystickPressButtonListener.down(button)
        );
    }
}
