package com.madlx.ui.buttons;

import javax.swing.*;
import java.awt.*;

public class CustomButtonCreator {
    private static CustomButtonCreator buttonCreator;
    private CustomButtonCreator(){

    }

    public JButton createButton(String text){
        JButton button = new JButton(text);
        button.setFocusable(false);
        button.setForeground(Color.WHITE);
        button.setBackground(Color.YELLOW);
        button.setText(text);
        button.setSize(300,300);
        return button;
    }

    public static CustomButtonCreator getInstance() {
        if (buttonCreator == null) {
            buttonCreator=new CustomButtonCreator();
        }
        return buttonCreator;
    }

}
