package com.madlx;

import com.madlx.core.GameManager;

import javax.swing.*;
import java.awt.*;


public class App 
{   public static JPanel container;
    public static void main( String[] args )
    {
        SwingUtilities.invokeLater(App::new);
    }
    public App(){
        GameManager gameManager=GameManager.getInstance();
        JFrame frame = new JFrame("hill climb 2d");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.add(gameManager.GetCurrentPanel());
        frame.pack();
        frame.add(gameManager.GetCurrentPanel());
        System.out.println(gameManager.GetCurrentPanel().getName());
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
