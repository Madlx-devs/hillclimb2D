package com.madlx.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class BikeHandler  implements KeyListener{
    private static BikeHandler instance;
     public boolean throttlePressed,brakesApplied;
    @Override
    public void keyTyped(KeyEvent e) {
    }

    public static BikeHandler getInstance() {
        if(instance==null){
            instance= new BikeHandler();
        }
        return instance ;
    }

    private BikeHandler(){
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        processKey(e);

    }

    @Override
    public void keyReleased(KeyEvent e) {
        processKey(e);
    }

    public void processKey(KeyEvent e){
        int code = e.getKeyCode();
        switch (code){
            case KeyEvent.VK_D:
                throttlePressed=true;
                brakesApplied=false;
                break;
            case KeyEvent.VK_A:
                throttlePressed=false;
                brakesApplied=true;
                break;
        }
    }
}
