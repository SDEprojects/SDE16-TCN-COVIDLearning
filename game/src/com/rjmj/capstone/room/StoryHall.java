package com.rjmj.capstone.room;

import java.util.Scanner;

public class StoryHall implements StoryRoom{

    Scanner scanner;
    private String nextAction;
    private Boolean firstVisit = true;

    @Override
    public void enter(Scanner scanner) {
        this.scanner = scanner;
        if (firstVisit) introText();
        firstVisit = false;
        System.out.println("What now?");
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

    public void introText() {
        String[] infoText = {
                "\u001B[34m",
                "You enter a long dark corridor. There is a light at the end that flickers like a fading pulse.",
                "On the walls you see 19th century oil paintings. Their faces are familiar to you somehow.\n",
                "The floorboard groans beneath your tiptoeing feet",
                "Invisible cobwebs break across your face.\n",
                "The infection continues to spread throughout your body",
                "You find it difficult to breathe, your body weakens under the viral invasion",
                "Sweat beads out of your pores",
                "The infection tightens around your neck like a noose\n",
                "You grow dizzy and faint. Did the paintings just rotate?\n",
                "THUM, THUM, THUM, noises fill your ears. Are these real noises or are you hallucinating?",
                "THUMP!",
                "You fall to the floor, exhausted, struggling to catch your breath.\n",
                "While on the ground, a rat scampers over your hand. A roach begins crawling on your back, checking to see if you\'re lunch.",
                "Your vision blurs, you feel nothing and yet everything at once.\n\n",
                "Time",
                "Is",
                "Running",
                "Out . . . . .",
                "\u001B[0m"
        };
        try {
            for (String messages : infoText) {
                Thread.sleep(1450);
                System.out.println(messages);
            }
        }
        catch(Exception e){
            somethingWentWrong(e);
            System.out.println("Please check at \"Thread.sleep()\"");
        }
    }
}
