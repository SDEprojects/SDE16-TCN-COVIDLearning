package com.rjmj.capstone.player;

import com.rjmj.capstone.Color;

import java.util.ResourceBundle;

public interface PlayerResourceBundle extends Color {

    ///////////////////////// For resource bundle /////////////////////////
    final String PATH = "com.rjmj.capstone.player.files.";
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
