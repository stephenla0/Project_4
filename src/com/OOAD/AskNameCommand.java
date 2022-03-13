package com.OOAD;

public class AskNameCommand implements Command{
    Receiver receiver;

    AskNameCommand(Receiver receiver){
        this.receiver = receiver;
    }

    public void execute(){
        receiver.getClerkName();
    }
}
