package com.madlx.util;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
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
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String line;
            while((line=br.readLine())!=null){
                if(line.startsWith("//")){
                    continue;
                }
                if(line.equals("stopper")){
                    break;
                }
                if(line.startsWith("o")){
                    imageMap.put(line.substring(2),loadImage(line.substring(2)));
                }
                if(line.startsWith("n")){
                    stripMap.put(line.substring(2),getStripes(line.substring(2),line.charAt(line.length()-1)));
                }
            }
            }

        }
        catch (Exception e){
            System.out.println("cannot find image file");
        }
    }

    private BufferedImage loadImage(String imageName) {
        BufferedImage image;
        try {
            image =ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/images/"+imageName)));
        }
        catch (IOException e){
           throw new RuntimeException(e);
        }
        return image;
    }

    private BufferedImage[] getStripes(String name,int count ){
        BufferedImage[] images = new BufferedImage[count];
        BufferedImage image= getImage(name);
        int newWidth =image.getWidth()/count;
        BufferedImage newImage = createImage(image.getHeight(),newWidth);
        Arrays.fill(images, newImage);
        return images;
    }

    public BufferedImage getImage(String imageName){
        return imageMap.get(imageName);
    }
    private BufferedImage createImage(int height,int width){
        return new BufferedImage(width,height,BufferedImage.TYPE_INT_ARGB);
    }
}
