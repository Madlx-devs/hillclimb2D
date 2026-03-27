package com.madlx.ui;

import com.madlx.assets.resources.ImageLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;


public class MenuScreen extends JPanel implements BaseUi{
    private final BufferedImage image;

    public MenuScreen(){
        this.setPreferredSize(new Dimension(pWidth,pHeight));
        this.requestFocusInWindow();
        this.setDoubleBuffered(true);
        this.setBackground(Color.BLACK);
        image = ImageLoader.loadImage("menuScreen.png");
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(new Color(2,52,118));
        g2.drawImage(image,0,0,pWidth,pHeight,null);
    }

}
