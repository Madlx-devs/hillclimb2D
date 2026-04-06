package com.madlx;

import com.madlx.core.GameManager;

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
        frame.revalidate();
        if(gameManager.getDelegatedPanel()!=null){
            frame.add(gameManager.getDelegatedPanel());
        }
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
