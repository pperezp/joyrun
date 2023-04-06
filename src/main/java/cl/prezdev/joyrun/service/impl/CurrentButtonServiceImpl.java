package cl.prezdev.joyrun.service.impl;

import cl.prezdev.joyrun.model.Button;
import cl.prezdev.joyrun.service.CurrentButtonService;

public class CurrentButtonServiceImpl implements CurrentButtonService {

    private Button currentButton;
    private static CurrentButtonService instance;

    public static synchronized CurrentButtonService getInstance() {
        if (instance == null) {
            instance = new CurrentButtonServiceImpl();
        }
        return instance;
    }

    @Override
    public void setCurrentButton(Button button) {
        this.currentButton = button;
    }

    @Override
    public Button getCurrentButton() {
        return this.currentButton;
    }
}
