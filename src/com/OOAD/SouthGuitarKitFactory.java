package com.OOAD;

public class SouthGuitarKitFactory implements GuitarKitFactory{
    public Bridge[] createBridge(){
        Bridge bridge[] = {
            new South_Bridge_A(),
            new South_Bridge_B(),
            new South_Bridge_C()
        };
        return bridge;
    }
    public Knob[] createKnob(){
        Knob knob[] = {
            new South_Knob_A(),
            new South_Knob_B(),
            new South_Knob_C()
        };
        return knob;
    }
    public Cover[] createCover(){
        Cover cover[] = {
            new South_Cover_A(),
            new South_Cover_B(),
            new South_Cover_C()
        };
        return cover;
    }
    public Neck[] createNeck(){
        Neck neck[] = {
            new South_Neck_A(),
            new South_Neck_B(),
            new South_Neck_C()
        };
        return neck;
    }
    public Pickguard[] createPickguard(){
        Pickguard pickguard[] = {
            new South_Pickguard_A(),
            new South_Pickguard_B(),
            new South_Pickguard_C()
        };
        return pickguard;
    }
    public Pickup[] createPickup(){
        Pickup pickup[] = {
            new South_Pickup_A(),
            new South_Pickup_B(),
            new South_Pickup_C()
        };
        return pickup;
    }
}
