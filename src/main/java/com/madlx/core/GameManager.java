package com.madlx.core;

import com.madlx.ui.UiManager;

import javax.swing.*;

public class GameManager {
    private static  GameManager gameManager=null;
    private final GameState gameState;
    private final UiManager uiManager;

    public GameManager(){
        uiManager=UiManager.getInstance();
        gameState=GameState.LOADING;
    }
    public JPanel getDelegatedPanel(){
        return uiManager.UpdateUI(gameState);
    }

    public static GameManager getInstance(){
        if (gameManager == null) {
            gameManager=new GameManager();
        }
        return gameManager;
    }
}
