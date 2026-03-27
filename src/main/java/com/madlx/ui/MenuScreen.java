package com.madlx.ui;

import javax.swing.*;
import java.awt.*;


public class MenuScreen extends JPanel implements BaseUi{


    public MenuScreen(){
        this.setPreferredSize(new Dimension(pWidth,pHeight));
        this.requestFocusInWindow();
        this.setDoubleBuffered(true);
        this.setBackground(Color.BLACK);
        LayoutManager lm = new BoxLayout(this ,BoxLayout.Y_AXIS);
        this.add(addButton("start",300,300));
        this.add(addButton("exit",300, 400));
        //this.add(addButton(""))
    }


    public JButton addButton(String buttonName , int xPos , int yPos){
        JButton button= new JButton(buttonName);
        button.setBounds(xPos,yPos,100,100);
        //Todo : to add action listener
        button.addActionListener(null);
       //TODO : to set button Icon
        button.setIcon(null);
        return button;
    }

}
