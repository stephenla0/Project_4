package com.OOAD;

public class NorthGuitarKitFactory implements GuitarKitFactory{
    public Bridge[] createBridge(){
        Bridge bridge[] = {
            new North_Bridge_A(),
            new North_Bridge_B(),
            new North_Bridge_C()
        };
        return bridge;
    }
    public Knob[] createKnob(){
        Knob knob[] = {
            new North_Knob_A(),
            new North_Knob_B(),
            new North_Knob_C()
        };
        return knob;
    }
    public Cover[] createCover(){
        Cover cover[] = {
            new North_Cover_A(),
            new North_Cover_B(),
            new North_Cover_C()
        };
        return cover;
    }
    public Neck[] createNeck(){
        Neck neck[] = {
            new North_Neck_A(),
            new North_Neck_B(),
            new North_Neck_C()
        };
        return neck;
    }
    public Pickguard[] createPickguard(){
        Pickguard pickguard[] = {
            new North_Pickguard_A(),
            new North_Pickguard_B(),
            new North_Pickguard_C()
        };
        return pickguard;
    }
    public Pickup[] createPickup(){
        Pickup pickup[] = {
            new North_Pickup_A(),
            new North_Pickup_B(),
            new North_Pickup_C()
        };
        return pickup;
    }
}
