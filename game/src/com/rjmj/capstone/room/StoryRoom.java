package com.rjmj.capstone.room;

import java.util.ArrayList;
import java.util.Scanner;

public interface StoryRoom extends StoryRoomResourceBundle {

    public default void displayMessageOnlyFirstTimeComingFromDifferentRoom(String currentRoom, ArrayList pi, String displayTimeInsideArt){

        switch(currentRoom) {
            case "DINING ROOM": System.out.println(GameTextArt.diningRoomDisplay()); break;
            case "HALL": System.out.println(GameTextArt.hallwaysDisplay()); break;
            case "KITCHEN": System.out.println(GameTextArt.kitchenDisplay()); break;
            case "BATHROOM": System.out.println(GameTextArt.bathroomDisplay()); break;
            case "MOVIE ROOM": System.out.println(GameTextArt.movieRoomDisplay()); break;
            case "STAIRS": System.out.println(GameTextArt.stairsDisplay()); break;
            case "DOWN STAIRS HALL": System.out.println(GameTextArt.downstairsDisplay()); break;
            case "BEDROOM": System.out.println(GameTextArt.bedroomDisplay()); break;
            case "LIBRARY": System.out.println(GameTextArt.libraryDisplay()); break;
            case "CAVE": System.out.println(GameTextArt.caveDisplay()); break;
            case "LAB": System.out.println(GameTextArt.labDisplay()); break;
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
