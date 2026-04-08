package com.madlx.ui.components;

import java.awt.*;
import java.util.Objects;

public class FontLoader {
    public static Font font;
    private FontLoader(){
        createFont();
    }
    public static void createFont(){
        try {
            font = Font.createFont(Font.TRUETYPE_FONT, Objects.requireNonNull(FontLoader.class.getResourceAsStream("/fonts/LuckiestGuyRegular.ttf")));
            font.deriveFont(Font.BOLD, 18.0F);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
    public static Font getFont(){
        return font;
    }
}
