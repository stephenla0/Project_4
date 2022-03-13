package com.OOAD;

// Example code for Project 2 Part 2
// Bruce Montgomery - 2/14/22 - OOAD CSCI 4/5448 - CU Boulder
// Please cite any use of this code in your own future OOAD exercises

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
	    Simulation sim = new Simulation();
        Scanner scan = new Scanner(System.in);
        receiveUserInteraction interact = new receiveUserInteraction(scan, sim);
        int SIM_DAYS = sim.getSimDays(scan);
	    sim.startSim(SIM_DAYS);
        sim.lastDay(interact);
	    sim.summary();
    }
}
