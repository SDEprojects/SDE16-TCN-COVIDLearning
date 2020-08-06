package com.rjmj.capstone.room;

import com.rjmj.capstone.engines.MovementEngine;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StoryKitchen implements StoryRoom{

    Scanner scanner;
    MovementEngine movementEngine = new MovementEngine();
    private String nextAction;
    private int countWalkTo = 0;
    private List<String> localItems = new ArrayList<>();


    @Override
    public void enter(Scanner scanner) {
        this.scanner = scanner;

        if (!localItems.contains("CLEAR")) {
            localItems.remove("COFFEE_BAG_SHOOK");
            countWalkTo = 0;
            StoryIntro();
        }
        else{
            System.out.println("You are in KITCHEN now");
            freeAns();
        }
    }

    private void StoryIntro(){
        System.out.println("You just opened the door of the kitchen.");
        System.out.println("The light was on. You see a sink next to the door and a gas stove in the middle of the kitchen. ");
        System.out.println("It was chilly inside. On the counter and the floor, you do not see any dust, food or water stains.");
        System.out.println("You stepped into the Kitchen.");
        System.out.println("The light was suddenly off.");
        System.out.println("You see a flame coming up from the stove.");
        System.out.println("Next moment, you heard something clicked.");
        System.out.println("You turned around and tried to open the door, but you could not. You ran to the other door, it was also locked.");
        System.out.println("You just realized that you were locked out.");
        System.out.println();
        System.out.println("You see 3 cupboards mounted on the wall, a kettle, a toaster, and a coffee machine on the counter.");
        askQuestionStoryIntro();
    }

    private void askQuestionStoryIntro(){
        System.out.println("\n\nWhat would you like to do?");
        System.out.println("- Type \"0\" : Walk to the cupboards");
        System.out.println("- Type \"1\" : Walk to the kettle");
        System.out.println("- Type \"2\" : Walk to the toaster");
        System.out.println("- Type \"3\" : Walk to the coffee machine");
        if (countWalkTo > 4){
            System.out.println("- Type \"X\" : Leave the kitchen");
        }

        String choice = scanner.nextLine();
        if (choice.equals("0")){
            countWalkTo++;
            inFrontOfCupboard();
        }
        else if(choice.equals("1")){
            countWalkTo++;
            inFrontOfKettle();
        }
        else if(choice.equals("2")){
            countWalkTo++;
            inFrontOfToaster();
        }
        else if(choice.equals("3")){
            countWalkTo++;
            System.out.println("\nYou walked to the coffee machine. You do not see any coffee beans or water.");
            System.out.println("You decided to go back to where you were.");
            askQuestionStoryIntro();
        }
        else if(choice.equalsIgnoreCase("X")){
            System.out.println("You heard the door unlocked.");
            System.out.println("This time you where able to open the door where you came.");
            System.out.println("You decided to go back.");
            setNextAction("move up");
        }
        else{
            System.out.println("What you typed is invalid.Please try again.");
            askQuestionStoryIntro();
        }
    }

    private void inFrontOfCupboard(){
        //movementEngine.clearScreen();
        System.out.println("\n\nYou see 3 cupboards [\"A\", \"B\", \"C\"] in front of you.");
        System.out.println("Which one would you like to open?");
        System.out.println("- Type \"A\"");
        System.out.println("- Type \"B\"");
        System.out.println("- Type \"C\"");
        System.out.println("Or Type \"X\" for going back");
        String choice = scanner.nextLine();
        if (choice.equalsIgnoreCase("A")){
            System.out.println("\nYou tried to open the cupboard, but it was locked.");
            inFrontOfCupboard();
        }
        else if(choice.equalsIgnoreCase("B")){
            if (localItems.contains("BREAD")){
                System.out.println("\nYou do not see anything in the cupboard.");
                inFrontOfCupboard();
            }
            else {
                openCupBoard_B();
            }
        }
        else if(choice.equalsIgnoreCase("C")){
            System.out.println("\nYou see a coffee bag.");
            openCupBoard_C();
        }
        else if(choice.equalsIgnoreCase("X")){
            askQuestionStoryIntro();
        }
        else{
            System.out.println(choice + " is invalid. Please try again.");
            askQuestionStoryIntro();
        }
    }

    private void openCupBoard_B(){
        System.out.println("\n\nYou see a bag of bread.");
        System.out.println("\nWould you like to keep it?");
        System.out.println("- Type \"Yes\"");
        System.out.println("- Type \"No\"");
        String choice = scanner.nextLine();
        if (choice.equalsIgnoreCase("yes")){
            System.out.println("\nYou took the bag of bread and put it on the counter. ");
            localItems.add("BREAD");
            inFrontOfCupboard();
        }
        else if (choice.equalsIgnoreCase("no")){
            System.out.println("\nYou put it back in the cupboard.");
            inFrontOfCupboard();
        }
        else{
            System.out.println(choice + " is not a valid answer. Please try again.");
            openCupBoard_B();
        }
    }

    private void openCupBoard_C(){
        System.out.println("\n\nWhat would you like to do?");
        System.out.println("- Type \"shake\" for shaking the bag");
        System.out.println("- Type \"open\" for opening the bag");
        String choice = scanner.nextLine();
        if (choice.equalsIgnoreCase("shake")){
            System.out.println("\nYou shook the coffee bag. Nothing happened.");
            System.out.println("You put it back in the cupboard.");
            localItems.add("COFFEE_BAG_SHOOK");
            inFrontOfCupboard();
        }
        else if (choice.equalsIgnoreCase("open")){
            if ((localItems.contains("COFFEE_BAG_SHOOK")) || (localItems.contains("COFFEE_BAG_FOUND_MEMO"))){
                System.out.println("\nYou opened it, but you just see coffee beans inside.");
                System.out.println("You closed the bag and you put it back in the cupboard.");
            }
            else{
                localItems.add("COFFEE_BAG_FOUND_MEMO");
                System.out.println("\nYou found a memo inside of the bag.");
                System.out.println("\n   WELCOME TO THE KITCHEN.");
                System.out.println("   IF YOU ARE READING THIS MEMO, YOU ARE LUCKY.");
                System.out.println("   I CAN TELL YOU HOW TO BREAK THE SPELL OF THIS ROOM.");
                System.out.println("   YOU NEED TO SWITCH ON THE KETTLE FIRST, THEN TOAST A PIECE OF BREAD YOU FIND IN THE CUPBOARD.");
                System.out.println("\nYou keep the memo and put the coffee bag in the cupboard.");
            }
            inFrontOfCupboard();
        }
        else{
            System.out.println(choice + " is not a valid answer. Please try again.");
            openCupBoard_C();
        }
    }

    private void inFrontOfKettle(){
        System.out.println("\n\nYou are in front of the kettle.");
        System.out.println("What would you like to do?");
        System.out.println("- Type \"look around\" for looking around the kettle");
        System.out.println("- Type \"Look inside\" for looking inside of the kettle");
        System.out.println("- Type \"switch on\" for switching on the kettle");
        System.out.println("Or type \"go back\" to go back to where you were");
        String choice = scanner.nextLine();
        if (choice.equalsIgnoreCase("look around")) {
            System.out.println("\nYou look around the kettle, but you do not see anything special about the kettle.");
            inFrontOfKettle();
        }
        else if (choice.equalsIgnoreCase("look inside")){
            System.out.println("\nYou looked into the kettle, and you just see water.");
            inFrontOfKettle();
        }
        else if (choice.equalsIgnoreCase("switch on")) {
            localItems.add("SWITCH_ON_KETTLE");
            System.out.println("\nYou just switch on the kettle.");
            inFrontOfKettle();
        }
        else if(choice.equalsIgnoreCase("go back")){
            askQuestionStoryIntro();
        }
        else{
            System.out.println(choice + " is invalid. Please try again.");
            inFrontOfKettle();
        }
    }

    private void inFrontOfToaster() {
        System.out.println("\n\nYou are in front of the toaster.");
        System.out.println("What would you like to do?");
        if (localItems.contains("BREAD") && localItems.contains("SWITCH_ON_KETTLE") && localItems.contains("COFFEE_BAG_FOUND_MEMO")){
            System.out.println("Type \"Toast bread\" for toasting the bread you found.");
        }
        else{
            System.out.println("- Type \"Look around\"");
            System.out.println("- Type \"Look inside\"");
        }
        String choice = scanner.nextLine();
        if (choice.equalsIgnoreCase("Toast bread")){
            System.out.println("\n\nSuddenly, the flame on the stove was gone. Light was back on, and you heard the noise of somebody unlocking the doors.");
            localItems.add("CLEAR");
            freeAns();
        }
        else if (choice.equalsIgnoreCase("Look around")|| choice.equalsIgnoreCase("Look inside")){
            System.out.println("\nYou could not find anything special.");
            System.out.println("You decided to go back to where you were.");
            askQuestionStoryIntro();
        }
        else{
            System.out.println(choice + " is not a valid answer. Please try again.");
            inFrontOfToaster();
        }
    }

    private void freeAns(){
        System.out.println("\n\nWhat would you like to do?");
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
}
