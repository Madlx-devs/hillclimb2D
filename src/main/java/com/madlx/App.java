package com.madlx;

import com.madlx.core.GameManager;
import com.madlx.core.GamePanel;
import com.madlx.ui.screens.LoadScreen;
import com.madlx.ui.screens.MenuScreen;

import javax.swing.*;


public class App 
{
    public static void main( String[] args )
    {
        SwingUtilities.invokeLater(App::new);
    }
    public App(){
        GameManager gameManager=GameManager.getInstance();
        JFrame frame = new JFrame("hill climb 2d");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.add(gameManager.getDelegatedPanel());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}
