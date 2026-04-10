package com.madlx.ui.asset;

import com.madlx.core.GamePanel;
import com.madlx.util.ImagesLoader;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.List;

public class BrakeButton {
    private static List<BufferedImage> images ;

    public BrakeButton(){
        ImagesLoader imagesLoader = ImagesLoader.getInstance();
        images=List.of(imagesLoader.getStripes("brakePaddle.png"));
    }
    public  void draw (Graphics2D  g2){
        g2.drawImage(images.get(0), 100,GamePanel.pWidth/6,100,100,null);
     }
}
