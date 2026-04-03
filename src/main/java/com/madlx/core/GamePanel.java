package com.madlx.core;

import com.madlx.ui.screens.BaseScreen;

import javax.swing.*;
import java.awt.*;

public class GamePanel  extends JPanel implements BaseScreen {
    private static  GamePanel gamePanel;

    private GamePanel(){
        this.setPreferredSize(new Dimension(pWidth, pHeight));
        this.setFocusable(true);
        this.requestFocusInWindow();
        this.setDoubleBuffered(true);
        this.setBackground(Color.BLACK);
    }

    public static JPanel getInstance(){
        if (gamePanel == null) {
            gamePanel=new GamePanel();
        }
        return gamePanel;
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
    }

    public void update(){
    }
}
