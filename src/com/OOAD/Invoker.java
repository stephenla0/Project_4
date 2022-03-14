package com.OOAD;


//invoker for command pattern
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
