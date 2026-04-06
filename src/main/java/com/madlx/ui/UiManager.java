package com.madlx.ui;

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
                 return MenuScreen.getInstance(gameState);
            case LOADING:
                return LoadScreen.getInstance(gameState);
            case PAUSED:
                break;
            case PLAYING:
                return GamePanel.getInstance();
            case FINISHED:
                break;
            default:
                return null;
        }
        return null;
    }
    public static UiManager getInstance(){
        if (uiManager == null) {
            uiManager=new UiManager();
        }
        return uiManager;
    }

}
