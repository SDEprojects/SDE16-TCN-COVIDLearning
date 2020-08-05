package com.rjmj.capstone.room;

import com.rjmj.capstone.ExceptionMessage;

import java.util.Scanner;

public interface StoryRoom extends ExceptionMessage {

    public void enter(Scanner scanner);
    public String getNextAction();

}
