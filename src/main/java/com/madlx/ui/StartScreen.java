package com.madlx.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;


import static com.madlx.assets.resources.ImageLoader.loadImage;


public class StartScreen extends JPanel {
    private final int pWidth=1080;
    private final int pHeight=560;
    private  BufferedImage image;
    public StartScreen(){
        image= loadImage("loadScreen.png");
        this.setPreferredSize(new Dimension(pWidth,pHeight));
        this.requestFocusInWindow();
        this.setDoubleBuffered(true);
        Timer timer= new Timer(100,e -> {
            repaint();
            update();
            if (Loader.progressBlock >= 12) {
                ((Timer)e.getSource()).stop();
            }
        });
        timer.start();

    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.drawImage(image,0,0,pWidth,pHeight,null);
        Loader.draw(g2);
    }

    public void update(){
        Loader.update();
    }
    static class Loader {
        private static int x = 400;
        private static int y = 420;

        private static final int width = 20;
        private static final int height = 20;
        private static int progressBlock = 0;
        private volatile  static boolean isLoaded=false;
        static void draw(Graphics2D g2) {
            g2.setColor(Color.white);
            g2.fillRoundRect(x,y,width*progressBlock,height,20,20);
        }

        static void update() {
            if(progressBlock<12)
                progressBlock++;
            else{
                isLoaded=true;
            }
        }
    }
}
