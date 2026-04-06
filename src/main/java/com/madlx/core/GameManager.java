package com.madlx.core;

import com.madlx.ui.UiManager;

import javax.swing.*;

public class GameManager {
    private static  GameManager gameManager=null;
    private  GameState gameState;

    public GameManager(){
    }
    public JPanel getDelegatedPanel(){
        if(gameState==null){
            return UiManager.UpdateUI(GameState.LOADING);
        }
        return UiManager.UpdateUI(gameState);
    }
    public static GameManager getInstance(){
        if (gameManager == null) {
            gameManager=new GameManager();
        }
        return gameManager;
    }

}
