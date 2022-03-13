package com.OOAD;

public abstract class GuitarKitPart extends Item{
    String name;
    double price;
    KitItemType kitItemType;
}



abstract class Bridge extends GuitarKitPart{
}

class North_Bridge_A extends Bridge{
    North_Bridge_A(){
        super();
        this.name = "North_Bridge_A";
        this.price = 21.58;
        kitItemType = KitItemType.BRIDGE;
    }
}
class North_Bridge_B extends Bridge{
    North_Bridge_B(){
        super();
        this.name = "North_Bridge_B";
        this.price = 14.74;
        kitItemType = KitItemType.BRIDGE;
    }
}
class North_Bridge_C extends Bridge{
    North_Bridge_C(){
        super();
        this.name = "North_Bridge_C";
        this.price = 18.93;
        kitItemType = KitItemType.BRIDGE;
    }
}
class South_Bridge_A extends Bridge{
    South_Bridge_A(){
        super();
        this.name = "South_Bridge_A";
        this.price = 12.58;
        kitItemType = KitItemType.BRIDGE;
    }
}
class South_Bridge_B extends Bridge{
    South_Bridge_B(){
        super();
        this.name = "South_Bridge_B";
        this.price = 24.72;
        kitItemType = KitItemType.BRIDGE;
    }
}
class South_Bridge_C extends Bridge{
    South_Bridge_C(){
        super();
        this.name = "South_Bridge_C";
        this.price = 17.12;
        kitItemType = KitItemType.BRIDGE;
    }
}



abstract class Knob extends GuitarKitPart{
}

class North_Knob_A extends Knob{
    North_Knob_A(){
        super();
        this.name = "North_Knob_A";
        this.price = 52.74;
        kitItemType = KitItemType.KNOB;
    }
}
class North_Knob_B extends Knob{
    North_Knob_B(){
        super();
        this.name = "North_Knob_B";
        this.price = 32.61;
        kitItemType = KitItemType.KNOB;
    }
}
class North_Knob_C extends Knob{
    North_Knob_C(){
        super();
        this.name = "North_Knob_C";
        this.price = 38.90;
        kitItemType = KitItemType.KNOB;
    }
}
class South_Knob_A extends Knob{
    South_Knob_A(){
        super();
        this.name = "South_Knob_A";
        this.price = 32.17;
        kitItemType = KitItemType.KNOB;
    }
}
class South_Knob_B extends Knob{
    South_Knob_B(){
        super();
        this.name = "South_Knob_B";
        this.price = 47.51;
        kitItemType = KitItemType.KNOB;
    }
}
class South_Knob_C extends Knob{
    South_Knob_C(){
        super();
        this.name = "South_Knob_C";
        this.price = 68.47;
        kitItemType = KitItemType.KNOB;
    }
}

abstract class Cover extends GuitarKitPart{
}
class North_Cover_A extends Cover {
    North_Cover_A(){
        super();
        this.name = "North_Cover_A";
        this.price = 36.49;
        kitItemType = KitItemType.COVER;
    }
}
class North_Cover_B extends Cover{
    North_Cover_B(){
        super();
        this.name = "North_Cover_B";
        this.price = 42.17;
        kitItemType = KitItemType.COVER;
    }
}
class North_Cover_C extends Cover{
    North_Cover_C(){
        super();
        this.name = "North_Cover_C";
        this.price = 33.85;
        kitItemType = KitItemType.COVER;
    }
}
class South_Cover_A extends Cover{
    South_Cover_A(){
        super();
        this.name = "South_Cover_A";
        this.price = 30.25;
        kitItemType = KitItemType.COVER;
    }
}
class South_Cover_B extends Cover{
    South_Cover_B(){
        super();
        this.name = "South_Cover_B";
        this.price = 36.79;
        kitItemType = KitItemType.COVER;
    }
}
class South_Cover_C extends Cover{
    South_Cover_C(){
        super();
        this.name = "South_Cover_C";
        this.price = 46.32;
        kitItemType = KitItemType.COVER;
    }
}



