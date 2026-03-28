package com.madlx.assets.resources;

import java.awt.image.BufferedImage;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class VisualAssetLoader implements ResourceManager<BufferedImage> {
    private final String MODULE_NAME = "images.txt";
    private static VisualAssetLoader visualAssetLoader;
    private final Map<String , BufferedImage> images = new HashMap<>();

    private VisualAssetLoader(){

        loadAll(MODULE_NAME);
    }
    /**
     * singleton instance
     * */
    public static VisualAssetLoader getInstance(){
        if(visualAssetLoader==null){
            visualAssetLoader= new VisualAssetLoader();

        }
        return visualAssetLoader;
    }


    public void loadAll(String path) {
       try {
           InputStream is = getClass().getResourceAsStream("/images/"+path);
           if(is!=null){
               BufferedReader br = new BufferedReader(new InputStreamReader(is));
               String line;
               while ((line=br.readLine())!=null){
                   if(line.startsWith("//")){
                       continue;
                   }
                   if(line.isEmpty()){
                       continue;
                   }
                   if(line.equals("stopper")){
                       break;
                   }
                   images.put(line,ImageLoader.loadImage(line));
               }
        }
       }
       catch (IOException e) {
           throw new RuntimeException(e);
       }
    }

    public Map<String ,BufferedImage> getAssets(){
        return  images;
    }
}
