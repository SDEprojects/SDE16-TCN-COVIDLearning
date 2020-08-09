package com.rjmj.capstone.player;

import com.rjmj.capstone.engine.Parser;
import com.rjmj.capstone.engines.MovementEngine;
import com.rjmj.capstone.room.*;
import com.rjmj.capstone.timer.Countdown;
import com.rjmj.capstone.timer.GameTimer;
import com.rjmj.capstone.tutorial.Tutorial;

import java.util.*;

public class Player implements PlayerResourceBundle {

    //// For resource bundle ////
    final String FILE_BASE_NAME = "player";
    ResourceBundle bundle = ResourceBundle.getBundle(PATH + FILE_BASE_NAME, Locale.US, rbc);
    ////////////////////////////

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
    private boolean[] flagAccessingSecondTime = new boolean[3]; // 0:DINING_ROOM, 1:HALL, 2:KITCHEN
    private String oldCurrentRoom = null;
    private int countInvalidSelectionParser = 0;

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
                System.exit(0);
                break;
            case "INTRO":
                gameTextArt.introText();
                //parser = new Parser();
                play();
                break;
            case "TUTORIAL":
                tutorial.startTutorial();
                play();
                break;
            case "EXIT":
                System.exit(0);
                break;
            default:
                readStoryLinesOutOfFile("invalid", 0);
                play();
                break;
        }
    }

    // enterName() will prompt the user to  enter their desired name.
    public void collectPlayerName() {
        Scanner userInput = new Scanner(System.in);
        readStoryLinesOutOfFile("enterName", 0);
        this.playerName = userInput.nextLine();
        movementEngine.clearScreen();
        System.out.println(ANSI_PURPLE + "Username has been set to: " + ANSI_RESET + ANSI_RED + getPlayerName() + ANSI_RESET);
        readStoryLinesOutOfFile("pressEnter", 0);
        userInput.nextLine();
        movementEngine.clearScreen();
        cd.startTimer();
        recipe.mixRandomRecipe();
        cd.resetTimerNewGame();
    }

    public String collectPlayerActionInput(String userInput) {
        setPlayerActionSelection(userInput.toUpperCase());
        return getPlayerActionSelection();
    }


    // availableActions() will prompt the player with a list of actions they can choose, based on current room.
    public void parseAvailableActions(String input) {
        Rooms room = new Rooms();
        String[] commandArray = input.toLowerCase().split("\\s+", 2);
        String command = commandArray[0];
        String argument = commandArray.length > 1 ? commandArray[1] : " ";

        //if (command.equalsIgnoreCase("EXIT")) { play(); return; }
        // MOVE
        if (parser.isMoveSynonym(command))  {
            countInvalidSelectionParser = 0;
            setMoveMsg(movementEngine.changeRoom(getInventory(), argument, cd));
            // OLD VERSION - setMoveMsg(movementEngine.changeRoom(getInventory(), movementEngine.roomChoices(),cd));
        // LOOK AROUND
        } else if (parser.isSearchSynonym(command)) {
            countInvalidSelectionParser = 0;
            setLookAroundMsg(room.lookAround(movementEngine.getCurrentRoom(), getInventory()));
            System.out.println(getLookAroundMsg());
        // TALK
        } else if (parser.isTalkSynonym(command)) {
            countInvalidSelectionParser = 0;
            setTalkMsg(getInventory().talkToCharacter(room, movementEngine.getCurrentRoom(), getInventory(),cd));
            System.out.println(getTalkMsg());
        // TAKE ITEM
        } else if (parser.isTakeSynonym(command)) {
            countInvalidSelectionParser = 0;
            movementEngine.clearScreen();
            setTakeItemMsg(room.getItem(getInventory(), movementEngine.getCurrentRoom(), cd));
            System.out.println(getTakeItemMsg());
        // MIX
        } else if (command.equalsIgnoreCase("mix")) {
            countInvalidSelectionParser = 0;
            movementEngine.clearScreen();
            recipe.setPlayerMix(cd);
            winCheck();
            //mixCheck = true;
        // MAP
        } else if (command.equalsIgnoreCase("map")) {
            countInvalidSelectionParser = 0;
            movementEngine.clearScreen();
            gameTextArt.mapDisplay(movementEngine.getCurrentRoom());
        } else if ((command.equalsIgnoreCase("hint")) || (command.equalsIgnoreCase("help"))){
            countInvalidSelectionParser = 0;
            movementEngine.clearScreen();
            showHelp();
            movementEngine.clearScreen();
        }
        else {
            movementEngine.clearScreen();
            readStoryLinesOutOfFile("invalid", 0);
            countInvalidSelectionParser++;
            if (countInvalidSelectionParser > 2){
                readStoryLinesOutOfFile("ifYouNeedHelp", 0);
            }
        }

        //backToMenu();
    }
    private void showHelp(){
        Scanner userInput = new Scanner(System.in);
        readStoryLinesOutOfFile("helpParser", 0);
        userInput.nextLine();
    }


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
        return (pi.contains(ANSI_RED +"Red Liquid" + ANSI_RESET) && pi.contains(ANSI_BLUE + "Blue Liquid" + ANSI_RESET)
                && pi.contains(ANSI_GREEN + "Green Liquid" + ANSI_RESET) && pi.contains("Beaker"));
    }

    private void winCheck() {
        if(recipe.isMatch()){
            readStoryLinesOutOfFile("winCheckCorrect", 0);
            System.out.println(ANSI_RESET);
            gameTextArt.winningArtDisplay();
        } else {
            readStoryLinesOutOfFile("winCheckIncorrect", 0);
            System.out.println(ANSI_RESET);
            cd.subTimePenalty();
        }
    }

    private void backToMenu() {

        Scanner userInput = new Scanner(System.in);

        do {
            String currentRoom = movementEngine.getCurrentRoom();
            StoryRoom storyRoom = null;
            String action = null;

            // Show a message for mixture
            if ((itemsCheck()) && currentRoom.equals(oldCurrentRoom)) {
                readStoryLinesOutOfFile("enoughItemsToMix", 0);
            }

            // Store instance to "storyRoom" depending on the room the player entered
            switch (currentRoom) {
                case "DINING ROOM":
                    if (instancesStoryRoom[0] == null) {
                        storyRoom = new StoryDiningRoom();
                        instancesStoryRoom[0] = storyRoom;
                    } else {
                        storyRoom = instancesStoryRoom[0];
                        flagAccessingSecondTime[0] = true;
                    }
                    break;

                case "HALL":
                    if (instancesStoryRoom[1] == null) {
                        storyRoom = new StoryHall();
                        instancesStoryRoom[1] = storyRoom;
                    } else {
                        storyRoom = instancesStoryRoom[1];
                        flagAccessingSecondTime[1] = true;
                    }
                    break;

                case "KITCHEN":
                    if (instancesStoryRoom[2] == null) {
                        storyRoom = new StoryKitchen();
                        instancesStoryRoom[2] = storyRoom;
                    } else {
                        storyRoom = instancesStoryRoom[2];
                        flagAccessingSecondTime[2] = true;
                    }
                    break;

                default:
                    storyRoom = new StoryDefault();

            }

            // Current room location, Possession, time only show when a player moves from different room
            if ((currentRoom.equals("DINING ROOM")) || (currentRoom.equals("HALL")) || (currentRoom.equals("KITCHEN"))) {
                if (!currentRoom.equals(oldCurrentRoom)
                        && ((currentRoom.equals("DINING ROOM")) && (flagAccessingSecondTime[0])
                        || (currentRoom.equals("HALL")) && (flagAccessingSecondTime[1])
                        || (currentRoom.equals("KITCHEN")) && (flagAccessingSecondTime[2]))) {
                    storyRoom.displayMessageOnlyFirstTimeComingFromDifferentRoom(currentRoom, pi, cd.displayTimeInsideArt());
                }
            } else {
                if (!currentRoom.equals(oldCurrentRoom)) {
                    storyRoom.displayMessageOnlyFirstTimeComingFromDifferentRoom(currentRoom, pi, cd.displayTimeInsideArt());
                }
            }

            // Execute the class for the room
            storyRoom.enter(userInput);
            action = storyRoom.getNextAction();

            // Store what room the player was before
            if (oldCurrentRoom == null) {
                oldCurrentRoom = currentRoom;
            }
            oldCurrentRoom = currentRoom;

            if (action.equalsIgnoreCase("exit")){
                break;
            }
            else {
                // Process the action set by StoryRoom classes
                parseAvailableActions(collectPlayerActionInput(action));
            }
        }while(true);
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

    public void setMoveMsg(String moveMsg) {
        this.moveMsg = moveMsg;
    }

    /** For accessing and displaying stories in Resource Bundle file */
    public void readStoryLinesOutOfFile(String key, int SLEEP_DURATION_MS) {
        String msg = null;
        for (int i = 0; i < MAX_ITERATION_DISPLAY_STORIES; i++) {
            try {
                msg = textPainter(bundle.getString(key + "[" + i + "]"));
                displayStoryLineByLine(msg, SLEEP_DURATION_MS);
            }
            catch (MissingResourceException e) {
                if (i == 0){
                    System.out.println("Could not find the key : " + key);
                }
                break;
            }
            catch (Exception e){
                somethingWentWrong(e);
            }
        }
    }
}
