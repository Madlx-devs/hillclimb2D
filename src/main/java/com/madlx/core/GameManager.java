package com.madlx.core;

import com.madlx.ui.UiManager;

import javax.swing.*;
import java.util.Objects;

/** *
 * this will be responsible for handling the ui manager
 */

public class GameManager {
    public  static GameManager gameManager=null;
    public static GameState gameState;
    private GameManager(){
    }

    public JPanel GetCurrentPanel(){
        if(gameState==null){
           return UiManager.UpdateUI(GameState.LOADING);
        }
        return UiManager.UpdateUI(gameState);
    }

    public static GameManager getInstance() {
        if(gameManager==null){
            gameManager=new GameManager();
        }
        return gameManager;
    }
    public static void SetGameState(GameState newState){
        gameState= newState;
    }

}
