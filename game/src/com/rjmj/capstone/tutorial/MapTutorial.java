package com.rjmj.capstone.tutorial;

import com.rjmj.capstone.character.Color;

public class MapTutorial implements Color {


    public static void mapDisplay(String currentRoom) {
        switch(currentRoom) {
            case "HALL":
                System.out.println(ANSI_CYAN +
                        "___________________________________________________________________________________________\n" +
                        "|                            |                                |                             |\n" +
                        "|          Hall              |          Ball Room             |          Movie Room         |\n" +
                        "|         "+ANSI_YELLOW+"<< X >>"+ANSI_CYAN+"            |                                |                             |\n" +
                        "|    Move Choices: Right     |   Move Choices: Left, Right    |     Move Choices: Left      |\n" +
                        "|                            |                                |                             |\n" +
                        "|                            |                                |                             |\n" +
                        "-----------------------------|--------------------------------|-----------------------------|\n"
                        + ANSI_RESET
                );
                break;
            case "BALL ROOM":
                System.out.println(ANSI_CYAN +
                        "___________________________________________________________________________________________\n" +
                        "|                            |                                |                             |\n" +
                        "|          Hall              |          Ball Room             |          Movie Room         |\n" +
                        "|                            |           "+ANSI_YELLOW+"<< X >>"+ANSI_CYAN+"              |                             |\n" +
                        "|    Move Choices: Right     |   Move Choices: Left, Right    |     Move Choices: Left      |\n" +
                        "|                            |                                |                             |\n" +
                        "|                            |                                |                             |\n" +
                        "-----------------------------|--------------------------------|-----------------------------|\n"
                        + ANSI_RESET
                );
                break;
            case "MOVIE ROOM":
                System.out.println(ANSI_CYAN +
                        "___________________________________________________________________________________________\n" +
                        "|                            |                                |                             |\n" +
                        "|          Hall              |          Ball Room             |          Movie Room         |\n" +
                        "|                            |                                |           "+ANSI_YELLOW+"<< X >>"+ANSI_CYAN+"           |\n" +
                        "|    Move Choices: Right     |   Move Choices: Left, Right    |     Move Choices: Left      |\n" +
                        "|                            |                                |                             |\n" +
                        "|                            |                                |                             |\n" +
                        "-----------------------------|--------------------------------|-----------------------------|\n"
                        + ANSI_RESET
                );
                break;
        }
    }

}
