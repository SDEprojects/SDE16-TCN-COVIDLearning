package com.rjmj.capstone.room;

import com.rjmj.capstone.character.Color;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.Scanner;

public class StoryHall implements StoryRoom, Color {

    //// For resource bundle ////
    final String FILE_BASE_NAME = "storyHall";
    ResourceBundle bundle = ResourceBundle.getBundle(PATH + FILE_BASE_NAME, Locale.US, rbc);
    ////////////////////////////

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
        readStoryLinesOutOfFile("Story", 1450);
    }
    /** For accessing and displaying stories in Resource Bundle file */
    public void readStoryLinesOutOfFile(String key, int SLEEP_DURATION_MS) {
        String msg = null;
        for (int i = 0; i < MAX_ITERATION_DISPLAY_STORIES; i++) {
            try {
                msg = textPainter(bundle.getString(key + "[" + i + "]"));
                displayStoryLineByLine(msg, SLEEP_DURATION_MS);
            } catch (MissingResourceException e) {
                if (i == 0){
                    System.out.println("Could not find the key : " + key);
                }
                break;
            }
        }
    }
}
