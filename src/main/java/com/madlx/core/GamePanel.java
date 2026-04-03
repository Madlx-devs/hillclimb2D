package com.madlx.core;

import com.madlx.entities.Bike;
import com.madlx.ui.screens.BaseScreen;
import com.madlx.util.ImagesLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GamePanel  extends JPanel implements BaseScreen {
    private static  GamePanel gamePanel;
    private final BufferedImage img;
    private final Bike bike ;

    private GamePanel(){
        this.setPreferredSize(new Dimension(pWidth, pHeight));
        this.setFocusable(true);
        this.requestFocusInWindow();
        this.setDoubleBuffered(true);
        bike = new Bike();
        img= ImagesLoader.getInstance().getImage("gameScreen.png");
        Timer t = new Timer(40,e -> {
            update();
            repaint();
        });
        t.start();

    }

    public static JPanel getInstance(){
        if (gamePanel == null) {
            gamePanel=new GamePanel();
        }
        return gamePanel;
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.drawString(String.valueOf(img.getWidth()),100,100);
        g2.drawImage(img,0,0,pWidth,pHeight,null);
        bike.draw(g2);
    }

    public void update(){
        bike.update();
    }
}
