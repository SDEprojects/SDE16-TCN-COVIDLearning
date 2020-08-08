package com.rjmj.capstone.room;

import java.util.ArrayList;
import java.util.Scanner;

public interface StoryRoom extends StoryRoomResourceBundle {

    public default void displayMessageOnlyFirstTimeComingFromDifferentRoom(String currentRoom, ArrayList pi, String displayTimeInsideArt){

        switch(currentRoom) {
            case "BATHROOM":
                System.out.println(GameTextArt.bathroomDisplay());
                break;
            case "KITCHEN":
                System.out.println(GameTextArt.kitchenDisplay());
                break;
            case "LAB":
                System.out.println(GameTextArt.labDisplay());
                break;
        }

        System.out.println(ANSI_WHITE+"\n******************************");
        System.out.println("Current location : "+ANSI_RESET + currentRoom);
        System.out.println(ANSI_WHITE + "Possession : "+ANSI_RESET + pi);
        System.out.println(ANSI_WHITE + "Remaining time : "+ANSI_RESET + displayTimeInsideArt);
        System.out.println(ANSI_WHITE+"******************************\n"+ ANSI_RESET);
    }
    public void enter(Scanner scanner);
    public String getNextAction();

}
