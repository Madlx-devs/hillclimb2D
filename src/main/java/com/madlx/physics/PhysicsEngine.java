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

    public double throttle(){
         if (initialAngle>-360 && initialAngle<360){
             initialAngle+=rotateAngle;
         }
         return initialAngle;

    }
    public double applyBrake(){
        if(initialAngle>-360 && initialAngle<360){
        initialAngle-=rotateAngle;
        }
        return initialAngle;
    }

}
