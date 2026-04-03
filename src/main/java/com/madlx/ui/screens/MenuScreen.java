package com.madlx.ui.screens;

import javax.swing.*;
import java.awt.*;

public class MenuScreen extends JPanel implements BaseScreen{
    private static MenuScreen menuScreen;
    private MenuScreen() {
        this.setPreferredSize(new Dimension(pWidth, pHeight));
        this.setFocusable(true);
        this.requestFocusInWindow();
    }
    public static JPanel getInstance(){
        if (menuScreen == null) {
            menuScreen=new MenuScreen();
        }
        return menuScreen;
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 =(Graphics2D)g;
    }
    public void update() {
    }
}
