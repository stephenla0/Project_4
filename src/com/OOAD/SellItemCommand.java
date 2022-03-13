package com.OOAD;

public class SellItemCommand implements Command{
    Receiver receiver;

    SellItemCommand(Receiver receiver){
        this.receiver = receiver;
    }

    public void execute(){
        receiver.sellItem();
    }
}
