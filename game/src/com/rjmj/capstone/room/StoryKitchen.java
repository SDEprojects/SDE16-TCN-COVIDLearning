package com.rjmj.capstone.room;

import com.rjmj.capstone.character.Color;
import com.rjmj.capstone.engines.MovementEngine;

import java.util.*;

public class StoryKitchen implements StoryRoom, Color {

    //// For resource bundle ////
    final String FILE_BASE_NAME = "storyKitchen";
    ResourceBundle bundle = ResourceBundle.getBundle(PATH + FILE_BASE_NAME, Locale.US, rbc);
    ////////////////////////////

    Scanner scanner;
    MovementEngine movementEngine = new MovementEngine();
    private String nextAction;
    private boolean storyDone = false;

    @Override
    public void enter(Scanner scanner) {
        this.scanner = scanner;

        if (!storyDone){
            Story();
            storyDone = true;
        }
        else{
            readStoryLinesOutOfFile("showAlways", 0);
        }
        freeAns();
    }

    private void Story(){
        wrapReadStoryLinesOutOfFile("story1", 750);
        wrapReadStoryLinesOutOfFile("story2", 1000);
        wrapReadStoryLinesOutOfFile("story3", 1000);
        wrapReadStoryLinesOutOfFile("story4", 1000);
        wrapReadStoryLinesOutOfFile("story5", 1000);
        wrapReadStoryLinesOutOfFile("story6", 1200);
        wrapReadStoryLinesOutOfFile("story7", 650);
        wrapReadStoryLinesOutOfFile("story8", 1000);
    }

    private void wrapReadStoryLinesOutOfFile(String key, int timeDuration){
        readStoryLinesOutOfFile(key, timeDuration);
        scanner.nextLine();
        movementEngine.clearScreen();
    }

    private void freeAns(){
        readStoryLinesOutOfFile("askAlways", 100);
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
