package com.rjmj.capstone.room;

import com.rjmj.capstone.Color;

import java.util.ArrayList;
import java.util.Scanner;

public interface StoryRoom extends StoryRoomResourceBundle {

    public default void displayMessageOnlyFirstTimeComingFromDifferentRoom(String currentRoom, ArrayList pi, String displayTimeInsideArt){
        System.out.println("\n******************************");
        System.out.println("Current location : " + currentRoom);
        System.out.println("Possession : " + pi);
        System.out.println(displayTimeInsideArt);
        System.out.println("******************************\n");
    }
    public void enter(Scanner scanner);
    public String getNextAction();

}
