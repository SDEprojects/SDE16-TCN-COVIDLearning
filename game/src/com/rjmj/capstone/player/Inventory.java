package com.rjmj.capstone.player;

import com.rjmj.capstone.character.*;
import com.rjmj.capstone.engines.MovementEngine;
import com.rjmj.capstone.room.Rooms;
import com.rjmj.capstone.timer.Countdown;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class Inventory {
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
                            item = "Tom has given you " + tom.getItem();
                        }
//                    } else {
//                        talkToCharacter(room, currentRoom, inventory, cd);
                    }
                    break;
                case "Jay":
                    isAnswerCorrect = jay.askQuestionCollectAndProcessResponse();
                    if (isAnswerCorrect) {
                        if (!inventory.getPlyrInv().contains(jay.getItem())) {
                            inventory.setPlyrInv(jay.getItem());
                            item = "Jay has given you " + jay.getItem();
                        }
//                    } else {
//                        talkToCharacter(room, currentRoom, inventory, cd);
                    }
                    break;
                case "John":
                    isAnswerCorrect = john.askQuestionCollectAndProcessResponse();
                    if (isAnswerCorrect) {
                        if (!inventory.getPlyrInv().contains(john.getItem())) {
                            inventory.setPlyrInv(john.getItem());
                            item = "John has given you a " + john.getItem();
                            if (inventory.getPlyrInv().contains("Box")){
                                cd.addTimeBuff();
                            }
                        }
//                    } else {
//                        talkToCharacter(room, currentRoom, inventory, cd);
                    }
                    break;
                case "Peter":
                    isAnswerCorrect = peter.askQuestionCollectAndProcessResponse();
                    if (isAnswerCorrect) {
                        item = "\nPeter has granted you access to the Library " +
                                "and there is a secret CAVE behind the bookshelves!!!\n" +
                                "and a Lab behind another set of books.";
//                    } else {
//                        talkToCharacter(room, currentRoom, inventory,cd);
                    }
                    break;
                case "Zach":
                    isAnswerCorrect = zach.askQuestionCollectAndProcessResponse();
                    if (isAnswerCorrect) {
                        if (!inventory.getPlyrInv().contains(zach.getItem())) {
                            inventory.setPlyrInv(zach.getItem());
                            item = Recipe.recipeArt();
                        }
//                    } else {
//                        talkToCharacter(room, currentRoom, inventory, cd);
                    }
                    break;
                case "Nelly":
                    item = nelly.processQuestionAnswer(nelly.askTheQuestionAndCollectInput());
                    if (item.equals(nelly.getItem())) {
                        if (!inventory.getPlyrInv().contains(item)) {
                            inventory.setPlyrInv(item);
                        }
//                    } else {
//                        talkToCharacter(room, currentRoom, inventory,cd);
                    }
                    break;
            }
        }
        else {
            System.out.println("No one is around, you say hello to yourself.\n");
    }
        return item;//return the item i guess
    }

    public ArrayList<String> getPlyrInv() {
        return plyrInv;
    }

    public void setPlyrInv(String item) {
        plyrInv.add(item);
    }
}
