package com.OOAD;

public class GuitarKit extends Kit{
    GuitarKitFactory kitFactory;
    public GuitarKit(GuitarKitFactory kitFactory){
        this.kitFactory = kitFactory;
    }

    void gatherKitParts(){
        bridge = kitFactory.createBridge();
        knob = kitFactory.createKnob();
        cover = kitFactory.createCover();
        neck = kitFactory.createNeck();
        pickguard = kitFactory.createPickguard();
        pickup = kitFactory.createPickup();
    }
}
