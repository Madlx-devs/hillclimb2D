package com.madlx.ui.screens;

import com.madlx.util.ImagesLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class LoadScreen extends JPanel implements BaseScreen {

    private static LoadScreen loadScreen;
    private BufferedImage img;
    private LoadScreen() {
        this.setPreferredSize(new Dimension(pWidth, pHeight));
        this.setFocusable(true);
        this.requestFocusInWindow();
        img = ImagesLoader.getInstance().getImage("loadScreen.png");
    }
    public static JPanel getInstance(){
        if (loadScreen == null) {
            loadScreen=new LoadScreen();
        }
        return loadScreen;
        }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 =(Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY);
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION ,RenderingHints.VALUE_INTERPOLATION_BICUBIC);
        g2.drawImage(img,0,0,pWidth,pHeight,null);
    }
    public void update() {
    }
}
