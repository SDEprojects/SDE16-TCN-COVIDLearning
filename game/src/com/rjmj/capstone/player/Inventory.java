package com.rjmj.capstone.player;

import com.rjmj.capstone.character.*;
import com.rjmj.capstone.engines.MovementEngine;
import com.rjmj.capstone.room.Rooms;
import com.rjmj.capstone.timer.Countdown;

import java.util.*;

public class Inventory implements PlayerResourceBundle{

    //// For resource bundle ////
    final String FILE_BASE_NAME = "inventory";
    ResourceBundle bundle = ResourceBundle.getBundle(PATH + FILE_BASE_NAME, Locale.US, rbc);
    ////////////////////////////

    private Jay jay = new Jay();
    private John john = new John();
    private Tom tom = new Tom();
    private Nelly nelly = new Nelly();
    private Zach zach = new Zach();
    private Peter peter = new Peter();
    private ArrayList<String> plyrInv = new ArrayList<>();

    public String talkToCharacter(Rooms room, String currentRoom, Inventory inventory, Countdown cd) {
        Boolean isAnswerCorrect;
        MovementEngine movementEngine = new MovementEngine();
        movementEngine.clearScreen();
        String item = "";
        Map<String,String> rm = room.getROOMS().get(currentRoom);
        if(rm.get("character") != null){
            String character = rm.get("character");

            switch (character) {
                case "Tom":
                    isAnswerCorrect = tom.askQuestionCollectAndProcessResponse();
                    if (isAnswerCorrect) {
                        if (!inventory.getPlyrInv().contains(tom.getItem())) {
                            inventory.setPlyrInv(tom.getItem());
                            item = ANSI_PURPLE + "Tom has given you " + tom.getItem() + ANSI_RESET;
                        }
                    }
                    break;
                case "Jay":
                    isAnswerCorrect = jay.askQuestionCollectAndProcessResponse();
                    if (isAnswerCorrect) {
                        if (!inventory.getPlyrInv().contains(jay.getItem())) {
                            inventory.setPlyrInv(jay.getItem());
                            item = ANSI_PURPLE + "Jay has given you " + jay.getItem() + ANSI_RESET;
                        }
                    }
                    break;
                case "John":
                    isAnswerCorrect = john.askQuestionCollectAndProcessResponse();
                    if (isAnswerCorrect) {
                        if (!inventory.getPlyrInv().contains(john.getItem())) {
                            inventory.setPlyrInv(john.getItem());
                            item = ANSI_PURPLE + "John has given you a " + john.getItem() + ANSI_RESET;
                            if (inventory.getPlyrInv().contains("Box")){
                                cd.addTimeBuff();
                            }
                        }
                    }
                    break;
                case "Peter":
                    isAnswerCorrect = peter.askQuestionCollectAndProcessResponse();
                    if (isAnswerCorrect) {
                        try {
                            item = textPainter(bundle.getString("peter"));
                        }
                        catch(Exception e){
                            somethingWentWrong(e);
                        }
                    }
                    break;
                case "Zach":
                    isAnswerCorrect = zach.askQuestionCollectAndProcessResponse();
                    if (isAnswerCorrect) {
                        if (!inventory.getPlyrInv().contains(zach.getItem())) {
                            inventory.setPlyrInv(zach.getItem());
                            item = Recipe.recipeArt();
                        }
                    }
                    break;
                case "Nelly":
                    item = nelly.processQuestionAnswer(nelly.askTheQuestionAndCollectInput());
                    if (item.equals(nelly.getItem())) {
                        if (!inventory.getPlyrInv().contains(item)) {
                            inventory.setPlyrInv(item);
                            item = ANSI_PURPLE + "Nelly has given you a " + nelly.getItem() + ANSI_RESET;
                        }
                        else{
                            item = "";
                        }
                    }
                    break;
            }
        }
        else {
            readStoryLinesOutOfFile("noOne", 0);
    }
        return item;//return the item i guess
    }

    public ArrayList<String> getPlyrInv() {
        return plyrInv;
    }

    public void setPlyrInv(String item) {
        plyrInv.add(item);
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
