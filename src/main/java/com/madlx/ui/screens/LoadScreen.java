package com.madlx.ui.screens;

import com.madlx.core.GameManager;
import com.madlx.core.GameState;
import com.madlx.ui.UiManager;
import com.madlx.util.ImagesLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class LoadScreen extends JPanel implements BaseScreen {

    private static LoadScreen loadScreen;
    private final BufferedImage img;
    private final LoadingManager loading;


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
        private  final int height=20;
        private   int blockWidth=0;

        public LoadingManager( ){
        }
        private void update(){

            if(blockWidth!=200){
                blockWidth+=10;
            }
            if(blockWidth==200){
                boolean isLoaded = true;
                GameManager.SetGameState(GameState.MENU);
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
