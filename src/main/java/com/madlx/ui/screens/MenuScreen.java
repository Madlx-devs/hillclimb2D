package com.madlx.ui.screens;

import com.madlx.core.GameState;
import com.madlx.util.ImagesLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class  MenuScreen extends JPanel implements BaseScreen{
    private static MenuScreen menuScreen;
    private static BufferedImage img;
    private MenuScreen() {
        this.setPreferredSize(new Dimension(pWidth, pHeight));
        this.setFocusable(true);
        this.requestFocusInWindow();
        img = ImagesLoader.getInstance().getImage("menuScreen.png");
        this.setLayout(new BoxLayout(this,BoxLayout.X_AXIS));
    }
    public static JPanel getInstance( ){
        if (menuScreen == null) {
            menuScreen=new MenuScreen();
        }
        return menuScreen;
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 =(Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY);
        g2.drawImage(img,0,0,pWidth,pHeight,null);
    }

    public void update() {
    }
}
