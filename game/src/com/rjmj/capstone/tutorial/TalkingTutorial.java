package com.rjmj.capstone.tutorial;

import com.rjmj.capstone.character.Color;
import com.rjmj.capstone.engines.MovementEngine;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.Scanner;

public class TalkingTutorial implements InterfaceTutorial, Color {

    //// For resource bundle ////
    final String FILE_BASE_NAME = "TalkingTutorial";
    ResourceBundle bundle = ResourceBundle.getBundle(PATH + FILE_BASE_NAME, Locale.US, rbc);
    ////////////////////////////

    private MovementEngine movementEngine = new MovementEngine();
    private TutorialParser tutorialParser = new TutorialParser();
    private Scanner userInput = new Scanner(System.in);

    public void startTalkingTutorial(){
        tutorialIntroductionDisplay();
        movementEngine.clearScreen();
        talkingTutorialPrompt();
        talkingTutorialDisplay(talkingTutorialInputCollection());
    }

    private void tutorialIntroductionDisplay() {
        readStoryLinesOutOfFile("Welcome", 700);
        userInput.nextLine();
    }

    private void talkingTutorialPrompt() {
        readStoryLinesOutOfFile("First", 700);
    }

    private void talkingTutorialDisplay(String input) {
        if (input.equals("TALK")) {
            System.out.println();
            readStoryLinesOutOfFile("DidIt", 0);
            userInput.next(); // This is used to take any key input
        }
        else {
            readStoryLinesOutOfFile("Invalid", 0);
            talkingTutorialDisplay(talkingTutorialInputCollection());
        }
    }

    private String talkingTutorialInputCollection() {
        String[] result = new String[2];
        String words = userInput.nextLine();
        result = tutorialParser.parseAvailableActions(words);
        return result[0];
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
