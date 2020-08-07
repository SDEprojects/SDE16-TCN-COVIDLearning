package com.rjmj.capstone.room;

import com.rjmj.capstone.Color;
import com.rjmj.capstone.engines.MovementEngine;
import com.rjmj.capstone.player.Inventory;
import com.rjmj.capstone.timer.Countdown;

import static java.util.Map.entry;

import java.util.Map;
import java.util.Set;

public class Rooms implements Color {

    private Map<String,Map<String,String>> ROOMS = Map.ofEntries(
            entry("DINING ROOM", Map.of(
                    "room", "Dining Room",
                    "character", "Nelly",
                    "right", "Hall",
                    "locked", "true",
                    "glass", "key")),
            entry("HALL",Map.of(
                    "room", "Hall",
                    "right", "Ball Room",
                    "left", "Dining Room",
                    "down", "Kitchen")),
            entry("BALL ROOM", Map.of(
                    "room", "Ball Room",
                    "character", "John",
                    "left", "Hall",
                    "right", "Movie Room")),
            entry("MOVIE ROOM", Map.of(
                    "room", "Movie Room",
                    "character", "Jay",
                    "left", "Ball Room",
                    "right", "Stairs")),
            entry("STAIRS", Map.of(
                    "room", "Stairs",
                    "item", "Box",
                    "left", "Down Stairs Hall",
                    "up", "Movie Room")),
            entry("DOWN STAIRS HALL", Map.of(
                    "room", "Down Stairs Hall",
                    "item", "Beaker",
                    "left", "Bedroom",
                    "right", "Stairs")),
            entry("BEDROOM", Map.of(
                    "room", "Bedroom",
                    "item", ANSI_GREEN + "Green Liquid" + ANSI_RESET,
                    "left", "Library",
                    "right", "Down Stairs Hall")),
            entry("LIBRARY", Map.of(
                    "room", "Library",
                    "character", "Peter",
                    "left", "Cave",
                    "right", "Lab",
                    "up", "Bedroom")),
            entry("CAVE", Map.of(
                    "room", "Cave",
                    "character", "Zach",
                    "right", "Library")),
            entry("LAB", Map.of(
                    "room", "Lab",
                    "item", "Needle",
                    "left", "Library",
                    "picture", GameTextArt.labDisplay())),
            entry("KITCHEN",Map.of(
                    "room", "Kitchen",
                    "character", "Tom",
                    "up", "Hall",
                    "left", "bathroom",
                    "picture", GameTextArt.kitchenDisplay())),
            entry("BATHROOM",Map.of(
                    "room", "Bathroom",
                    "item", "Plunger",
                    "right", "Kitchen",
                    "picture", GameTextArt.bathroomDisplay()))
    );

    public String lookAround(String currentRoom, Inventory inventory) {
        MovementEngine movementEngine = new MovementEngine();
        movementEngine.clearScreen();
        Map<String,String> rm = ROOMS.get(currentRoom);
        StringBuilder sb = new StringBuilder();
        sb.append("\nAs you look around the " + currentRoom + ":\n");
        Set<String> keys = rm.keySet();
        String[] keyArr = keys.toArray(new String[keys.size()]);
        for(String key : keyArr) {
            if(!inventory.getPlyrInv().contains(rm.get(key))) {
                if (rm.get("item") != null && "item".equals(key)) {
                    String item = rm.get("item");
                    sb.append("  you see a " + item + "\n");
                }
                if (rm.get("character") != null && "character".equals(key)) {
                    String character = rm.get("character");
                    sb.append("  " + character + " is in the room\n");
                }
                if (rm.get("left") != null && "left".equals(key)) {
                    sb.append("  a door to the " + rm.get("left") + " is to the LEFT\n");
                }
                if (rm.get("right") != null && "right".equals(key)) {
                    sb.append("  a door to the " + rm.get("right") + " is to the RIGHT\n");
                }
                if (rm.get("up") != null && "up".equals(key)) {
                    sb.append("  a door to the " + rm.get("up") + " is UP from the " + currentRoom + "\n");
                }
                if (rm.get("down") != null && "down".equals(key)) {
                    sb.append("  a door to the " + rm.get("down") + " is DOWN from the " + currentRoom + "\n");
                }
            }
        }
        String result = sb.toString();
        return result;
    }

    public String getItem(Inventory inventory, String currentRoom, Countdown cd) {
        String result = "";
        Map<String,String> rm = ROOMS.get(currentRoom);
        if(rm.get("item") != null) {
            //add a check for if the item is a box and you have the key in the inventory to add the time buff to the timer
            if(inventory.getPlyrInv().contains(rm.get("item"))){
                result = "You already took the " + rm.get("item");
            }
            else if((rm.get("item").equals("Box") && inventory.getPlyrInv().contains("Key"))) {
                result = ANSI_PURPLE + "You see that the box is locked so you use your key to unlock it\n" +
                        "this is no ordinary box, you just unlocked Time itself and rolled back 1 minute!" + ANSI_RESET;
                cd.addTimeBuff();
            }
            else {
                inventory.setPlyrInv(rm.get("item"));
                result = "The " + rm.get("item") + ANSI_RESET + " was added to your inventory\n" +
                        "You now have " + inventory.getPlyrInv().size() + " items in your inventory:";
            }
        }
        else {
            result = "there aren't any items to take in here!";
        }
        return result;
    }

    public Map<String, Map<String,String>> getROOMS() {
        return ROOMS;
    }
}
