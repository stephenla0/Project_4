package com.OOAD;

public class BuyGuitarKitCommand implements Command{
    Receiver receiver;

    BuyGuitarKitCommand(Receiver receiver){
        this.receiver = receiver;
    }

    public void execute(){
        receiver.buyGuitarKit();
    }
}
