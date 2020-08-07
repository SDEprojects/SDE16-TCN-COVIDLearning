package com.rjmj.capstone.engines;

import com.rjmj.capstone.engine.UserInput;
import com.rjmj.capstone.player.Inventory;
import com.rjmj.capstone.room.Rooms;
import com.rjmj.capstone.timer.Countdown;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

public class MovementEngine {
    private String currentRoom = "DINING ROOM";
    private Rooms room = new Rooms();


    private String questionBuilder(){
        StringBuilder sb = new StringBuilder("Which direction would you like to go? (");
        String left,right,down,up;
        Map<String,String> rm = getRoom().getROOMS().get(getCurrentRoom());
        Set<String> roomKeys = rm.keySet();
        // Loop through keys to build custom question for player giving direction options
        for(String moveOption : roomKeys){
            if(moveOption.equals("left")){
                left = rm.get(moveOption);
                sb.append(" LEFT: " + left + ",");
            }
            else if(moveOption.equals("right")){
                right = rm.get(moveOption);
                sb.append(" RIGHT: " + right + ",");
            }
            else if(moveOption.equals("down")){
                down = rm.get(moveOption);
                sb.append(" DOWN: " + down + ",");
            }
            else if(moveOption.equals("up")){
                up = rm.get(moveOption);
                sb.append(" UP: " + up + ",");
            }
        }
        sb.append(" )");
        return sb.toString();

    }

    public String roomChoices(){
        UserInput input = new UserInput();
        return input.getInput(questionBuilder());
    }

    public void clearScreen() {
        for(int i = 0; i < 50; i++) {
            System.out.println("\b");
        }
    }

    public String changeRoom(Inventory inventory, String userChoice, Countdown cd) {
        clearScreen();
        String result = getCurrentRoom();
        Map<String,String> rm = getRoom().getROOMS().get(getCurrentRoom());
        if(rm.get("room").equals("Bedroom") && userChoice.equals("left")){
            result = inventory.talkToCharacter(getRoom(),"LIBRARY",inventory,cd);// force talking to Peter when going into Library
            setCurrentRoom(rm.get(userChoice).toUpperCase());
        }
        else if(rm.containsKey(userChoice)) {
            setCurrentRoom(rm.get(userChoice).toUpperCase());
            result = rm.get(userChoice).toUpperCase();
        }
        else {
            System.out.println("Invalid Selection, try again.");
        }

        return result;
    }
    public String getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(String currentRoom) {
        this.currentRoom = currentRoom;
    }

    public Rooms getRoom() {
        return room;
    }

}
