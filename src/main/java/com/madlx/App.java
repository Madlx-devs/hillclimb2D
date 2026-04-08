package com.madlx;

import com.madlx.core.GameManager;
import com.madlx.core.GamePanel;

import javax.swing.*;
import java.awt.*;


public class App 
{   public static JPanel container;
    public static JFrame frame;
    public static void main( String[] args )
    {
        SwingUtilities.invokeLater(App::new);
    }
    public App(){
         frame = new JFrame("hill climb 2d");
        GameManager gameManager=GameManager.getInstance();
        container = new JPanel(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        switchPanel(gameManager.GetCurrentPanel());
        frame.add(container,BorderLayout.CENTER);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    public static void switchPanel(JPanel panel) {
        if (panel == null) return;
        SwingUtilities.invokeLater(() -> {
            if (container != null) {
                container.removeAll();
                container.add(panel, BorderLayout.CENTER);
                container.revalidate();
                container.repaint();
                if (frame != null) {
                    frame.pack();
                    frame.setLocationRelativeTo(null);
                }
                panel.requestFocus();
            }
        });
    }
}
