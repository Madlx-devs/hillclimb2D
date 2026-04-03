package com.madlx.entities;

import com.madlx.util.ImagesLoader;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Bike {
    int x,y;

    private BufferedImage image;

    public Bike(){
        this.x=0;
        this.y=310;
        image= ImagesLoader.getInstance().getImage("bike.png");
    }

    public void draw(Graphics2D g2){
        g2.drawImage(image,x,y,100,100,null);
    }

    public void update(){
        if(x>1080){
            x=0;
            System.out.println("x: "+x);
        }
        else{
            x+=10;
        }
    }
}

