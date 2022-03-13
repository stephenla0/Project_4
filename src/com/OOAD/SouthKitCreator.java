package com.OOAD;

public class SouthKitCreator extends KitCreator {
    protected Kit createKit(){
        Kit kit = null;
        GuitarKitFactory kitFactory = new SouthGuitarKitFactory();
        kit = new GuitarKit(kitFactory);
        return kit;
    }
}
