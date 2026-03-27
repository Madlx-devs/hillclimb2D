package com.madlx;

import com.madlx.ui.StartScreen;


import javax.swing.*;


public class App 
{
    public static void main( String[] args )
    {
        new App();
    }

    public App(){
        JFrame window = new JFrame("Hill climb 2D");
        window.setResizable(false);
        StartScreen startScreen= new StartScreen();
        window.add(startScreen);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
}
