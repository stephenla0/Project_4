package com.OOAD;

public abstract class GuitarKitPart {
    String name;
    double price;
}



abstract class Bridge extends GuitarKitPart{
}

class North_Bridge_A extends Bridge{
    North_Bridge_A(){
        super();
        this.name = "North_Bridge_A";
        this.price = 21.58;
    }
}
class North_Bridge_B extends Bridge{
    North_Bridge_B(){
        super();
        this.name = "North_Bridge_B";
        this.price = 14.74;
    }
}
class North_Bridge_C extends Bridge{
    North_Bridge_C(){
        super();
        this.name = "North_Bridge_C";
        this.price = 18.93;
    }
}
class South_Bridge_A extends Bridge{
    South_Bridge_A(){
        super();
        this.name = "South_Bridge_A";
        this.price = 12.58;
    }
}
class South_Bridge_B extends Bridge{
    South_Bridge_B(){
        super();
        this.name = "South_Bridge_B";
        this.price = 24.72;
    }
}
class South_Bridge_C extends Bridge{
    South_Bridge_C(){
        super();
        this.name = "South_Bridge_C";
        this.price = 17.12;
    }
}



abstract class Knob extends GuitarKitPart{
}

class North_Knob_A extends Knob{
    North_Knob_A(){
        super();
        this.name = "North_Knob_A";
        this.price = 52.74;
    }
}
class North_Knob_B extends Knob{
    North_Knob_B(){
        super();
        this.name = "North_Knob_B";
        this.price = 32.61;
    }
}
class North_Knob_C extends Knob{
    North_Knob_C(){
        super();
        this.name = "North_Knob_C";
        this.price = 38.90;
    }
}
class South_Knob_A extends Knob{
    South_Knob_A(){
        super();
        this.name = "South_Knob_A";
        this.price = 32.17;
    }
}
class South_Knob_B extends Knob{
    South_Knob_B(){
        super();
        this.name = "South_Knob_B";
        this.price = 47.51;
    }
}
class South_Knob_C extends Knob{
    South_Knob_C(){
        super();
        this.name = "South_Knob_C";
        this.price = 68.47;
    }
}

abstract class Cover extends GuitarKitPart{
}
class North_Cover_A extends Cover {
    North_Cover_A(){
        super();
        this.name = "North_Cover_A";
    }
}
class North_Cover_B extends Cover{
    North_Cover_B(){
        super();
        this.name = "North_Cover_B";
    }
}
class North_Cover_C extends Cover{
    North_Cover_C(){
        super();
        this.name = "North_Cover_C";
    }
}
class South_Cover_A extends Cover{
    South_Cover_A(){
        super();
        this.name = "South_Cover_A";
    }
}
class South_Cover_B extends Cover{
    South_Cover_B(){
        super();
        this.name = "South_Cover_B";
    }
}
class South_Cover_C extends Cover{
    South_Cover_C(){
        super();
        this.name = "South_Cover_C";
    }
}



abstract class Neck extends GuitarKitPart{
}
class North_Neck_A extends Neck {
    North_Neck_A(){
        super();
        this.name = "North_Neck_A";
    }
}
class North_Neck_B extends Neck{
    North_Neck_B(){
        super();
        this.name = "North_Neck_B";
    }
}
class North_Neck_C extends Neck{
    North_Neck_C(){
        super();
        this.name = "North_Neck_C";
    }
}
class South_Neck_A extends Neck{
    South_Neck_A(){
        super();
        this.name = "South_Neck_A";
    }
}
class South_Neck_B extends Neck{
    South_Neck_B(){
        super();
        this.name = "South_Neck_B";
    }
}
class South_Neck_C extends Neck{
    South_Neck_C(){
        super();
        this.name = "South_Neck_C";
    }
}



abstract class Pickguard extends GuitarKitPart{
}

class North_Pickguard_A extends Pickguard {
    North_Pickguard_A(){
        super();
        this.name = "North_Pickguard_A";
    }
}
class North_Pickguard_B extends Pickguard{
    North_Pickguard_B(){
        super();
        this.name = "North_Pickguard_B";
    }
}
class North_Pickguard_C extends Pickguard{
    North_Pickguard_C(){
        super();
        this.name = "North_Pickguard_C";
    }
}
class South_Pickguard_A extends Pickguard{
    South_Pickguard_A(){
        super();
        this.name = "South_Pickguard_A";
    }
}
class South_Pickguard_B extends Pickguard{
    South_Pickguard_B(){
        super();
        this.name = "South_Pickguard_B";
    }
}
class South_Pickguard_C extends Pickguard{
    South_Pickguard_C(){
        super();
        this.name = "South_Pickguard_C";
    }
}



abstract class Pickup extends GuitarKitPart{
}

class North_Pickup_A extends Pickup {
    North_Pickup_A(){
        super();
        this.name = "North_Pickup_A";
    }
}
class North_Pickup_B extends Pickup{
    North_Pickup_B(){
        super();
        this.name = "North_Pickup_B";
    }
}
class North_Pickup_C extends Pickup{
    North_Pickup_C(){
        super();
        this.name = "North_Pickup_C";
    }
}
class South_Pickup_A extends Pickup{
    South_Pickup_A(){
        super();
        this.name = "South_Pickup_A";
    }
}
class South_Pickup_B extends Pickup{
    South_Pickup_B(){
        super();
        this.name = "South_Pickup_B";
    }
}
class South_Pickup_C extends Pickup{
    South_Pickup_C(){
        super();
        this.name = "South_Pickup_C";
    }
}