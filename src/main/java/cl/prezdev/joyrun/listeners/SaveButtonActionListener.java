package cl.prezdev.joyrun.listeners;

import cl.prezdev.joyrun.model.Button;
import cl.prezdev.joyrun.service.impl.ButtonWithCommandsServiceImpl;
import cl.prezdev.joyrun.service.impl.CurrentButtonServiceImpl;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SaveButtonActionListener implements ActionListener {

    private final JTextField messageField;

    public SaveButtonActionListener(JTextField messageField) {
        this.messageField = messageField;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String message = messageField.getText();

        Button button = getCurrentButton();

        ButtonWithCommandsServiceImpl.getInstance().addButton(button, message);
        ButtonWithCommandsServiceImpl.getInstance().print();

        messageField.setText(null);
        messageField.requestFocus();
    }

    private Button getCurrentButton() {
        return CurrentButtonServiceImpl.getInstance().getCurrentButton();
    }
}
