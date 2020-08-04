package com.rjmj.capstone.room;

import java.util.Scanner;

public interface StoryRoom {

    public void enter(Scanner scanner) throws InterruptedException;
    public String getNextAction();

}
