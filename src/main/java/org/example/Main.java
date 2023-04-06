package org.example;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        GuiApp jFrame = new GuiApp();

        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setSize(800, 600);
        jFrame.setLocationRelativeTo(null);

        jFrame.setVisible(true);
    }
}