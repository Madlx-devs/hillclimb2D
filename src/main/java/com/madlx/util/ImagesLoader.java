package com.madlx.util;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Objects;

public class ImagesLoader {
    private static ImagesLoader imagesLoader;
    private static final HashMap<String , BufferedImage> imageMap = new HashMap<>();
    private static final HashMap<String,BufferedImage[]> stripMap=new HashMap<>();
    private ImagesLoader(){
        String IMAGE_FILES = "ims.txt";
        loadAll(IMAGE_FILES);
    }
    public static ImagesLoader getInstance(){
        if (imagesLoader == null) {
            imagesLoader=new ImagesLoader();
        }
        return imagesLoader;
    }

    public void loadAll(String imf){
        try {
            InputStream is = getClass().getResourceAsStream("/images/"+imf);
            if(is!=null){
                BufferedReader  br = new BufferedReader(new InputStreamReader(is));
                String line;
                while ((line = br.readLine()) != null) {
                    if(line.startsWith("//")){
                        continue;
                    }
                    if(line.isEmpty()){
                        continue;
                    }
                    imageMap.put(line,loadImage(line));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private BufferedImage loadImage(String imageName) {
        BufferedImage image =null;
        try {
            image =ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/images/"+imageName)));
        }
        catch (IOException e){
           throw new RuntimeException(e);
        }
        return image;
    }

    public BufferedImage getImage(String imageName){
        return imageMap.get(imageName);
    }
}
