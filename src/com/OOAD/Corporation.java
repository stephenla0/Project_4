package com.OOAD;

import java.util.ArrayList;

public class Corporation implements ConsoleLogger{
    public ArrayList<Store> stores;
    public ArrayList<Clerk> clerks;

    ClerkObserver observer;
    TuneContext context;
    double tuneresult;
    Tracker tracker;
    Logger logger;

    Corporation(){
        stores = new ArrayList<Store>();
        initializeStores(stores);
        observer = new ClerkObserver();
        clerks = new ArrayList<Clerk>();
        initializeClerks(clerks);
        tracker = tracker.getInstance();
        for (Store store: stores){
            for (Clerk clerk: clerks){
                tracker.addClerk(clerk, store);
            }
        }
        logger=logger.getInstance();
        observer.setLogger(logger);
    }

    public void newDay(){
        for(Clerk clerk: clerks){
            if(!clerk.workedToday){
                clerk.daysWorked = 0;
            }
            clerk.workedToday = false;
            clerk.isSickToday = false;
        }
    }

    void initializeStores(ArrayList<Store> list){
        list.add(new Store("Northside FNMS", this));
        list.add(new Store("Southside FNMS", this));
    }

    void initializeClerks(ArrayList<Clerk> list){
        // initialize the store's staff, observer, and tuning strategy
        context = new TuneContext(new Manual()); //use strategy to make odds and add it in clerk
        tuneresult = context.gettune();
        list.add(new Clerk("Velma",.05, observer, tuneresult));
        context = new TuneContext(new Haphazard());
        tuneresult = context.gettune();
        list.add(new Clerk("Shaggy", .20, observer, tuneresult));
        context = new TuneContext(new Electronic());
        tuneresult = context.gettune();
        list.add(new Clerk("Daphne", .15, observer, tuneresult)); //An additional Clerk will be hired – Daphne.

        context = new TuneContext(new Manual()); //use strategy to make odds and add it in clerk
        tuneresult = context.gettune();
        list.add(new Clerk("Freddy",.10, observer, tuneresult));
        context = new TuneContext(new Haphazard());
        tuneresult = context.gettune();
        list.add(new Clerk("Scooby", .05, observer, tuneresult));
        context = new TuneContext(new Electronic());
        tuneresult = context.gettune();
        list.add(new Clerk("Frank", .25, observer, tuneresult));
    }

    public void isOpenToday(boolean isOpen, int day) {
        if(isOpen){
            for(Store store: stores){
                store.openToday(day);
            }
        }
        else{
            for(Store store: stores){
                store.closedToday(day);
            }
        }
    }

    public void lastDay(int day, receiveUserInteraction interact){
        for(Store store: stores){
            store.openLastDay(day);
        }
        interact.openForInteraction();
        for(Store store: stores){
            store.closeLastDay();
        }
    }

    public Clerk getValidClerk() {
        // pick a random clerk
        Clerk clerk = clerks.get(Utility.rndFromRange(0,clerks.size()-1));

        //if clerk fell sick from selecting from other store selected keep cycling
        while(clerk.isSickToday){
            clerk = clerks.get(Utility.rndFromRange(0,clerks.size()-1));
        }

        //see if clerk is sick
        if(Utility.rnd()<0.1){
            clerk.isSickToday = true;
            clerk.workedToday = false;
        }

        //working today
        if ((!clerk.isSickToday) && (clerk.daysWorked < 3)) {
            clerk.daysWorked += 1;
            clerk.workedToday = true;
        }

        //cant work, too many days
        else if ((!clerk.isSickToday) && (clerk.daysWorked >= 3)){
            out(clerk.name+" has worked maximum of 3 days in a row.", logger);
            clerk.workedToday = false;
            for (Clerk other: clerks) {
                if ((other != clerk) && (other.daysWorked < 3) && (!other.isSickToday)) {
                    clerk = other;
                    clerk.workedToday = true;
                    return clerk;
                }
            }
        }

        // new case: if sick get new eligible clerk and give others a break
        else {
            out(clerk.name+" is sick today and can not work.", logger);
            for (Clerk other: clerks) {
                if ((other != clerk) && (other.daysWorked < 3) && (!other.isSickToday)) {
                    clerk = other;
                    clerk.workedToday = true;
                    return clerk;
                }
            }
        }
        return clerk;
    }
}
