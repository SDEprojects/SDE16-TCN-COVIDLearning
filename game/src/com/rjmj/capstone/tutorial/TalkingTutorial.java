package com.rjmj.capstone.tutorial;

import java.util.Scanner;

public class TalkingTutorial {
    private Scanner userInput = new Scanner(System.in);
    private final String ANSI_RESET = "\u001B[0m";
    private final String ANSI_CYAN = "\u001B[36m";
    private final String ANSI_RED = "\u001B[31m";

    public void startTalkingTutorial() throws InterruptedException {
        tutorialIntroductionDisplay();
        clearScreen();
        talkingTutorialPrompt();
        talkingTutorialDisplay(talkingTutorialInputCollection());
    }

    private void tutorialIntroductionDisplay() throws InterruptedException {
        String[] tutorialIntroText = {
                ANSI_CYAN,
                "Hello there, welcome to the Apprenticeship Tutorial!",
                "This tutorial will guide you through the basics of the game, how items work, and the general rules.",
                "To get started, go ahead and type \"Start\" or any other command you prefer.",
                ANSI_RESET
        };

        for (String introText : tutorialIntroText) {
            Thread.sleep(700);
            System.out.println(introText);
        }

        // This is just here to prompt the next action, no logic is done with the collected input.
        userInput.next();
    }

    private void talkingTutorialPrompt() throws InterruptedException {
        String[] talkingTutorialText = {
                ANSI_CYAN,
                "First up, lets learn how to talk to the various characters you will discover throughout the game.",
                "This is pretty simple, just type \"Talk\" in the prompt to start a conversation with the available character.",
                "Please note if there is no character in your current room, you will be unable to start a conversation.",
                ANSI_RESET
        };

        for (String talkingText : talkingTutorialText) {
            Thread.sleep(700);
            System.out.println(talkingText);
        }
    }

    private void talkingTutorialDisplay(String input) {
        if (input.equals("TALK")) {
            System.out.println(ANSI_CYAN + "Jeannette: \"Hello there!  You did it.  Please type \"Next\" when you are ready, " +
                    "or any other command you prefer to proceed to the next tutorial area.\"" + ANSI_RESET);

            // This is just here to prompt the next action, lno logic is done with the collected input.
            userInput.next();
        } else {
            System.out.println(ANSI_RED + "Sorry, invalid command entry, please try again using \"Talk\"" + ANSI_RESET);
            talkingTutorialDisplay(talkingTutorialInputCollection());
        }
    }

    private void clearScreen() throws InterruptedException {
        Thread.sleep(1000);
        for(int i = 0; i < 50; i++) {
            System.out.println("\b");
        }
    }

    private String talkingTutorialInputCollection() {
        return userInput.next().toUpperCase();
    }
}
