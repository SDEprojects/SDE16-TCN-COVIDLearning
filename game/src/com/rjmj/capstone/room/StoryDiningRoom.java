package com.rjmj.capstone.room;

import java.util.Scanner;

public class StoryDiningRoom implements StoryRoom{

    Scanner scanner;
    private String nextAction;

    @Override
    public void enter(Scanner scanner) throws InterruptedException {
        this.scanner = scanner;
        diningIntro();
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

    public void diningIntro() throws InterruptedException {
        String[] diningIntroText = {
                "\u001B[35m",
                "You are in the Dining room because you are dying of thirst.",
                "There's no trace of water or food you see a glass on the table half filled with a liquid.",
                "You find it fishy but you take a chance and drink.",
                "Now you feel horrible with sudden fever, coughing and sweating, the fear of COVID virus is haunting you.",
                "You are regretting the decision of drinking the liquid and badly looking around for some HELP!!",
                "You are struggling to breath you feel half dead but you don't want to give up suddenly you hear some noises from the next room.",
                "You are dying to seek help! You reach out to the door to open but your luck isn't favouring you today.The room is LOCKED!!!"
                ,
                "\u001B[0m"
        };

        for (String messages : diningIntroText) {
            Thread.sleep(1000);
            System.out.println(messages);
        }
    }
}
