package com.madlx.ui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

import java.util.Objects;


public class StartScreen extends JPanel {
    private final int pWidth=1080;
    private final int pHeight=560;
    private  BufferedImage image;



    public StartScreen(){
        loadImage();
        this.setPreferredSize(new Dimension(pWidth,pHeight));
        this.requestFocusInWindow();
        this.setDoubleBuffered(true);

    }
     void loadImage(){
      try{
        image=  ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/images/LoadScreen.png")));
      } catch (IOException e) {
          throw new RuntimeException(e);
      }
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
      static class Loader{
        private static int x=520;
        private static int initialY=420;
        private static final int blockSize =20;
        private static int progress =0;
        private static int maxBlock=10;

       static void draw(Graphics2D g2){
          g2.setColor(Color.white);
         for(int i =0;i<=progress;i++){
             g2.fillRect(x,initialY,blockSize,20);
             g2.dispose();
         }

        }
        static void update(){
            x+=blockSize;
            if(progress<maxBlock){
                progress++;
            }
        }
    }
}
