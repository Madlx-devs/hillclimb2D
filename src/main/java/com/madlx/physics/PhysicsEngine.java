package com.madlx.physics;

public class PhysicsEngine {
    private static PhysicsEngine instance;
    private double rotateAngle=10.0f;
    private double initialAngle;
    private PhysicsEngine() {
        initialAngle=0;
    }

    public static PhysicsEngine getInstance() {
        if (instance == null) {
            instance = new PhysicsEngine();
        }
        return instance;
    }

    public void throttle(){
         initialAngle+=rotateAngle;
        System.out.println("throttled");
    }
    public void applyBrake(){
        initialAngle-=rotateAngle;
    }
}
