package com.madlx.entities;

import com.madlx.physics.PhysicsEngine;
import com.madlx.util.ImagesLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Bike {
    int x,y;
    private final PhysicsEngine physicsEngine= PhysicsEngine.getInstance();
    private final BufferedImage image;

    public Bike(){
        this.x=0;
        this.y=310;
        image= ImagesLoader.getInstance().getImage("bike.png");
    }

    public void draw(Graphics2D g2){
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY);
        g2.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL,RenderingHints.VALUE_STROKE_PURE);
        g2.drawImage(image,x,y,100,100,null);
    }

    public void update(){
        if(x>1080){
            x=0;
        }
        else{
            x+=10;
        }
    }
}

