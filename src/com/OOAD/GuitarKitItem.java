package com.OOAD;

import java.util.ArrayList;

public class GuitarKitItem extends Item{
    public ArrayList<GuitarKitPart> cart;
    GuitarKitItem(){
        super();
        cart = new ArrayList<GuitarKitPart>();
    }
    public void setCart(ArrayList<GuitarKitPart> cart){
        this.cart = cart;
    }

    public void setPrice(double price){
        this.salePrice = price;
    }
}
