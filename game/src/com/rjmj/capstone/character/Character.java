package com.rjmj.capstone.character;

import java.util.ResourceBundle;

public interface Character extends Color{

    int SLEEP_DURATION_MS = 650;

    // This will warn you that the return value is never used, but it is in the characters.
    String askTheQuestionAndCollectInput();

    String processQuestionAnswer(String questionAnswer);

    public default void somethingWentWrong(Exception e){
        System.out.println("****** Something went wrong ******");
        System.out.println("Place: " + getClass().getName());
        System.out.println("Exception message : " + e.getMessage());
    }


    ///////////////////////// For resource bundle /////////////////////////
    final String PATH = "com.rjmj.capstone.character.files.";
    ResourceBundle.Control rbc = ResourceBundle.Control.getControl(ResourceBundle.Control.FORMAT_DEFAULT);
    public final int MAX_ITERATION_DISPLAY_STORIES = 10;


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
