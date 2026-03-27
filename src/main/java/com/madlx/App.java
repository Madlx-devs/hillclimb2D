package com.madlx;

import com.madlx.core.Game;
import com.madlx.ui.MenuScreen;
import com.madlx.ui.StartScreen;


import javax.swing.*;
/**
 * The main entry point for the Hill Climb 2D game.
 *
 * <p>Responsibilities:
 * - Initializes the main application window (JFrame) for the game.
 * - Loads and displays the initial UI screens (StartScreen, MenuScreen).
 * - Sets up basic JFrame properties: title, size, close operation, and visibility.</p>
 *
 * <p>Notes:
 * - Currently, this class is used primarily for testing UI loading.
 * - StartScreen and MenuScreen are instantiated here, but the switching
 *   mechanism between screens will be handled by the Game or UiManager classes later.
 * - This setup is temporary and intended to verify that UI components render correctly.</p>
 *
 * @author
 *   Madlx-devs
 * @version
 *   1.0
 * @since
 *   2026-03-28
 */
public class App 
{    private Game game;
    public static void main( String[] args )
    {
        new App();
    }
   /*
   * this is just for checking whether the ui is being loaded correctly or not
   * it will be refactored once all the classes and dependencies are developed
   * by the developer
   *
   **/
    public App(){
        JFrame window = new JFrame("Hill climb 2D");
        window.setResizable(false);
        StartScreen startScreen= new StartScreen();
        MenuScreen menuScreen = new MenuScreen();
       // window.add(startScreen);
        window.add(menuScreen);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
}
