package com.rjmj.capstone.tutorial;

import java.util.Scanner;

public class MovingTutorial {
    private Scanner userInput = new Scanner(System.in);
    private String playerLocation = "HALL";
    private final int delay = 700;
    private final String ANSI_RESET = "\u001B[0m";
    private final String ANSI_CYAN = "\u001B[36m";
    private final String ANSI_RED = "\u001B[31m";


    public void startMovingTutorial() throws InterruptedException {
        clearScreen();
        movingTutorialInformationPrompt();
        movementEngine();
    }

    private void movementEngine() throws InterruptedException {
        switch(getPlayerLocation()) {
            case "HALL":
                mapDisplay();
                hallRoomEngine();
                break;
            case "BALL ROOM":
                mapDisplay();
                diningRoomEngine();
                break;
        }
    }

    private void hallRoomEngine() throws InterruptedException {
        if (getPlayerLocation().equals("HALL")) {
            System.out.println(ANSI_CYAN + "Please select a direction to move, you are currently in the " + getPlayerLocation() + ANSI_RESET);
            System.out.println(ANSI_CYAN + "Available Options: Right." + ANSI_RESET);

            if (movingTutorialMovementInputCollection().equals("RIGHT")) {
                setPlayerLocation("BALL ROOM");
                System.out.println(ANSI_CYAN + "You've entered the Ball Room!\n" + ANSI_RESET);
            } else {
                System.out.println(ANSI_RED + "Invalid Selection, please try again." + ANSI_RESET);
            }
            clearScreen();
            movementEngine();
        }
    }

    private void diningRoomEngine() throws InterruptedException {
        if (getPlayerLocation().equals("BALL ROOM")) {
            System.out.println(ANSI_CYAN + "Please select a direction to move, you are currently in the " + getPlayerLocation() + ANSI_RESET);
            System.out.println(ANSI_CYAN + "Available Options: Right, Left." + ANSI_RESET);
            String result = movingTutorialMovementInputCollection();

            if (result.equals("RIGHT")) {
                setPlayerLocation("MOVIE ROOM");
                System.out.println(ANSI_RED + "You've entered the Movie Room!\n" + ANSI_RESET);
                finishMovementTutorial();
            } else if (result.equals("LEFT")) {
                setPlayerLocation("HALL");
                System.out.println(ANSI_CYAN + "You've entered the Hall!" + ANSI_RESET);
                clearScreen();
                movementEngine();
            } else {
                System.out.println(ANSI_RED + "Invalid Selection, please try again." + ANSI_RESET);
                movementEngine();
            }
        }
    }

    private void finishMovementTutorial() {
        if (getPlayerLocation().equals("MOVIE ROOM")) {
            System.out.println(ANSI_CYAN + "You've beaten the movement tutorial, type next to head into the next tutorial." + ANSI_RESET);
        }
        movingTutorialMovementInputCollection();
    }

    private void movingTutorialInformationPrompt() throws InterruptedException {
        String[] movingTutorialIntroStringArray = {
                ANSI_CYAN,
                "Welcome to the moving tutorial.",
                "Moving is a very important part of Apprenticeship.  Apprenticeship has a total of 12 rooms for you to" +
                        " navigate through.",
                "You can move a total of 4 different directions: Up, Down, Left, and Right.",
                "Each room you enter will have a specific direction(s) you can move.",
                "",
                "",
                "For this tutorial you will have three rooms in a single line for you to move between.",
                "You will be starting off in the Hall",
                "Type \"Start\" or any other command prompt to get started.",
                ANSI_RESET
        };

        for (String movingTutorial : movingTutorialIntroStringArray) {
            Thread.sleep(delay);
            System.out.println(movingTutorial);
        }
        userInput.next();
    }

    private void mapDisplay() {
            System.out.println( ANSI_CYAN +
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

    private String movingTutorialMovementInputCollection() {
        return userInput.next().toUpperCase().trim();
    }

    private void clearScreen() throws InterruptedException {
        Thread.sleep(delay);
        for(int i = 0; i < 50; i++) {
            System.out.println("\b");
        }
    }

    public String getPlayerLocation() {
        return playerLocation;
    }

    public void setPlayerLocation(String playerLocation) {
        this.playerLocation = playerLocation;
    }
}
