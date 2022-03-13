package com.OOAD;

public class AskTimeCommand implements Command{
    Receiver receiver;

    AskTimeCommand(Receiver receiver){
        this.receiver = receiver;
    }

    public void execute(){
        receiver.getTime();
    }
}
