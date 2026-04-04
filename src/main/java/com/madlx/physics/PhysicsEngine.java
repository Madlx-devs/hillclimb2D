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
    public void changeMotion(){

    }
    public float changeGravity(){
    return 2f;
    }

    public double throttle(){
        initialAngle-=rotateAngle;
        return initialAngle;
    }
    public void applyBrake(){

    }
}
