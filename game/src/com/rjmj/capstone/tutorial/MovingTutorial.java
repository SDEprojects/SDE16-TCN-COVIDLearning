package com.rjmj.capstone.tutorial;

import com.rjmj.capstone.character.Color;
import com.rjmj.capstone.engines.MovementEngine;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.Scanner;

public class MovingTutorial implements InterfaceTutorial, Color {

    //// For resource bundle ////
    final String FILE_BASE_NAME = "MovingTutorial";
    ResourceBundle bundle = ResourceBundle.getBundle(PATH + FILE_BASE_NAME, Locale.US, rbc);
    ////////////////////////////

    private MovementEngine movementEngineTrunk = new MovementEngine();
    private TutorialParser tutorialParser = new TutorialParser();
    private Scanner userInput = new Scanner(System.in);
    private String playerLocation = "HALL";
    private final int DELAY = 700;


    public void startMovingTutorial() {
        movementEngineTrunk.clearScreen();
        movingTutorialInformationPrompt();
        movementEngineTrunk.clearScreen();
        movementEngine();
    }

    private void movementEngine() {
        switch(getPlayerLocation()) {
            case "HALL":
                MapTutorial.mapDisplay("HALL");
                hallRoomEngine();
                break;
            case "BALL ROOM":
                MapTutorial.mapDisplay("BALL ROOM");
                diningRoomEngine();
                break;
            case "MOVIE ROOM":
                MapTutorial.mapDisplay("MOVIE ROOM");
                finishMovementTutorial();
                break;
        }
    }

    private void movingTutorialInformationPrompt() {
        readStoryLinesOutOfFile("Welcome", DELAY);
        userInput.nextLine();
    }



    private void hallRoomEngine() {
        readStoryLinesOutOfFile("HallRoom", DELAY);
            if (movingTutorialMovementInputCollection().equals("RIGHT")) {
                setPlayerLocation("BALL ROOM");
                readStoryLinesOutOfFile("HallRoomEnteringBallRoom", 0);
            } else {
                readStoryLinesOutOfFile("InvalidSelection", 0);
            }
            userInput.nextLine();
            movementEngineTrunk.clearScreen();
            movementEngine();
        }


    private void diningRoomEngine() {
        readStoryLinesOutOfFile("BallRoom", DELAY);
        String result = movingTutorialMovementInputCollection();

        if (result.equals("RIGHT")) {
            setPlayerLocation("MOVIE ROOM");
            readStoryLinesOutOfFile("BallRoomEnteringMovieRoom", 0);
        }
        else if (result.equals("LEFT")) {
            setPlayerLocation("HALL");
            readStoryLinesOutOfFile("BallRoomEnteringHallRoom", 0);
        }
        else {
            readStoryLinesOutOfFile("InvalidSelection", 0);
        }
        userInput.nextLine();
        movementEngineTrunk.clearScreen();
        movementEngine();
    }


    private void finishMovementTutorial() {
        if (getPlayerLocation().equals("MOVIE ROOM")) {
            readStoryLinesOutOfFile("MovieRoom", DELAY);
        }
        userInput.nextLine();
    }

    private String movingTutorialMovementInputCollection() {
        String userChoice = userInput.nextLine();
        String[] result = new String[2];
        result = tutorialParser.parseAvailableActions(userChoice);
        return result[1].toUpperCase();
    }


    public String getPlayerLocation() {
        return playerLocation;
    }

    public void setPlayerLocation(String playerLocation) {
        this.playerLocation = playerLocation;
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
