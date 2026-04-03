package com.madlx.ui;

public class UiManager {
    private static  UiManager uiManager;
    private UiManager(){

    }
    public void UpdateUI(){
        //TODO based on some condition update new Ui

    }
    public static UiManager getInstance(){
        if (uiManager == null) {
            uiManager=new UiManager();
        }
        return uiManager;
    }

}
