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

    public String talkToCharacter(Rooms room, String currentRoom, Inventory inventory, Countdown cd) throws IOException, InterruptedException {
        MovementEngine movementEngine = new MovementEngine();
        movementEngine.clearScreen();
        String item = "";
        Map<String,String> rm = room.getROOMS().get(currentRoom);
        if(rm.get("character") != null){
            String character = rm.get("character");

            switch (character) {
                case "Tom":
                    item = tom.processQuestionAnswer(tom.askTheQuestionAndCollectInput());
                    if (item.equals(tom.getItem())) {
                        if (!inventory.getPlyrInv().contains(item)) {
                            inventory.setPlyrInv(item);
                            item = "Tom has given you " + item;
                        }
                    } else {
                        talkToCharacter(room, currentRoom, inventory, cd);
                    }
                    break;
                case "Jay":
                    item = jay.askQuestionCollectAndProcessResponse(1);
                    //item = jay.processQuestionAnswer(jay.askTheQuestionAndCollectInput());
                    if (item.equals(jay.getItem())) {
                        if (!inventory.getPlyrInv().contains(item)) {
                            inventory.setPlyrInv(item);
                            item = "Jay has given you " + item;
                        }
                    } else {
                        talkToCharacter(room, currentRoom, inventory, cd);
                    }
                    break;
                case "John":
                    item = john.processQuestionAnswer(john.askTheQuestionAndCollectInput());
                    if (item.equals(john.getItem())) {
                        if (!inventory.getPlyrInv().contains(item)) {
                            inventory.setPlyrInv(item);
                            item = "John has given you a " + item;
                            if (inventory.getPlyrInv().contains("Box")){
                                cd.addTimeBuff();
                            }
                        }
                    } else {
                        talkToCharacter(room, currentRoom, inventory, cd);
                    }
                    break;
                case "Peter":
                    item = peter.processQuestionAnswer(peter.askTheQuestionAndCollectInput());
                    if (item.equals(peter.getItem())) {
                        item = "\nPeter has granted you access to the Library " +
                                "and there is a secret CAVE behind the bookshelves!!!\n" +
                                "and a Lab behind another set of books.";
                    } else {
                        talkToCharacter(room, currentRoom, inventory,cd);
                    }
                    break;
                case "Zach":
                    item = zach.processQuestionAnswer(zach.askTheQuestionAndCollectInput());
                    if (item.equals(zach.getItem())) {
                        if (!inventory.getPlyrInv().contains(item)) {
                            inventory.setPlyrInv(item);
                            item = Recipe.recipeArt();
                        }
                    } else {
                        talkToCharacter(room, currentRoom, inventory, cd);
                    }
                    break;
                case "Nelly":
                    item = nelly.processQuestionAnswer(nelly.askTheQuestionAndCollectInput());
                    if (item.equals(nelly.getItem())) {
                        if (!inventory.getPlyrInv().contains(item)) {
                            inventory.setPlyrInv(item);
                        }
                    } else {
                        talkToCharacter(room, currentRoom, inventory,cd);
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
