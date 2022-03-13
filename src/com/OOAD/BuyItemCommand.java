package com.OOAD;

public class BuyItemCommand implements Command{
    Receiver receiver;

    BuyItemCommand(Receiver receiver){
        this.receiver = receiver;
    }

    public void execute(){
        receiver.buyItem();
    }
}
