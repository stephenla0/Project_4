package com.OOAD;

public class EndInteractionCommand implements Command{
    Receiver receiver;
    receiveUserInteraction interact;

    EndInteractionCommand(Receiver receiver, receiveUserInteraction interact){
        this.receiver = receiver;
        this.interact = interact;
    }

    public void execute(){
        receiver.end(interact);
    }
}
