package com.madlx.core;

import com.madlx.ui.UiManager;

import javax.swing.*;

public class GameManager {
    private static  GameManager gameManager=null;
    private UiManager uiManager;

    public JPanel getDelegatedPanel(){
        return  null;
    }

    public static GameManager getInstance(){
        if (gameManager == null) {
            gameManager=new GameManager();
        }
        return gameManager;
    }
}
