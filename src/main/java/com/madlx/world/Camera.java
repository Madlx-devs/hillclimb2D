package com.madlx.world;

public class Camera {
    private static Camera camera;

    private Camera(){

    }

    public static Camera getInstance(){
        if(camera == null){
            camera = new Camera();
        }
        return camera;
    }

    public void follow(float x , float y){

    }
}
