package com.madlx.ui;

import com.madlx.core.GameState;

public class UiManager {

   private GameState state = GameState.START_SCREEN;

    public void updateUI() {
        switch (state) {
            case START_SCREEN:
                //TODO : logic to render start screen
                System.out.println("Start Screen");
                break;
            case MENU:
                //TODO : logic to render menu screen
                System.out.println("Menu Screen");
                break;

            case GAME:
               //TODO : logic to render game screen
                break;

            case PAUSED:
                //TODO : logic to render paused screen
                System.out.println("Paused Screen");
                break;

            case GAME_OVER:
                //TODO : logic to render gameOver screen
                System.out.println("Game Over Screen");
                break;
            default:
        }
    }
    private void loadUi(){

    }
}
