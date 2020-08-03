package com.rjmj.capstone.room;

import java.util.Scanner;

public class StoryDiningRoom implements StoryRoom{

    Scanner scanner;
    private String nextAction;

    @Override
    public void enter(Scanner scanner) {
        this.scanner = scanner;
        System.out.println("You are in DINING ROOM now");
        System.out.println("What would you like to do");
        freeAns();

    }

    private void freeAns(){
        String action = scanner.nextLine();
        setNextAction(action);
    }

    /**
     * Set Action (e.g. "talk", "move right") <- This can be user input
     * */
    private void setNextAction(String nextAction){
        this.nextAction = nextAction;
    }

    @Override
    public String getNextAction() {
        return nextAction;
    }
}
