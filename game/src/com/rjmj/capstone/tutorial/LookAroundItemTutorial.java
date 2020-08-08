package com.rjmj.capstone.tutorial;

import com.rjmj.capstone.Color;
import com.rjmj.capstone.engines.MovementEngine;

import java.util.*;

public class LookAroundItemTutorial implements InterfaceTutorial{

    //// For resource bundle ////
    final String FILE_BASE_NAME = "LookAroundItemTutorial";
    ResourceBundle bundle = ResourceBundle.getBundle(PATH + FILE_BASE_NAME, Locale.US, rbc);
    ////////////////////////////

    private MovementEngine movementEngine = new MovementEngine();
    private Scanner userInput = new Scanner(System.in);
    private String playerLocation = "HALL";
    private final int DELAY = 700;
    private List<String> playerInventory = new ArrayList<>();
    private List<String> hallInventory = new ArrayList<>();
    private List<String> ballRoomInventory = new ArrayList<>();
    private List<String> movieRoomInventory = new ArrayList<>();
    private TutorialParser tutorialParser = new TutorialParser();


    public void startLookAroundTutorial(){
        hallInventory.add("MacBook Pro");
        ballRoomInventory.add("Ultrawide Monitor");
        movieRoomInventory.add("Cell Phone");
        movementEngine.clearScreen();
        lookAroundTakeItemIntroText();
        movementEngine.clearScreen();
        lookAroundEngine();
    }

    private void lookAroundTakeItemIntroText() {
        readStoryLinesOutOfFile("lookAroundTakeItemIntroText", DELAY);
        lookAroundTutorialInputCollection();
    }

    private void lookAroundEngine() {
        switch(getPlayerLocation()) {
            case "HALL":
                MapTutorial.mapDisplay("HALL");
                hallRoomEngine();
                break;
            case "BALL ROOM":
                MapTutorial.mapDisplay("BALL ROOM");
                ballRoomEngine();
                break;
            case "MOVIE ROOM":
                MapTutorial.mapDisplay("MOVIE ROOM");
                movieRoomEngine();
        }
    }


    private void hallRoomEngine() {

        readStoryLinesOutOfFile("hallRoomEngineIntro", DELAY);
        String result = lookAroundTutorialInputCollection();
        String[] resultParser = tutorialParser.parseAvailableActions(result);

        switch(resultParser[0]){
            case "MOVE":
                if(resultParser[1].equalsIgnoreCase("right")){
                    setPlayerLocation("BALL ROOM");
                    readStoryLinesOutOfFile("hallRoomEngineIntroMoveBallRoom", DELAY);
                    movementEngine.clearScreen();
                }
                else{
                    readStoryLinesOutOfFile("seeNothing", DELAY);
                }
                lookAroundEngine();
                break;
            case "LOOK AROUND":
                if (hallInventory.contains("MacBook Pro")) {
                    readStoryLinesOutOfFile("hallRoomEngineIntroLookAround", DELAY);
                } else {
                    readStoryLinesOutOfFile("hallRoomEngineIntroLookAround_noItem", DELAY);
                }
                lookAroundEngine();
                break;
            case "TAKE ITEM":
                if (hallInventory.contains("MacBook Pro")) {

                    playerInventory.add("MacBook Pro");
                    hallInventory.remove(0);

                    readStoryLinesOutOfFile("hallRoomEngineIntroTakeItem", DELAY);
                    System.out.println(playerInventory);
                }
                else {
                    readStoryLinesOutOfFile("takeItemNothing", DELAY);
                }
                // Finish tutorial
                if (playerInventory.size() == 3) {
                    finishTutorial();
                }
                else {
                    lookAroundEngine();
                }
                break;
            default:
                readStoryLinesOutOfFile("invalidSelection", DELAY);
                lookAroundEngine();
        }
    }

