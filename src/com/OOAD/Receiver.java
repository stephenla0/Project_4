package com.OOAD;

import java.util.Calendar;
import java.util.Scanner;

public class Receiver implements ConsoleLogger{
    Simulation sim;
    Scanner scan;
    Store currentStore;

    Receiver(Simulation sim, Scanner scan){
        this.sim = sim;
        this.scan = scan;
    }

    public int getSelection(int min, int max){
        int selection = max+1;
        while(selection<min || selection > max){
            selection = scan.nextInt();
        }
        return selection;
    }

    public void selectStore(){
        System.out.println("Select Store:");
        int selection = 1;
        for(Store store: sim.corporation.stores){
            System.out.println(selection + ": " + store.storeName);
            selection++;
        }
        selection = getSelection(1, selection);
        currentStore = sim.corporation.stores.get(selection-1);
        System.out.println(currentStore.storeName + " selected");
    }

    public void getClerkName(){
        if(currentStore==null){
            System.out.println("No store selected");
            return;
        }
        System.out.println(currentStore.activeClerk.name + " is currently working in the store");
    }

    public void getTime(){
        long millis = System.currentTimeMillis();
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(millis);
        System.out.println("The time is currently " + (calendar.get(Calendar.HOUR_OF_DAY) + ":" +
                calendar.get(Calendar.MINUTE)));
    }

    public void sellItem(){
        if(currentStore==null){
            System.out.println("No store selected");
            return;
        }
        System.out.println("What item are you trying to sell");
        int selection = 1;
        for (ItemType type: currentStore.inventory.itemList) {
            System.out.println(selection + ": " + type.toString().toLowerCase());
            selection++;
        }
        selection = getSelection(1, selection);
        ItemType typeSelect = currentStore.inventory.itemList.get(selection-1);
        Item item = currentStore.inventory.makeNewItemByType(typeSelect);

        for (ItemType typetest: currentStore.inventory.discontinuedItems){
            if(item.itemType == typetest){
                System.out.println("The store is no longer accepting " + item.itemType);
                return;
            }
        }

        System.out.println("Item is "+item.itemType.toString().toLowerCase()+" in "+item.condition.toString().toLowerCase()+" condition.");
        item.purchasePrice = currentStore.activeClerk.getPurchasePriceByCondition(item.condition);
        System.out.println(currentStore.activeClerk.name+" offers "+Utility.asDollar(item.purchasePrice));

        System.out.println("Will you accept this offer?");
        System.out.println("1: Yes");
        System.out.println("2: No");

        selection = getSelection(1,2);

        if(selection==1){
            System.out.println("You sold " + item.itemType.toString().toLowerCase() + " for "+Utility.asDollar(item.purchasePrice));
            sim.corporation.logger.reopenFile(currentStore.today, currentStore);
            currentStore.activeClerk.buyItemFromCustomer(item, "User");
            sim.corporation.logger.close();
        }

        if(selection==2){
            item.purchasePrice += item.purchasePrice * .10;
            System.out.println(currentStore.activeClerk.name+" offers "+Utility.asDollar(item.purchasePrice));
            System.out.println("Will you accept this offer?");
            System.out.println("1: Yes");
            System.out.println("2: No");
            selection = getSelection(1,2);

            if(selection==1){
                System.out.println("You sold " + item.itemType.toString().toLowerCase() + " for "+Utility.asDollar(item.purchasePrice));
                sim.corporation.logger.reopenFile(currentStore.today, currentStore);
                currentStore.activeClerk.buyItemFromCustomer(item, "User");
                sim.corporation.logger.close();
            }
            if(selection==2){
                System.out.println("The store is no longer interested in buying the item");
            }
        }
    }

    public void buyItem(){
        if(currentStore==null){
            System.out.println("No store selected");
            return;
        }
        System.out.println("What item are you trying to buy");
        int selection = 1;
        for (ItemType type: currentStore.inventory.itemList) {
            System.out.println(selection + ": " + type.toString().toLowerCase());
            selection++;
        }
        selection = getSelection(1, selection);
        ItemType typeSelect = currentStore.inventory.itemList.get(selection-1);
        int countInStock = currentStore.inventory.countByType(currentStore.inventory.items, typeSelect);
        // if no items - bye
        if (countInStock == 0) {
            System.out.println("No items are in stock");
            return;
        }
        else {
            // pick one of the types of items from inventory
            // int pickItemIndex = Utility.rndFromRange(1,countInStock);
            Item item = currentStore.activeClerk.GetItemFromInventoryByCount(countInStock, typeSelect);
            System.out.println("Item is "+item.itemType.toString().toLowerCase()+" in "+item.condition.toString().toLowerCase()+" condition.");
            System.out.println("Item is selling for "+Utility.asDollar(item.listPrice));

            System.out.println("Will you accept this offer?");
            System.out.println("1: Yes");
            System.out.println("2: No");

            selection = getSelection(1,2);

            if(selection==1){
                System.out.println("You bought " + item.itemType.toString().toLowerCase() + " for "+Utility.asDollar(item.listPrice));
                sim.corporation.logger.reopenFile(currentStore.today, currentStore);
                currentStore.activeClerk.sellItemtoCustomer(item, "User");
                sim.corporation.logger.close();
            }

            if(selection==2){
                item.listPrice = item.listPrice * .9;
                System.out.println(currentStore.activeClerk.name+" offers "+Utility.asDollar(item.listPrice));
                System.out.println("Will you accept this offer?");
                System.out.println("1: Yes");
                System.out.println("2: No");
                selection = getSelection(1,2);

                if(selection==1){
                    System.out.println("You bought " + item.itemType.toString().toLowerCase() + " for "+Utility.asDollar(item.listPrice));
                    sim.corporation.logger.reopenFile(currentStore.today, currentStore);
                    currentStore.activeClerk.sellItemtoCustomer(item, "User");
                    sim.corporation.logger.close();
                }
                if(selection==2){
                    System.out.println("The store is no longer interested in selling the item");
                }
            }
        }
    }

    public void buyGuitarKit(){
        if(currentStore==null){
            System.out.println("No store selected");
            return;
        }
        Kit kit;
        if(currentStore.storeName=="Northside FNMS"){
            NorthKitCreator kitCreator = new NorthKitCreator();
            kit = kitCreator.createKit();
        }
        else if (currentStore.storeName=="Southside FNMS"){
            SouthKitCreator kitCreator = new SouthKitCreator();
            kit = kitCreator.createKit();
        }
        else{
            System.out.print("Error with store kit");
            return;
        }
        kit.gatherKitParts();

        System.out.println("Choose your Bridge:");
        int select = 1;
        for(Bridge item: kit.bridge){
            System.out.println(select + ": " + item.name);
            select++;
        }
        select = getSelection(1, select);
        System.out.println(kit.bridge[select-1].name + " has been added to your kit");

    }

    public void end(receiveUserInteraction interact){
        interact.terminate=true;
    }
}
