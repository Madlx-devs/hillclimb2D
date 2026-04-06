package com.madlx.ui;

import com.madlx.App;
import com.madlx.core.GamePanel;
import com.madlx.core.GameState;
import com.madlx.ui.screens.LoadScreen;
import com.madlx.ui.screens.MenuScreen;

import javax.swing.*;


public class UiManager {
    private static  UiManager uiManager;
    private UiManager(){

    }
    public static JPanel UpdateUI(GameState gameState){
        switch (gameState){
            case MENU:
               return MenuScreen.getInstance();
            case PAUSED:
                break;
            case PLAYING:
                return GamePanel.getInstance();
            case FINISHED:
                System.out.println("game finished");
                break;
            default:
                return LoadScreen.getInstance();
        }
        return null;
    }
}
