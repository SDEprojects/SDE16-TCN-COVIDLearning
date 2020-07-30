package com.rjmj.capstone.tutorial;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LookAroundItemTutorial {
    private Scanner userInput = new Scanner(System.in);
    private String playerLocation = "HALL";
    private final int delay = 700;
    private List<String> playerInventory = new ArrayList<>();
    private List<String> hallInventory = new ArrayList<>();
    private List<String> ballRoomInventory = new ArrayList<>();
    private List<String> movieRoomInventory = new ArrayList<>();
    private final String ANSI_RESET = "\u001B[0m";
    private final String ANSI_CYAN = "\u001B[36m";
    private final String ANSI_RED = "\u001B[31m";


    public void startLookAroundTutorial() throws InterruptedException {
        hallInventory.add("MacBook Pro");
        ballRoomInventory.add("Ultrawide Monitor");
        movieRoomInventory.add("Cell Phone");
        clearScreen();
        lookAroundTakeItemIntroText();
        lookAroundEngine();
    }

    private void lookAroundTakeItemIntroText() throws InterruptedException {
        String[] lookAroundTakeItemText = {
                ANSI_CYAN,
                "Welcome to the look around and take item tutorial.",
                "Looking Around and taking items are a very important part of Apprenticeship.",
                "By issuing the command \"Look Around\" you will be provided a description of what is inside your current room.",
                "By issuing the command \"Take Item\" you will be able to take any available items inside your current room.",
                "",
                "",
                "For this tutorial you will have three rooms in a single line for you to move between, similar to the previous tutorial.",
                "You will be starting off in the Hall",
                "Type \"Next\" or any other command to get started.",
                ANSI_RESET
        };

        for (String lookAroundTakeItem : lookAroundTakeItemText) {
            Thread.sleep(delay);
            System.out.println(lookAroundTakeItem);
        }

        lookAroundTutorialInputCollection();
    }

    private void lookAroundEngine() throws InterruptedException {
        switch(getPlayerLocation()) {
            case "HALL":
                mapDisplay();
                hallRoomEngine();
                break;
            case "BALL ROOM":
                mapDisplay();
                ballRoomEngine();
                break;
        }
    }


    private void hallRoomEngine() throws InterruptedException {
        if (getPlayerLocation().equals("HALL")) {
            System.out.println(ANSI_CYAN + "Please select a direction to move, you are currently in the " + getPlayerLocation() + ANSI_RESET);
            System.out.println(ANSI_CYAN + "Available Options: Right, Look Around, Take Item." + ANSI_RESET);
            String result = lookAroundTutorialInputCollection();

            switch (result) {
                case "RIGHT":
                    setPlayerLocation("BALL ROOM");
                    System.out.println(ANSI_CYAN + "You've entered the Ball Room!\n" + ANSI_RESET);
                    clearScreen();
                    lookAroundEngine();
                    break;
                case "LOOK AROUND":
                    if (hallInventory.contains("MacBook Pro")) {
                        System.out.println(ANSI_CYAN + "You see a MacBook Pro on the ground." + ANSI_RESET);
                    } else {
                        System.out.println(ANSI_RED + "You see nothing." + ANSI_RESET);
                    }
                    lookAroundEngine();
                    break;
                case "TAKE ITEM":
                    if (hallInventory.contains("MacBook Pro")) {
                        System.out.println(ANSI_CYAN + "You take the MacBook Pro on the ground." + ANSI_RESET);
                        playerInventory.add("MacBook Pro");
                        hallInventory.remove(0);
                        System.out.println(ANSI_CYAN + "Your inventory is: " + playerInventory + ANSI_RESET);
                    } else {
                        System.out.println(ANSI_RED + "There is nothing to take." + ANSI_RESET);
                    }
                    lookAroundEngine();
                    break;
                default:
                    System.out.println(ANSI_RED + "Invalid Selection, please try again." + ANSI_RESET);
                    lookAroundEngine();
                    break;
            }
        }
    }

    private void ballRoomEngine() throws InterruptedException {
        if (getPlayerLocation().equals("BALL ROOM")) {
            System.out.println(ANSI_CYAN + "Please select a direction to move, you are currently in the " + getPlayerLocation() + ANSI_RESET);
            System.out.println(ANSI_CYAN + "Available Options: Right, Left, Look Around, Take Item." + ANSI_RESET);
            String result = lookAroundTutorialInputCollection();

            switch (result) {
                case "RIGHT":
                    setPlayerLocation("MOVIE ROOM");
                    System.out.println(ANSI_RED + "You've entered the Movie Room!\n" + ANSI_RESET);
                    finishMovementTutorial();
                    break;
                case "LEFT":
                    setPlayerLocation("HALL");
                    System.out.println(ANSI_CYAN + "You've entered the Hall!" + ANSI_RESET);
                    lookAroundEngine();
                    break;
                case "LOOK AROUND":
                    if (ballRoomInventory.contains("Ultrawide Monitor")) {
                        System.out.println(ANSI_CYAN + "You see an Ultrawide Monitor on the Ground." + ANSI_RESET);
                    } else {
                        System.out.println(ANSI_RED + "You see nothing." + ANSI_RESET);
                    }
                    lookAroundEngine();
                    break;
                case "TAKE ITEM":
                    if (ballRoomInventory.contains("Ultrawide Monitor")) {
                        System.out.println(ANSI_CYAN + "You take the Ultrawide Monitor on the ground." + ANSI_RESET);
                        playerInventory.add(ballRoomInventory.get(0));
                        ballRoomInventory.remove(0);
                        System.out.println(ANSI_CYAN + "Your inventory is: " + playerInventory + ANSI_RESET);
                    } else {
                        System.out.println(ANSI_RED + "There is nothing to take." + ANSI_RESET);
                    }
                    lookAroundEngine();
                    break;
                default:
                    System.out.println(ANSI_RED + "Invalid Selection, please try again." + ANSI_RESET);
                    lookAroundEngine();
                    break;
            }
        }
    }

    private void finishMovementTutorial() {
        Scanner finalInput = new Scanner(System.in);
        mapDisplay();
        System.out.println(ANSI_CYAN + "Available Options: Look Around, Take Item." + ANSI_RESET);
        String result = lookAroundTutorialInputCollection();

        if (result.equals("LOOK AROUND")) {
            if (movieRoomInventory.contains("Cell Phone")) {
                System.out.println(ANSI_CYAN + "You see a Cell Phone on the ground." + ANSI_RESET);
            } else {
                System.out.println(ANSI_RED + "You see nothing." + ANSI_RESET);
            }
            finishMovementTutorial();
        } else if (result.equals("TAKE ITEM")) {
            if (movieRoomInventory.contains("Cell Phone")) {
                playerInventory.add(movieRoomInventory.get(0));
                movieRoomInventory.remove(0);
                System.out.println(ANSI_CYAN + "You take the cell phone on the ground." + ANSI_RESET);
                System.out.println(ANSI_CYAN + "Your inventory is: " + playerInventory + ANSI_RESET);
            } else {
                System.out.println(ANSI_RED + "There's nothing for you to take." + ANSI_RESET);
                finishMovementTutorial();
            }
        } else {
            System.out.println(ANSI_RED + "Invalid Selection, try again." + ANSI_RESET);
            finishMovementTutorial();
        }

        if (playerInventory.size() == 3) {
            System.out.println(ANSI_CYAN + "You've beaten the look around and take item tutorial!  Press next to continue." + ANSI_RESET);
            finalInput.nextLine();
        }
    }

    private void clearScreen() throws InterruptedException {
        Thread.sleep(delay);
        for(int i = 0; i < 50; i++) {
            System.out.println("\b");
        }
    }

    private void mapDisplay() {
        System.out.println(ANSI_CYAN +
                "___________________________________________________________________________________________\n" +
                        "|                            |                                |                             |\n"+
                        "|          Hall              |          Ball Room             |          Movie Room         |\n"+
                        "|                            |                                |                             |\n"+
                        "|    Move Choices: Right     |   Move Choices: Left, Right    |     Move Choices: Left      |\n"+
                        "|                            |                                |                             |\n"+
                        "|                            |                                |                             |\n"+
                        "-----------------------------|--------------------------------|-----------------------------|\n"
                        + ANSI_RESET
        );
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
}