    private void ballRoomEngine() {
        readStoryLinesOutOfFile("ballRoomEngineIntro", DELAY);

            String result = lookAroundTutorialInputCollection();
            String[] resultParser = tutorialParser.parseAvailableActions(result);

            switch(resultParser[0]){
                case "MOVE":
                    if(resultParser[1].equalsIgnoreCase("right")){
                        setPlayerLocation("MOVIE ROOM");
                        readStoryLinesOutOfFile("ballRoomEngineIntroMoveMovieRoom", DELAY);
                        movementEngine.clearScreen();
                    }
                    else if(resultParser[1].equalsIgnoreCase("left")){
                        setPlayerLocation("HALL");
                        readStoryLinesOutOfFile("ballRoomEngineIntroMoveHall", DELAY);
                        movementEngine.clearScreen();
                    }
                    else{
                        readStoryLinesOutOfFile("seeNothing", DELAY);
                    }
                    lookAroundEngine();
                    break;
                case "LOOK AROUND":
                    if (ballRoomInventory.contains("Ultrawide Monitor")) {
                        readStoryLinesOutOfFile("ballRoomEngineIntroLookAround", DELAY);
                    } else {
                        readStoryLinesOutOfFile("ballRoomEngineIntroLookAround_noItem", DELAY);
                    }
                    lookAroundEngine();
                    break;
                case "TAKE ITEM":
                    if (ballRoomInventory.contains("Ultrawide Monitor")) {
                        playerInventory.add(ballRoomInventory.get(0));
                        ballRoomInventory.remove(0);

                        readStoryLinesOutOfFile("ballRoomEngineIntroTakeItem", DELAY);
                        System.out.println(playerInventory);
                    }
                    else {
                        readStoryLinesOutOfFile("takeItemNothing", DELAY);
                    }
                    // Finish tutorial
                    if (playerInventory.size() == 3) {
                        finishTutorial();
                    }
                    else{
                        lookAroundEngine();
                    }
                    break;
                default:
                    readStoryLinesOutOfFile("invalidSelection", DELAY);
                    lookAroundEngine();
            }
        }

    private void movieRoomEngine() {
        readStoryLinesOutOfFile("movieRoomEngineIntro", DELAY);
        String result = lookAroundTutorialInputCollection();
        String[] resultParser = tutorialParser.parseAvailableActions(result);


        switch(resultParser[0]){
            case "MOVE":
                if(resultParser[1].equalsIgnoreCase("left")){
                    setPlayerLocation("BALL ROOM");
                    readStoryLinesOutOfFile("movieRoomEngineIntroMoveBallRoom", DELAY);
                    movementEngine.clearScreen();
                }
                else{
                    readStoryLinesOutOfFile("seeNothing", DELAY);
                }
                lookAroundEngine();
                break;
            case "LOOK AROUND":
                if (movieRoomInventory.contains("Cell Phone")) {
                    readStoryLinesOutOfFile("movieRoomEngineIntroLookAround", DELAY);
                }
                else {
                    readStoryLinesOutOfFile("movieRoomEngineIntroLookAround_noItem", DELAY);
                }
                lookAroundEngine();
                break;
            case "TAKE ITEM":
                if (movieRoomInventory.contains("Cell Phone")) {
                    playerInventory.add(movieRoomInventory.get(0));
                    movieRoomInventory.remove(0);
                    readStoryLinesOutOfFile("movieRoomEngineIntroTakeItem", DELAY);
                    System.out.println(playerInventory);
                }
                else {
                    readStoryLinesOutOfFile("takeItemNothing", DELAY);
                }
                // Finish tutorial
                if (playerInventory.size() == 3) {
                    finishTutorial();
                }
                else{
                    lookAroundEngine();
                }
                break;
            default:
                readStoryLinesOutOfFile("invalidSelection", DELAY);
                lookAroundEngine();
        }
    }

    private void finishTutorial(){
        readStoryLinesOutOfFile("completeTraining", DELAY);
        lookAroundTutorialInputCollection();
    }

    private String lookAroundTutorialInputCollection() {
        return userInput.nextLine().toUpperCase();
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
