package com.OOAD;

public abstract class Kit {
    String name;
    Bridge bridge[];
    Knob knob[];
    Cover cover[];
    Neck neck[];
    Pickguard pickguard[];
    Pickup pickup[];

    abstract void gatherKitParts();
}