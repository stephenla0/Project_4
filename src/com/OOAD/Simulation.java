package com.OOAD;
import java.util.ArrayList;

import java.io.File;
import java.util.Scanner;

// top level object to run the simulation
public class Simulation implements ConsoleLogger {
    int dayCounter;
    Weekday weekDay;
    Corporation corporation;

    // enum for Weekdays
    // next implementation from
    // https://stackoverflow.com/questions/17006239/whats-the-best-way-to-implement-next-and-previous-on-an-enum-type
    public static enum Weekday {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;
        private static Weekday[] vals = values();
        public Weekday next() {
            return vals[(this.ordinal()+1) % vals.length];
        }
    }

    public Simulation() {
        weekDay = Weekday.MONDAY;   //set the starting day
        dayCounter = 1;
        corporation = new Corporation();

        //clear output files for new simulation
        try {
            File f = new File("txt\\");
            File[] files = f.listFiles();
            for (int i = 0; i < files.length; i++) {
                files[i].delete();
            }
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    void startSim(int days) {
        for (int day = 1; day <= days; day++) {
            dayCounter = day;
            startDay(day);
        }
    }

    void startDay(int day) {
        corporation.newDay();
        if (weekDay == Weekday.SUNDAY) corporation.isOpenToday(false, day);
        else corporation.isOpenToday(true, day);
        weekDay = weekDay.next();
    }

    void lastDay(receiveUserInteraction interact){
        dayCounter++;
        corporation.newDay();
        corporation.lastDay(dayCounter, interact);
    }

    void summary() {
        for(Store store: corporation.stores){
            store.corporation.logger.startSummary(store);
            out("Summary of: " + store.storeName, store.corporation.logger);
            out("", store.corporation.logger);
            out("Items remaining in inventory:", store.corporation.logger);
            ArrayList<Item> items = store.inventory.getRemainingItems();
            String s = "";
            for (Item item:items) s = s + item.itemType.toString().toLowerCase() + " ";
            out(s, store.corporation.logger);
            out("", store.corporation.logger);
            out("Total value of remaining items:", store.corporation.logger);
            out("" + Utility.asDollar(store.inventory.getRemainingItemsValue()), store.corporation.logger);
            out("", store.corporation.logger);
            out("Items sold:", store.corporation.logger);
            ArrayList<Item> itemsSold = store.inventory.getRemainingItems();
            String s2 = "";
            for (Item item2:itemsSold) s2 = s2 + item2.itemType.toString().toLowerCase() + " ";
            out(s2, store.corporation.logger);
            out("", store.corporation.logger);
            out("Total value of sold items:", store.corporation.logger);
            out("" + Utility.asDollar(store.inventory.getSoldItemsValue()), store.corporation.logger);
            out("", store.corporation.logger);
            out("Money left in cash register:", store.corporation.logger);
            out("" + Utility.asDollar(store.getRemainingCashInRegister()), store.corporation.logger);
            out("", store.corporation.logger);
            out("Money added to register from bank:", store.corporation.logger);
            out("" + Utility.asDollar(store.getTotalMoneyFromBank()), store.corporation.logger);
            store.corporation.logger.stopSummary();
        }
    }

    int getSimDays(Scanner scan){
        System.out.println("Insert amount of days to run the simulation, 10 or more but no more than 30");
        int days = 0;
        while(days<10 || days > 30){
            days = scan.nextInt();
        }
        System.out.println("Running for " + days + " days");
        return days;
    }
}
