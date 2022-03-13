package com.OOAD;

import java.util.ArrayList;

public abstract class Kit {
    String name;
    Bridge bridge[];
    Knob knob[];
    Cover cover[];
    Neck neck[];
    Pickguard pickguard[];
    Pickup pickup[];
    ArrayList<GuitarKitPart> cart;
    double cartPrice;


    abstract void gatherKitParts();

    void computeCartPrice(){
        double price = 0;
        for(GuitarKitPart obj: cart){
            price += obj.price;
        }
        this.cartPrice=price;
    }
    double getCartPrice(){
        computeCartPrice();
        return this.cartPrice;
    }

    void addToCart(GuitarKitPart part){
        cart.add(part);
    }

    void createCart(){
        cart = new ArrayList<GuitarKitPart>();
    }

    ArrayList<GuitarKitPart> getCart(){
        return cart;
    }
}