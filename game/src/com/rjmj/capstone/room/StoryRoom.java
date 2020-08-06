package com.rjmj.capstone.room;

import com.rjmj.capstone.ExceptionMessage;

import java.util.ResourceBundle;
import java.util.Scanner;

public interface StoryRoom extends ExceptionMessage {

    public void enter(Scanner scanner);
    public String getNextAction();


    ///////////////////////// For resource bundle /////////////////////////
    final String PATH = "com.rjmj.capstone.room.files.";
    ResourceBundle.Control rbc = ResourceBundle.Control.getControl(ResourceBundle.Control.FORMAT_DEFAULT);
    public final int MAX_ITERATION_DISPLAY_STORIES = 30;


    public default void displayStoryLineByLine(String msg, int SLEEP_DURATION_MS){
        try{
            Thread.sleep(SLEEP_DURATION_MS);
            System.out.println(msg);
        }
        catch (Exception e){
            somethingWentWrong(e);
            System.out.println("Please check at : \"Thread.sleep(SLEEP_DURATION_MS)\"");
        }
    }
}
