package com.OOAD;

public interface GuitarKitFactory {
    public Bridge[] createBridge();
    public Knob[] createKnob();
    public Cover[] createCover();
    public Neck[] createNeck();
    public Pickguard[] createPickguard();
    public Pickup[] createPickup();
}
