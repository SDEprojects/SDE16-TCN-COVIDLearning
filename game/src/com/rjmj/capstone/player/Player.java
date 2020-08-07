package com.rjmj.capstone.player;

import com.rjmj.capstone.Color;
import com.rjmj.capstone.engine.Parser;
import com.rjmj.capstone.engines.MovementEngine;
import com.rjmj.capstone.room.*;
import com.rjmj.capstone.timer.Countdown;
import com.rjmj.capstone.timer.GameTimer;
import com.rjmj.capstone.tutorial.Tutorial;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Player implements Color {
    private String playerName;
    private String playerActionSelection;
    private String playInput;
    private Parser parser;
    private Inventory inventory = new Inventory();
    private MovementEngine movementEngine = new MovementEngine();
    private Tutorial tutorial = new Tutorial();
    private Countdown cd = new Countdown();
    private GameTimer gameTimer = new GameTimer(); //CB added timer to the game
    private GameTextArt gameTextArt = new GameTextArt();
    private ArrayList pi = getInventory().getPlyrInv();
    private Recipe recipe = new Recipe();
    private String lookAroundMsg = "";
    private String talkMsg = "";
    private String takeItemMsg = "";
    private String moveMsg = "";
    private boolean mixCheck = false;
    private StoryRoom[] instancesStoryRoom = new StoryRoom[3];


    //public String play() {
    public void play() {
        Scanner userInput = new Scanner(System.in);
        gameTextArt.introArt();
        gameTextArt.introTextDelayed();
        String userChoice = userInput.next().toUpperCase().trim();
        playGame(userChoice);
    }

    public void playGame(String input) {
        switch (input) {
            case "START":
                parser = new Parser();
                collectPlayerName();
                backToMenu();
                break;
            case "INTRO":
                gameTextArt.introText();
                parser = new Parser();
                //collectPlayerName();
                play();
                //backToMenu();
                break;
            case "TUTORIAL":
                tutorial.startTutorial();
                play();
                break;
            case "EXIT":
                System.exit(0);
                break;
            default:
                System.out.println("Error, please try another entry.");
                play();
                break;
        }
    }

    // enterName() will prompt the user to  enter their desired name.
    public void collectPlayerName() {
        Scanner userInput = new Scanner(System.in);
        System.out.println(ANSI_PURPLE + "\nPlease enter your name: " + ANSI_RESET);
        this.playerName = userInput.nextLine();
        movementEngine.clearScreen();
        System.out.println(ANSI_PURPLE + "Username has been set to: " + ANSI_RESET + ANSI_RED + getPlayerName() + ANSI_RESET);
        cd.startTimer();
        recipe.mixRandomRecipe();
        cd.resetTimerNewGame();
    }

    public String collectPlayerActionInput(String userInput) {
        //Scanner userInput = new Scanner(System.in);
        //currentLocationDisplay();
        if(getMoveMsg().length() > 20){
            System.out.println(getMoveMsg());
            setMoveMsg("");
        }
        if(!getLookAroundMsg().equals("")){
            System.out.println(getLookAroundMsg());
            setLookAroundMsg("");
        }
        if(getTalkMsg().length() > 9){
            System.out.println(getTalkMsg());
            setTalkMsg("");
        }
        if(!getTakeItemMsg().equals("")){
            System.out.println(getTakeItemMsg());
            setTakeItemMsg("");
        }
        if(mixCheck) {
            winCheck();
            mixCheck = false;
        }
//        if (itemsCheck()){
//            System.out.println(ANSI_PURPLE + "You now have all the items necessary to Mix the vaccine ingredients...you will need to find the recipe now." + ANSI_RESET);
//            System.out.println("You can do the following actions:" +ANSI_RESET + ANSI_GREEN + "Look Around, " +ANSI_RESET + ANSI_PURPLE + "Talk, " +ANSI_RESET + ANSI_BLUE + "Take Item, " +ANSI_RESET + ANSI_YELLOW + "Move, " +ANSI_RESET + ANSI_WHITE + "Map, " +ANSI_RESET + ANSI_PURPLE + " Mix, " +ANSI_RESET + ANSI_RED + "Exit" + ANSI_RESET);
//        } else {
//            System.out.println(ANSI_CYAN + "You can do the following actions:" +ANSI_RESET + ANSI_GREEN + "Look Around, " +ANSI_RESET + ANSI_PURPLE + "Talk, " +ANSI_RESET + ANSI_BLUE + "Take Item, " +ANSI_RESET + ANSI_YELLOW + "Move, " +ANSI_RESET + ANSI_WHITE + "Map, " +ANSI_RESET + ANSI_RED + "Exit" +ANSI_RESET);
//        }
        //setPlayerActionSelection(userInput.nextLine().toUpperCase());
        setPlayerActionSelection(userInput.toUpperCase());
        return getPlayerActionSelection();
    }


    // availableActions() will prompt the player with a list of actions they can choose, based on current room.
    public void parseAvailableActions(String input) {
        Rooms room = new Rooms();
        String[] commandArray = input.toLowerCase().split("\\s+", 2);
        String command = commandArray[0];
        String argument = commandArray.length > 1 ? commandArray[1] : " ";

        if (command.equalsIgnoreCase("EXIT")) { play(); return; } //if (command.equals("EXIT")) { play(); return; }
        // MOVE
        if (parser.isMoveSynonym(command))  {
            setMoveMsg(movementEngine.changeRoom(getInventory(), argument, cd));
            // OLD VERSION - setMoveMsg(movementEngine.changeRoom(getInventory(), movementEngine.roomChoices(),cd));
        // LOOK AROUND
        } else if (parser.isSearchSynonym(command)) {
            setLookAroundMsg(room.lookAround(movementEngine.getCurrentRoom(), getInventory()));
            System.out.println(getLookAroundMsg());
        // TALK
        } else if (parser.isTalkSynonym(command)) {
            setTalkMsg(getInventory().talkToCharacter(room, movementEngine.getCurrentRoom(), getInventory(),cd));
            System.out.println(getTalkMsg());
        // TAKE ITEM
        } else if (parser.isTakeSynonym(command)) {
            movementEngine.clearScreen();
            setTakeItemMsg(room.getItem(getInventory(), movementEngine.getCurrentRoom(), cd));
            System.out.println(getTakeItemMsg());
        // MIX
        } else if (command.equals("mix")) {
            movementEngine.clearScreen();
            recipe.setPlayerMix(cd);
            winCheck();
            //mixCheck = true;
        // MAP
        } else if (command.equals("map")) {
            movementEngine.clearScreen();
            gameTextArt.mapDisplay(movementEngine.getCurrentRoom());
        } else {
            movementEngine.clearScreen();
            System.out.println("Error, please select a valid item.\n");
        }

        backToMenu();
    }



    // availableActions() will prompt the player with a list of actions they can choose, based on current room.
//    private void availableActions(String input) {
//        Rooms room = new Rooms();
//
//        switch(input) {
//            case "MOVE":
//                setMoveMsg(movementEngine.changeRoom(getInventory(), movementEngine.roomChoices(),cd));
//                backToMenu();
//                break;
//            case "LOOK AROUND":
//                setLookAroundMsg(room.lookAround(movementEngine.getCurrentRoom(), getInventory()));
//                backToMenu();
//                break;
//            case "TALK":
//                setTalkMsg(getInventory().talkToCharacter(room, movementEngine.getCurrentRoom(), getInventory(),cd));
//                backToMenu();
//                break;
//            case "TAKE ITEM":
//                movementEngine.clearScreen();
//                setTakeItemMsg(room.getItem(getInventory(), movementEngine.getCurrentRoom(), cd));;
//                backToMenu();
//                break;
//            case "MIX":
//                movementEngine.clearScreen();
//                recipe.setPlayerMix(cd);
//                mixCheck = true;
//                backToMenu();
//                break;
//            case "MAP":
//                movementEngine.clearScreen();
//                gameTextArt.mapDisplay(movementEngine.getCurrentRoom());
//                backToMenu();
//                break;
//            case "EXIT":
//                play();
//                break;
//            default:
//                movementEngine.clearScreen();
//                System.out.println("Error, please select a valid item.\n");
//                backToMenu();
//        }
//    }

//    public static void clr() {
//        for(int i = 0; i < 50; i++) {
//            System.out.println("\b");
//        }
//    }

    //[Syringe, Blue Liquid, Plunger, Key, Red Liquid, Box, Beaker, Green Liquid, Recipe, Needle]
    private void currentLocationDisplay() {
        StringBuilder sb = new StringBuilder();
        sb.append(ANSI_CYAN + "___________________________________________________________________________________________________________________________________________________________________________                                    \n" +
                "|                                                                                                                                                                          |\n" +
                "|                You are currently in the:  "+ANSI_RESET + ANSI_RED + movementEngine.getCurrentRoom() + ANSI_RESET + ANSI_CYAN +"                                            \n" +
                "|                                                                                                                                                                          |\n" +
                "|   Move to a new location      [Command:"+ANSI_RESET + ANSI_YELLOW +" Move"+ ANSI_RESET + ANSI_CYAN +"]                                                                                                                            |\n" +
                "|   Look Around the Room        [Command:"+ANSI_RESET + ANSI_GREEN +" Look Around"+ ANSI_RESET + ANSI_CYAN +"]                        Current Inventory                                                                            |\n" +
                "|   Talk to someone             [Command:"+ANSI_RESET + ANSI_PURPLE +" Talk"+ ANSI_RESET + ANSI_CYAN +"]                             "+ inventory.getPlyrInv() +"                                                                   \n" +
                "|   Take any available item     [Command:"+ANSI_RESET + ANSI_BLUE +" Take Item"+ ANSI_RESET + ANSI_CYAN +"]                                                                                                                       |\n"+
                "|   Display the game map        [Command:"+ANSI_RESET + ANSI_WHITE +" Map"+ ANSI_RESET + ANSI_CYAN +"]                                                                                                                             |\n" +
                "|   Exit this Program           [Command:"+ANSI_RESET + ANSI_RED +" Exit"+ ANSI_RESET + ANSI_CYAN +"]                                                                                                                            |\n");

        if(itemsCheck()) {
            sb.append("|   Mix the vaccine ingredients [Command: MIX]                                                                                                                             |\n");
        }
        sb.append("|                                                                                                                                                                          |\n" +
                "|                                                                                                                                                                          |\n" +
                "|              "+ cd.displayTimeInsideArt() +"                                                                                                                                       |\n" +
                "|__________________________________________________________________________________________________________________________________________________________________________|\n" + ANSI_RESET);
        System.out.println(sb.toString());
    }

    private boolean itemsCheck(){
        return (pi.contains(ANSI_RED +"Red Liquid" + ANSI_CYAN) && pi.contains(ANSI_BLUE + "Blue Liquid" + ANSI_CYAN)
                && pi.contains(ANSI_GREEN + "Green Liquid" + ANSI_CYAN) && pi.contains("Beaker"));
    }

    private void winCheck() {
        if(recipe.isMatch()){
            System.out.println("That is correct, you just cured yourself!");
            gameTextArt.winningArtDisplay();
        } else {
            System.out.println("That's not the right mixture. Try again.");
            cd.subTimePenalty();
//            backToMenu();
        }
    }

    private void backToMenu() {

        Scanner scanner = new Scanner(System.in);

        String currentRoom = movementEngine.getCurrentRoom();
        StoryRoom storyRoom = null;
        String action = null;
        switch (currentRoom){
            case "DINING ROOM":
                if (instancesStoryRoom[0] == null){
                    storyRoom = new StoryDiningRoom();
                    instancesStoryRoom[0] = storyRoom;
                }
                else{
                    storyRoom = instancesStoryRoom[0];
                }
                break;

            case "HALL":
                if (instancesStoryRoom[1] == null){
                    storyRoom = new StoryHall();
                    instancesStoryRoom[1] = storyRoom;
                }
                else{
                    storyRoom = instancesStoryRoom[1];
                }
                break;

            case "KITCHEN":
                if (instancesStoryRoom[2] == null){
                    storyRoom = new StoryKitchen();
                    instancesStoryRoom[2] = storyRoom;
                }
                else{
                    storyRoom = instancesStoryRoom[2];
                }
                break;

            default:
                System.out.println("You are in "+ currentRoom);
                if (itemsCheck()){
                    System.out.println(ANSI_PURPLE + "You now have all the items necessary to Mix the vaccine ingredients" + ANSI_RESET);
                }
                storyRoom = new StoryDefault();
        }

        storyRoom.enter(scanner);
        action = storyRoom.getNextAction();
        System.out.println("Action : "+ action);
        parseAvailableActions(collectPlayerActionInput(action));
    }


    public String getPlayerName() {
        return playerName;
    }

    public String getPlayerActionSelection() {
        return playerActionSelection;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public String getPlayInput() {
        return playInput;
    }

    public void setPlayInput(String playInput) {
        this.playInput = playInput;
    }

    public void setPlayerActionSelection(String playerActionSelection) {
        this.playerActionSelection = playerActionSelection;
    }

    public String getLookAroundMsg() {
        return lookAroundMsg;
    }

    public void setLookAroundMsg(String lookAroundMsg) {
        this.lookAroundMsg = lookAroundMsg;
    }

    public String getTalkMsg() {
        return talkMsg;
    }

    public void setTalkMsg(String talkMsg) {
        this.talkMsg = talkMsg;
    }

    public String getTakeItemMsg() {
        return takeItemMsg;
    }

    public void setTakeItemMsg(String takeItemMsg) {
        this.takeItemMsg = takeItemMsg;
    }

    public String getMoveMsg() {
        return moveMsg;
    }

    public void setMoveMsg(String moveMsg) {
        this.moveMsg = moveMsg;
    }
}
