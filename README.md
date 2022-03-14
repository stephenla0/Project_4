#Project 4, Part 2

Project Members: Stephen Lasko, Ailish SKinner

Java Version: Open JK 17

<p>This project used sample code provided from project 2 and the strategy design</p>


<p>
Patterns are created in multiple files: 
<br>

Strategy: TuneContext.java, TuneStrategy.java, Haphazard.java, Manual.java, Electronic.java 
<br>

Observer: ClerkObserver.java, Tracker.java, TrackerDataStructure.java, Logger.java
<br>

Decorator: DecoratoratingItem.java
<br>

Command: Command.java, Invoker.java, AskNameCommand.java, AskTimeCommand.java,
BuyGuitarKitCommand.java, BuyItemCommand.java, EndInteractionCommand.java, SelectStoreCommand.java,
SellItemCommand.java, Receiver.java, receiveUserInteraction.java
<br>

Abstract Factory: GuitarKit.java, GuitarKitFactory.java, GuitarKitItem.java, GuitarKitPart.java,
Kit.java, KitCreator.java, NorthGuitarKitFactory.java, NorthKitCreator.java, SouthGuitarKitFactory.java,
SouthKitCreator.java
<br>

Singleton: Tracker.java, Logger.java
</p>

<p>
link to UML made in program that isnt cut off from images:
https://app.diagrams.net/#G16pr9omXINI4UoOkoQLWpRQijJlVON6As
</p>


Changes Made to UML: 
We added in defining functions that were left blank in our original UML diagram. Additionally, we implemented more classes in the Command class than were originally thought to be needed. This was upadated in the link above. No other changes were significant in our new UML. 
