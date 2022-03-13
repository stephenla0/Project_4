package com.OOAD;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

//logger class documents current information in a new text file each day

public class Logger {
    BufferedWriter text;
    int day;
    Tracker tracker;
    private static Logger logger = new Logger();

    Logger() {
        this.tracker=tracker.getInstance();
    }

    public static Logger getInstance(){
        return logger;
    }

    public void startDay(int day, Store store){
        this.day = day;
        // reference: https://www.w3schools.com/java/java_files_create.asp
        try {
            text = new BufferedWriter(new FileWriter( "txt\\Logger-" + day + "-" + store.storeName + ".txt"));
        } catch (IOException e) {
            System.out.println("An error creating logger file " + day + "-" + store.storeName + " occurred.");
            e.printStackTrace();
        }
        write("*** Simulation of " + store.storeName + ", day "+day+" ***");
    }

    public void reopenFile(int day, Store store){
        try{
            text = new BufferedWriter(new FileWriter("txt\\Logger-" + day + "-" + store.storeName + ".txt", true));
        } catch (IOException e) {
            System.out.println("An error creating logger file " + day + "-" + store.storeName + " occurred.");
            e.printStackTrace();
        }
    }

    public void write(String string){
        try{
            text.write(string);
            text.newLine();
        }
        catch (IOException e) {
            System.out.println("An error writing logger text occurred. " + string);
            e.printStackTrace();
        }
    }

    private void publishTracker(Store store){
        try{
            text.newLine();
            text.write("Tracker: Day " + day);
            text.newLine();
            text.write("Clerk, Items Sold, Items Purchased, Items Damaged");
            text.newLine();
            for (TrackerDataStructure clerk: tracker.clerkStorage){
                if(clerk.store.storeName == store.storeName){
                    text.write("" + clerk.ClerkName + " , " + clerk.itemsSold + " , " + clerk.itemsPurchased
                    + " , " + clerk.itemsDamaged);
                    text.newLine();
                }
            }
        }
        catch (IOException e) {
            System.out.println("An error publishing tracker results occurred.");
            e.printStackTrace();
        }
    }

    public void close(){
        try{
            text.close();
        }
        catch (IOException e) {
            System.out.println("An error closing logger text occurred.");
            e.printStackTrace();
        }
    }

    public void endDay(Store store){
        publishTracker(store);
        try{
            text.close();
        }
        catch (IOException e) {
            System.out.println("An error closing logger text occurred.");
            e.printStackTrace();
        }
    }

    public void startSummary(Store store){
        try {
            text = new BufferedWriter(new FileWriter("txt\\Summary-" + store.storeName + ".txt"));
        } catch (IOException e) {
            System.out.println("An error creating logger file Summary-" + store.storeName + " occurred.");
            e.printStackTrace();
        }
    }

    public void stopSummary(){
        try{
            text.close();
        }
        catch (IOException e) {
            System.out.println("An error closing logger text occurred.");
            e.printStackTrace();
        }
    }
}
