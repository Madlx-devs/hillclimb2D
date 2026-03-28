package com.madlx.ui;

import com.madlx.core.GamePanel;
import com.madlx.core.GameState;

import javax.swing.*;

public class UiManager {
    private final JFrame window;
    private JPanel activeWindow=null;
    public UiManager(JFrame window){
        this.window=window;
    }
    public JPanel getActiveWindow(){
        return this.activeWindow;
    }

    public void updateUI(GameState state) {
        switch (state) {
            case START_SCREEN:
               loadUi(new StartScreen());
                break;
            case MENU:
                loadUi(new MenuScreen());
                break;
            case GAME:
                loadUi(new GamePanel());
                System.out.println("game");
              break;

            case PAUSED:
                System.out.println("Paused Screen");
                break;

            case GAME_OVER:
                System.out.println("Game Over Screen");
                break;
            default:
        }
    }
    private void loadUi(JPanel gp){
        activeWindow=gp;
        window.add(gp);
        window.revalidate();
        window.pack();

    }
}
