package com.madlx.ui.screens;

import com.madlx.core.GameState;
import com.madlx.util.ImagesLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class LoadScreen extends JPanel implements BaseScreen {

    private static LoadScreen loadScreen;
    private BufferedImage img;
    private LoadingManager loading;

    private LoadScreen() {
        this.setPreferredSize(new Dimension(pWidth, pHeight));
        this.setFocusable(true);
        this.requestFocusInWindow();
        loading=new LoadingManager();
        img = ImagesLoader.getInstance().getImage("loadScreen.png");
        Timer t = new Timer(1000/10,e->{
            update();
            repaint();
        });
        t.start();
    }
    public static JPanel getInstance( ){
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
        loading.draw(g2);
    }
    public void update() {
        loading.update();
    }

    static class LoadingManager{
        private  int count =1;
        private  final int height=20;
        private   int blockWidth=0;
        private boolean isLoaded=false;
        private GameState gs;
        public LoadingManager(){

        }
        private void update(){
            if(blockWidth==200){
                isLoaded=true;
                if(isLoaded){
                    System.out.println("loaded");
                    gs=GameState.MENU;
                }
            }
            if(blockWidth<=200){
                System.out.println(blockWidth);
                blockWidth+=blockWidth+10;
            }
        }
        public void draw(Graphics2D g2){
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setRenderingHint(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY);
            g2.setColor(Color.WHITE);
            g2.fillRoundRect(pWidth/2-(pWidth/10), pHeight/2+(pHeight/4),blockWidth,height,20,20);
        }

    }
}
