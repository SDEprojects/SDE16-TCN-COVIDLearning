package com.rjmj.capstone.character;

import java.io.IOException;

public interface Character {

    int SLEEP_DURATION_MS = 650;


    // This will warn you that the return value is never used, but it is in the characters.
    String askTheQuestionAndCollectInput();

    String processQuestionAnswer(String questionAnswer);

    public default void somethingWentWrong(Exception e){
        System.out.println("****** Something went wrong ******");
        System.out.println("Place: " + getClass().getName());
        System.out.println("Exception message : " + e.getMessage());
    }
}
