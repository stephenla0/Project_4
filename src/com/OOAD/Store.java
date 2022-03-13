package com.OOAD;
import java.util.ArrayList;

public class Store implements ConsoleLogger {
    public String storeName;
    public Clerk activeClerk;
    public double cashRegister;
    public double cashFromBank;
    public Inventory inventory;
    public int today;
    Corporation corporation;

    Store(String storeName, Corporation corporation) {
        // initialize the store's starting inventory
        this.corporation=corporation;
        inventory = new Inventory();
        this.storeName = storeName;
        cashRegister = 0;   // cash register is empty to begin
        cashFromBank = 0;   // no cash from bank yet
    }

    void openToday(int day) {
        today = day;
        corporation.logger.startDay(day, this);
        out("Store opens today, day "+day, corporation.logger);
        activeClerk = corporation.getValidClerk();
        activeClerk.setStoreWorkingToday(this);
        out(activeClerk.name + " is working today.", corporation.logger);
        activeClerk.arriveAtStore();
        activeClerk.checkRegister();
        activeClerk.doInventory();
        activeClerk.openTheStore();
        activeClerk.cleanTheStore();
        activeClerk.leaveTheStore();
        corporation.logger.endDay(this); //close logger
    }

    void openLastDay(int day){
        today = day;
        corporation.logger.startDay(day, this);
        out("Store opens today, day "+day, corporation.logger);
        activeClerk = corporation.getValidClerk();
        activeClerk.setStoreWorkingToday(this);
        out(activeClerk.name + " is working today.", corporation.logger);
        activeClerk.arriveAtStore();
        activeClerk.checkRegister();
        activeClerk.doInventory();
        corporation.logger.close();
    }

    void closeLastDay(){
        corporation.logger.reopenFile(today,this);
        activeClerk.cleanTheStore();
        activeClerk.leaveTheStore();
        corporation.logger.endDay(this);
    }

    void closedToday(int day) {
        corporation.logger.startDay(day, this);
        out("Store is closed today, day "+day, corporation.logger);
        corporation.logger.write("Store is closed today, day "+day);
        corporation.logger.endDay(this);
    }

    //for summary
    double getRemainingCashInRegister(){
        return cashRegister;
    }

    double getTotalMoneyFromBank(){
        return cashFromBank;
    }

}
