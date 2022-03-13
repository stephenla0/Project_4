package com.OOAD;

public class NorthKitCreator extends KitCreator {
    protected Kit createKit(){
        Kit kit = null;
        GuitarKitFactory kitFactory = new NorthGuitarKitFactory();
        kit = new GuitarKit(kitFactory);
        return kit;
    }
}