package com.OOAD;

import java.util.Scanner;
public class SelectStoreCommand implements Command{
    Receiver receiver;

    SelectStoreCommand(Receiver receiver){
        this.receiver = receiver;
    }

    public void execute(){
        receiver.selectStore();
    }
}

