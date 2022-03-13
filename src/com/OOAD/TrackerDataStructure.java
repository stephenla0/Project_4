package com.OOAD;

//data structure for tracking clerks

public class TrackerDataStructure {
    String ClerkName;
    int itemsSold;
    int itemsPurchased;
    int itemsDamaged;
    Store store;

    TrackerDataStructure(String name, Store store){
        ClerkName = name;
        itemsSold = 0;
        itemsPurchased = 0;
        itemsDamaged = 0;
        this.store=store;
    }

}
