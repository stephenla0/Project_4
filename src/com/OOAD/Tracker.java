package com.OOAD;
import java.util.ArrayList;

//tracker class to track store information

public class Tracker {
    public ArrayList <TrackerDataStructure> clerkStorage;

    private static Tracker tracker;

    private Tracker(){
        clerkStorage = new ArrayList<TrackerDataStructure>();
    }

    public static Tracker getInstance(){
        if(tracker == null){
            tracker = new Tracker();
        }
        return tracker;
    }

    public void addClerk(Clerk clerk, Store store){
        clerkStorage.add(new TrackerDataStructure(clerk.name, store));
    }

    public void addClerks(ArrayList<Clerk> clerks){
        for(Clerk clerk: clerks){
            clerkStorage.add(new TrackerDataStructure(clerk.name, clerk.store));
        }
    }

    public void updateItemsSold(Clerk clerk, int change){
        TrackerDataStructure data = getTrackerDataStructure(getClerkTrackerIndex(clerk));
        data.itemsSold = data.itemsSold + change;
    }

    public void updateItemsPurchased(Clerk clerk, int change){
        TrackerDataStructure data = getTrackerDataStructure(getClerkTrackerIndex(clerk));
        data.itemsPurchased = data.itemsPurchased + change;
    }

    public void updateItemsDamaged(Clerk clerk, int change){
        TrackerDataStructure data = getTrackerDataStructure(getClerkTrackerIndex(clerk));
        data.itemsDamaged = data.itemsDamaged + change;
    }

    public TrackerDataStructure getTrackerDataStructure(int index){
        return clerkStorage.get(index);
    }

    public int getClerkTrackerIndex(Clerk clerk){
        for (int i = 0; i < clerkStorage.size(); i++){
            if((clerkStorage.get(i).ClerkName == clerk.name) && (clerkStorage.get(i).store == clerk.store)){
                return i;
            }

        }
        return -1;
    }

}
