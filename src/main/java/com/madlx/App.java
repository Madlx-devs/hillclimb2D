package com.madlx;

import com.madlx.assets.resources.ResourceManager;
import com.madlx.assets.resources.VisualAssetLoader;
import com.madlx.core.Game;
import com.madlx.ui.MenuScreen;
import com.madlx.ui.StartScreen;
import com.madlx.ui.UiManager;
import com.madlx.utils.exception.NoPanelExistException;


import javax.swing.*;
import java.awt.image.BufferedImage;


/**
 * The main entry point for the Hill Climb 2D game.
 *
 *
 *
 * @author
 * Madlx-devs
 *
 * @version
 *   1.0
 * @since
 *   2026-03-28
 */
public class App
{
    public static void main( String[] args )
    {
        new App().start();
    }

    /**
     * empty constructor to initialize the Main app class
     * */

    public App(){

    }





    /**
     * start method creates JFrame window and initialize it also creates the uiManager class the
     * ui manager is responsible for managing the different scenes of the game like Menu Screen,
     * GamePlay Screen ,Paused Scene ,etc
     * */
    public void start(){
        JFrame window = new JFrame("Hill climb 2D");
        window.setResizable(false);
        UiManager uiManager= new UiManager(window);
        if(uiManager.getActiveWindow()!=null){
            window.add(uiManager.getActiveWindow());
        }
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }


}
