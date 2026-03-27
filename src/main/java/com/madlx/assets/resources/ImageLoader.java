package com.madlx.assets.resources;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

/**
 * Utility class responsible for loading image resources from the classpath.
 * <p>
 * Images are expected to be located in the "/images/" directory inside
 * the resource folder.
 */
public class ImageLoader {
    /**
     * Loads an image from the resources/images directory.
     *
     * @param imageName the name of the image file (e.g., "player.png")
     * @return BufferedImage object representing the loaded image
     *
     * @throws RuntimeException if the image cannot be found or read
     * <p>
     * Behavior:
     * - Uses ClassLoader to access the image as a resource stream
     * - Ensures the resource exists using Objects.requireNonNull
     * - Wraps IOException into an unchecked RuntimeException
     */
    public  static  BufferedImage loadImage(String imageName){
        BufferedImage image;
        try {
            image= ImageIO.read(Objects.requireNonNull(ImageLoader.class.getResourceAsStream("/images/"+imageName)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return image;
    }
}
