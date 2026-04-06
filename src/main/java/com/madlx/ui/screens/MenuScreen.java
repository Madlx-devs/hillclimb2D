package com.madlx.ui.screens;

import com.madlx.App;
import com.madlx.core.GameManager;
import com.madlx.core.GameState;
import com.madlx.ui.components.CustomButton;
import com.madlx.util.ImagesLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class MenuScreen extends JPanel implements BaseScreen, ActionListener {

    private static MenuScreen instance;
    private final BufferedImage background;

    private MenuScreen() {
        setPreferredSize(new Dimension(pWidth, pHeight));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        background = ImagesLoader.getInstance().getImage("menuScreen.png");

        add(Box.createVerticalGlue());
        add(Box.createHorizontalGlue());

        add(createButton("PLAY", new Color(66,165,245)));
        add(Box.createVerticalStrut(20));
        add(Box.createHorizontalStrut(pWidth/2));

        add(createButton("SETTING", new Color(255,180,0)));
        add(Box.createVerticalStrut(20));
        add(Box.createHorizontalStrut(pWidth/2));

        add(createButton("QUIT", new Color(38,188,166)));
        add(Box.createVerticalStrut(20));
        add(Box.createHorizontalStrut(pWidth/2));
        /*add(Box.createVerticalGlue());*/
    }

    private CustomButton createButton(String text, Color color) {
        CustomButton btn = new CustomButton(text, color);
        btn.setAlignmentX(Component.CENTER_ALIGNMENT);
        btn.setMaximumSize(btn.getPreferredSize());
        btn.addActionListener(this);
        return btn;
    }

    public static JPanel getInstance() {
        if (instance == null) {
            instance = new MenuScreen();
        }
        return instance;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background, 0, 0, getWidth(), getHeight(), null);
    }

    public void update() {
        // game loop updates if needed
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();

        switch (cmd) {
            case "PLAY":
                GameManager.setGameState(GameState.PLAYING);
                App.switchPanel(GameManager.getInstance().GetCurrentPanel());
                System.out.println(GameManager.getGameState());
                break;
            case "SETTING":
                GameManager.setGameState(GameState.FINISHED);
                break;
            case "QUIT":
                System.exit(0);
                break;
        }
    }
}