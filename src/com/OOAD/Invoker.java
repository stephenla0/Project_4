package com.OOAD;

public class Invoker implements ConsoleLogger{
    Command slot;

    Invoker(){
    }

    public void setCommand(Command command){
        slot = command;
    }

    public void executeCommand(){
        slot.execute();
    }
}
