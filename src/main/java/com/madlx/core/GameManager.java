package com.madlx.core;

import com.madlx.ui.UiManager;

import javax.swing.*;
import java.awt.*;

/** *
 * this will be responsible for handling the ui manager
 */

public class GameManager {
    public  static GameManager gameManager=null;
    public static GameState gameState=null;
    private JPanel container;
    private GameManager(){


    }

    public static GameManager getInstance() {
        if(gameManager==null){
            gameManager=new GameManager();
        }
        return gameManager;
    }

    public JPanel GetCurrentPanel(){
        if(gameState==null){
            return UiManager.UpdateUI(GameState.LOADING);
        }
        return UiManager.UpdateUI(gameState);
    }

    public static void setGameState(GameState newState){
        if(newState==null){
            throw new IllegalArgumentException("gameState cannot be null");
        }
        gameState= newState;
    }

    public static GameState getGameState(){
        return gameState;
    }
}
