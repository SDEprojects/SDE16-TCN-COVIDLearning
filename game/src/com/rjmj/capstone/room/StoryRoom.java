package com.rjmj.capstone.room;

import com.rjmj.capstone.Color;

import java.util.ResourceBundle;
import java.util.Scanner;

public interface StoryRoom extends StoryRoomResourceBundle {

    public void enter(Scanner scanner);
    public String getNextAction();

}
