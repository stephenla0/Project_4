package com.OOAD;

import java.util.ArrayList;
import java.util.Iterator;
import java.beans.PropertyChangeSupport;
import java.beans.PropertyChangeListener;

public abstract class Staff{
    String name;    // Velma and Shaggy
}

class Clerk extends Staff implements ConsoleLogger {
    int daysWorked;
    boolean workedToday;
    boolean isSickToday;
    double damageChance;    // Velma = .05, Shaggy = .20
    Store store;
    private PropertyChangeSupport support; //how observer is notified of events
    double tuneodds; //strategy info

    Clerk(String name, double damageChance, PropertyChangeListener pcl, double tuneresult) {
         this.name = name;
         this.damageChance = damageChance;
         daysWorked = 0;
         support = new PropertyChangeSupport(this);
         support.addPropertyChangeListener(pcl);
         this.tuneodds=tuneresult;
    }

    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        support.addPropertyChangeListener(pcl);
    }

    public void removePropertyChangeListener(PropertyChangeListener pcl) {
        support.removePropertyChangeListener(pcl);
    }

    public void setStoreWorkingToday(Store store){
        this.store=store;
    }

    void arriveAtStore() {
        support.firePropertyChange("arriveAtStore_evt_1", null, this.name); //notify observer
        out(this.name + " arrives at store.", store.corporation.logger);
        // have to check for any arriving items slated for this day
        out( this.name + " checking for arriving items.", store.corporation.logger);
        // there's a tricky concurrent removal thing that prevents doing this
        // with a simple for loop - you need to use an iterator
        // https://www.java67.com/2014/03/2-ways-to-remove-elementsobjects-from-ArrayList-java.html#:~:text=There%20are%20two%20ways%20to,i.e.%20remove(Object%20obj).
        Iterator<Item> itr = store.inventory.arrivingItems.iterator();
        int count = 0;
        while (itr.hasNext()) {
            Item item = itr.next();
            if (item.dayArriving == store.today) {
                out( this.name + " putting a " + item.itemType.toString().toLowerCase() + " in inventory.", store.corporation.logger);
                store.inventory.items.add(item);
                itr.remove();
                count++;
            }
        }
        support.firePropertyChange("arriveAtStore_evt_2", null, count);

    }

    void checkRegister() {
        support.firePropertyChange("checkRegister_evt_1", null, Utility.asDollar(store.cashRegister));
        out(this.name + " checks: "+Utility.asDollar(store.cashRegister)+" in register.", store.corporation.logger);
        if (store.cashRegister<75) {
            out("Cash register is low on funds.", store.corporation.logger);
            this.goToBank();
        }
    }

    void goToBank() {
        out(this.name + " gets money from the bank.", store.corporation.logger);
        store.cashRegister += 1000;
        store.cashFromBank += 1000;
        support.firePropertyChange("goToBank_evt_1", null, Utility.asDollar(store.cashRegister));
        this.checkRegister();
    }

    void doInventory() {
        out(this.name + " is doing inventory.", store.corporation.logger);
        for (ItemType type: ItemType.values()) {
            int numItems = store.inventory.countByType(store.inventory.items,type);
            out(this.name + " counts "+numItems+" "+type.toString().toLowerCase(), store.corporation.logger);
            if (numItems == 0) {
                this.placeAnOrder(type);
            }
        }
        out(this.name + " is tuning items.", store.corporation.logger);
        boolean success = false;
        boolean damageChance = false;
        boolean prevState = false;
        int tunedmgcount = 0;
        Iterator<Item> itr = store.inventory.items.iterator();
        while (itr.hasNext()) {
            Item item = itr.next();
            if (item.tunable) {
                if (tuneodds > Utility.rnd()) {
                    success = true;
                }
                else {
                    success = false;
                }
            }

            if(success){
                switch(item.tuneType){
                    case NONE -> {
                        break;
                    }
                    case PLAYERS -> {
                        ((Players) item).equalized = true;
                        out(this.name + " successfully tuned a " + item.itemType.toString().toLowerCase(), store.corporation.logger);
                    }
                    case STRINGED -> {
                        ((Stringed) item).tuned = true;
                        out(this.name + " successfully tuned a " + item.itemType.toString().toLowerCase(), store.corporation.logger);
                    }
                    case WIND -> {
                        ((Wind) item).adjusted = true;
                        out(this.name + " successfully tuned a " + item.itemType.toString().toLowerCase(), store.corporation.logger);
                    }
                }
                damageChance = false;
            }
            else{
                switch(item.tuneType){
                    case NONE -> {
                        break;
                    }
                    case PLAYERS -> {
                        prevState = ((Players) item).equalized;
                        ((Players) item).equalized = false;
                        out(this.name + " unsuccessfully tuned a " + item.itemType.toString().toLowerCase(), store.corporation.logger);
                    }
                    case STRINGED -> {
                        prevState = ((Stringed) item).tuned;
                        ((Stringed) item).tuned = false;
                        out(this.name + " unsuccessfully tuned a " + item.itemType.toString().toLowerCase(), store.corporation.logger);
                    }
                    case WIND -> {
                        prevState = ((Wind) item).adjusted;
                        ((Wind) item).adjusted = false;
                        out(this.name + " unsuccessfully tuned a " + item.itemType.toString().toLowerCase(), store.corporation.logger);
                    }
                }
                if (prevState){
                    damageChance = true;
                }
                else{
                    damageChance = false;
                }
            }
            if(damageChance){
                if(Utility.rnd()>this.damageChance){
                    out(this.name + " failed tuning but did not damage the item.", store.corporation.logger);
                }
                else{
                    out(this.name + " damages something while tuning!", store.corporation.logger);
                    tunedmgcount++;
                    store.corporation.tracker.updateItemsDamaged(this, 1);
                    boolean broken = item.damageAnItem(item);
                    out("A " + item.itemType.toString().toLowerCase() + " has new list price: " + Utility.asDollar(item.listPrice), store.corporation.logger);
                    if (broken){
                        out("A " + item.itemType.toString().toLowerCase() + " was broken!", store.corporation.logger);
                        int index = store.inventory.getIndex(item);
                        itr.remove();
                        store.inventory.discardedItems.add(item);
                    }
                }
            }

        }
        int count = store.inventory.items.size();
        double worth = store.inventory.getValue(store.inventory.items);
        support.firePropertyChange("doInventory_evt_1", null, count);
        support.firePropertyChange("doInventory_evt_2", null, Utility.asDollar(worth));
        support.firePropertyChange("doInventory_evt_3", null, tunedmgcount);
        out(this.name + " finds " + count + " items in store, worth "+Utility.asDollar(worth), store.corporation.logger);
    }

    void placeAnOrder(ItemType type) {
        out(this.name + " needs to order "+type.toString().toLowerCase(), store.corporation.logger);
        // order 3 more of this item type
        // they arrive in 1 to 3 days
        int arrivalDay = Utility.rndFromRange(1,3);
        // check to see if any are in the arriving queue
        int count = store.inventory.countByType(store.inventory.arrivingItems,type);
        boolean discontinuedItem = false;
        for (ItemType typetest: store.inventory.discontinuedItems){
            if(type == typetest){
                discontinuedItem = true;
                break;
            }
        }
        if (count>0) {
            out("There is an order coming for " + type.toString().toLowerCase(), store.corporation.logger);
        }
        else if (!discontinuedItem){
            // order 3 of the missing items if you have the money to buy them
            int purchased = 0;
            for (int i = 0; i < 3; i++) {
                Item item = store.inventory.makeNewItemByType(type);
                if (store.cashRegister > item.purchasePrice) {
                    out(this.name + " ordered a " + item.itemType.toString().toLowerCase(), store.corporation.logger);
                    item.dayArriving = store.today + arrivalDay;
                    store.inventory.arrivingItems.add(item);
                    purchased++;
                }
                else {
                    out("Insufficient funds to order this item.", store.corporation.logger);
                }
            }
            support.firePropertyChange("placeAnOrder_evt_1", null, purchased);
        }
    }

    void openTheStore() {
        int buyers = Utility.getPoisson(4,10,3);
        //int buyers = Utility.getPoisson(4,10,3);
        int sellers = Utility.rndFromRange(1,4);
        int sold = 0;
        int purchased = 0;
        boolean success;
        out(buyers + " buyers, "+sellers+" sellers today.", store.corporation.logger);
        for (int i = 1; i <= buyers; i++){
            success = this.sellAnItem(i);
            if(success){
                sold++;
                store.corporation.tracker.updateItemsSold(this, 1);
            }
        }
        support.firePropertyChange("openTheStore_evt_1", null, sold);
        for (int i = 1; i <= sellers; i++){
            success = this.buyAnItem(i);
            if(success){
                purchased++;
                store.corporation.tracker.updateItemsPurchased(this, 1);
            }
        }
        support.firePropertyChange("openTheStore_evt_2", null, purchased);
    }
    boolean sellAnItem(int customer) {
        String custName = "Buyer "+customer;
        out(this.name+" serving "+custName, store.corporation.logger);
        ItemType type = Utility.randomEnum(ItemType.class);
        out(custName + " wants to buy a "+type.toString().toLowerCase(), store.corporation.logger);
        int countInStock = store.inventory.countByType(store.inventory.items, type);
        // if no items - bye
        if (countInStock == 0) {
            out (custName + " leaves, no items in stock.", store.corporation.logger);
            return false;
        }
        else {
            // pick one of the types of items from inventory
            // int pickItemIndex = Utility.rndFromRange(1,countInStock);
            Item item = GetItemFromInventoryByCount(countInStock, type);
            out("Item is "+type.toString().toLowerCase()+" in "+item.condition.toString().toLowerCase()+" condition.", store.corporation.logger);
            double saleOddsBoost = 0;
            if(item.tunable){
                switch(item.tuneType){
                    case NONE -> {
                        break;
                    }
                    case PLAYERS -> {
                        if (((Players) item).equalized){
                            saleOddsBoost = .1;
                        }
                    }
                    case STRINGED -> {
                        if (((Stringed) item).tuned){
                            saleOddsBoost = .15;
                        }
                    }
                    case WIND -> {
                        if (((Wind) item).adjusted){
                            saleOddsBoost = .2;
                        }
                    }
                }
            }
            // 50% chance to buy at listPrice
            out (this.name+" selling at "+Utility.asDollar(item.listPrice), store.corporation.logger);
            if (Utility.rnd()>(.5 - saleOddsBoost)) {
                sellItemtoCustomer(item, custName);
                return true;
            }
            else {
                // if not, clerk offers 10% off listPrice
                double newListPrice = item.listPrice * .9;
                out (this.name+" selling at "+Utility.asDollar(newListPrice), store.corporation.logger);
                // now 75% chance of buy
                if (Utility.rnd()>(.25 - saleOddsBoost)) {
                    item.listPrice = newListPrice;
                    sellItemtoCustomer(item,custName);
                    return true;
                }
                else {
                    out(custName + " wouldn't buy item.", store.corporation.logger);
                    return false;
                }
            }
        }
    }

    // things we need to do when an item is sold
    void sellItemtoCustomer(Item item,String custName) {
        int additionalItems = 0;
        String itemName = item.itemType.toString().toLowerCase();
        String price = Utility.asDollar(item.listPrice);
        out (this.name + " is selling "+ itemName + " for " + price +" to "+custName, store.corporation.logger);
        // when sold - move item to sold items with daySold and salePrice noted
        out ( "updated inventory count: "+store.inventory.items.size(), store.corporation.logger);
        if(item instanceof Stringed && custName!="User"){
            //begin trying to sell more with decorators
            out ("Item is stringed, " + this.name + " is attempting to sell accessories.", store.corporation.logger);
            ArrayList<Item> cart = new ArrayList<>();
            cart.add(item);
            DecoratingItem dItem = new AddGigBag(store.inventory.items, cart, item); //decorators
            dItem = new AddCables(store.inventory.items, cart, item); //decorators
            dItem = new AddStrings(store.inventory.items, cart, item); //decorators
            dItem = new AddPracticeAmps(store.inventory.items, cart, item); //decorators
            out(this.name + " selling " + dItem.toString() + "totaling: " + dItem.totalCost(), store.corporation.logger);
            for (Item cartItem : dItem.cart) {
                out("Item " + cartItem.itemType.toString().toLowerCase() + " cost " + cartItem.listPrice, store.corporation.logger);
            }
            additionalItems = cart.size() - 1;
            store.corporation.tracker.updateItemsSold(this, additionalItems);
            support.firePropertyChange("openTheStore_evt_1_addition", null, additionalItems);
            for (Item removeItem: dItem.cart){
                store.inventory.items.remove(removeItem);
                removeItem.salePrice = removeItem.listPrice;
                removeItem.daySold = store.today;
                store.inventory.soldItems.add(removeItem);
                store.cashRegister += removeItem.listPrice;
            }
        }
        else{
            store.inventory.items.remove(item);
            item.salePrice = item.listPrice;
            item.daySold = store.today;
            store.inventory.soldItems.add(item);
            // money for item goes to register
            store.cashRegister += item.listPrice;
        }
    }

    // find a selecyted item of a certain type from the items
    Item GetItemFromInventoryByCount(int countInStock, ItemType type) {
        int count = 0;
        for(Item item: store.inventory.items) {
            if (item.itemType == type) {
                count += 1;
                if (count == countInStock) return item;
            }
        }
        return null;
    }

    boolean buyAnItem(int customer) {
        String custName = "Seller "+customer;
        out(this.name+" serving "+custName, store.corporation.logger);
        ItemType type = Utility.randomEnum(ItemType.class);
        out(custName + " wants to sell a "+type.toString().toLowerCase(), store.corporation.logger);
        Item item = store.inventory.makeNewItemByType(type);

        boolean discontinuedItem = false;
        for (ItemType typetest: store.inventory.discontinuedItems){
            if(type == typetest){
                discontinuedItem = true;
                break;
            }
        }

        // clerk will determine new or used, condition, purchase price (based on condition)
        // we'll take the random isNew, condition from the generated item
        out("Item is "+type.toString().toLowerCase()+" in "+item.condition.toString().toLowerCase()+" condition.", store.corporation.logger);
        item.purchasePrice = getPurchasePriceByCondition(item.condition);
        // seller has 50% chance of selling
        out (this.name+" offers "+Utility.asDollar(item.purchasePrice), store.corporation.logger);
        if(discontinuedItem){
            out("The store is no longer accepting " + item.itemType, store.corporation.logger);
            return false;
        }
        else if (Utility.rnd()>.5) {
            buyItemFromCustomer(item, custName);
            return true;
        }
        else {
            // if not, clerk will add 10% to purchasePrice
            item.purchasePrice += item.purchasePrice * .10;
            out (this.name+" offers "+Utility.asDollar(item.purchasePrice), store.corporation.logger);
            // seller has 75% chance of selling
            if (Utility.rnd()>.25) {
                buyItemFromCustomer(item, custName);
                return true;
            }
            else {
                out(custName + " wouldn't sell item.", store.corporation.logger);
                return false;
            }
        }
    }

    void buyItemFromCustomer(Item item, String custName) {
        String itemName = item.itemType.toString().toLowerCase();
        String price = Utility.asDollar(item.purchasePrice);
        out (this.name + " is buying "+ itemName + " for " + price +" from "+custName, store.corporation.logger);
        if (store.cashRegister>item.purchasePrice) {
            store.cashRegister -= item.purchasePrice;
            item.listPrice = 2 * item.purchasePrice;
            item.dayArriving = store.today;
            store.inventory.items.add(item);
        }
        else {
            out(this.name + "cannot buy item, register only has "+Utility.asDollar(store.cashRegister), store.corporation.logger);
        }
    }


    double getPurchasePriceByCondition(Condition condition) {
        int lowPrice = 2*condition.level;
        int highPrice = 10*condition.level;
        return (double) Utility.rndFromRange(lowPrice,highPrice);
    }


    void cleanTheStore() {
        out(this.name + " is cleaning up the store.", store.corporation.logger);
        if (Utility.rnd()>this.damageChance) {
            support.firePropertyChange("cleanTheStore_evt_1", null, 2);
            out(this.name + " doesn't damage anything.", store.corporation.logger);
        }
        else {
            support.firePropertyChange("cleanTheStore_evt_1", null, 1);
            out(this.name + " damages something!", store.corporation.logger);
            store.corporation.tracker.updateItemsDamaged(this, 1);
            // reduce the condition for a random item
            // take the item off the main inventory and put it on the broken items ArrayList
            // left as an exercise to the reader :-)
            Item randitem = store.inventory.getRandomItem();
            boolean broken = randitem.damageAnItem(randitem);
            out("A " + randitem.itemType.toString().toLowerCase() + " has new list price: " + Utility.asDollar(randitem.listPrice), store.corporation.logger);
            if (broken){
                out("A " + randitem.itemType.toString().toLowerCase() + " was broken!", store.corporation.logger);
                store.inventory.items.remove(randitem.currentIndexForDeletion);
                store.inventory.discardedItems.add(randitem);
            }

        }
    }
    void leaveTheStore() {
        support.firePropertyChange("leaveTheStore_evt_1", null, this.name);
        out(this.name + " locks up the store and leaves.", store.corporation.logger);
        this.store=null;
    }
}