abstract class Neck extends GuitarKitPart{
}
class North_Neck_A extends Neck {
    North_Neck_A(){
        super();
        this.name = "North_Neck_A";
        this.price = 20.47;
        kitItemType = KitItemType.NECK;
    }
}
class North_Neck_B extends Neck{
    North_Neck_B(){
        super();
        this.name = "North_Neck_B";
        this.price = 22.63;
        kitItemType = KitItemType.NECK;
    }
}
class North_Neck_C extends Neck{
    North_Neck_C(){
        super();
        this.name = "North_Neck_C";
        this.price = 17.08;
        kitItemType = KitItemType.NECK;
    }
}
class South_Neck_A extends Neck{
    South_Neck_A(){
        super();
        this.name = "South_Neck_A";
        this.price = 15.28;
        kitItemType = KitItemType.NECK;
    }
}
class South_Neck_B extends Neck{
    South_Neck_B(){
        super();
        this.name = "South_Neck_B";
        this.price = 20.63;
        kitItemType = KitItemType.NECK;
    }
}
class South_Neck_C extends Neck{
    South_Neck_C(){
        super();
        this.name = "South_Neck_C";
        this.price = 27.21;
        kitItemType = KitItemType.NECK;
    }
}



abstract class Pickguard extends GuitarKitPart{
}

class North_Pickguard_A extends Pickguard {
    North_Pickguard_A(){
        super();
        this.name = "North_Pickguard_A";
        this.price = 42.01;
        kitItemType = KitItemType.PICKGUARD;
    }
}
class North_Pickguard_B extends Pickguard{
    North_Pickguard_B(){
        super();
        this.name = "North_Pickguard_B";
        this.price = 48.26;
        kitItemType = KitItemType.PICKGUARD;
    }
}
class North_Pickguard_C extends Pickguard{
    North_Pickguard_C(){
        super();
        this.name = "North_Pickguard_C";
        this.price = 57.39;
        kitItemType = KitItemType.PICKGUARD;
    }
}
class South_Pickguard_A extends Pickguard{
    South_Pickguard_A(){
        super();
        this.name = "South_Pickguard_A";
        this.price = 67.52;
        kitItemType = KitItemType.PICKGUARD;
    }
}
class South_Pickguard_B extends Pickguard{
    South_Pickguard_B(){
        super();
        this.name = "South_Pickguard_B";
        this.price = 20.96;
        kitItemType = KitItemType.PICKGUARD;
    }
}
class South_Pickguard_C extends Pickguard{
    South_Pickguard_C(){
        super();
        this.name = "South_Pickguard_C";
        this.price = 40.18;
        kitItemType = KitItemType.PICKGUARD;
    }
}



abstract class Pickup extends GuitarKitPart{
}

class North_Pickup_A extends Pickup {
    North_Pickup_A(){
        super();
        this.name = "North_Pickup_A";
        this.price = 78.56;
        kitItemType = KitItemType.PICKUP;
    }
}
class North_Pickup_B extends Pickup{
    North_Pickup_B(){
        super();
        this.name = "North_Pickup_B";
        this.price = 98.63;
        kitItemType = KitItemType.PICKUP;
    }
}
class North_Pickup_C extends Pickup{
    North_Pickup_C(){
        super();
        this.name = "North_Pickup_C";
        this.price = 100.42;
        kitItemType = KitItemType.PICKUP;
    }
}
class South_Pickup_A extends Pickup{
    South_Pickup_A(){
        super();
        this.name = "South_Pickup_A";
        this.price = 110.85;
        kitItemType = KitItemType.PICKUP;
    }
}
class South_Pickup_B extends Pickup{
    South_Pickup_B(){
        super();
        this.name = "South_Pickup_B";
        this.price = 58.63;
        kitItemType = KitItemType.PICKUP;
    }
}
class South_Pickup_C extends Pickup{
    South_Pickup_C(){
        super();
        this.name = "South_Pickup_C";
        this.price = 87.26;
        kitItemType = KitItemType.PICKUP;
    }
}