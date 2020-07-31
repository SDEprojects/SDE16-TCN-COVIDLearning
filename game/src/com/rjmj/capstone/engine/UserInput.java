package com.rjmj.capstone.engine;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class UserInput {
//    File file = new File("/Users/michaellennerblom/tlg-cap/capstone/game/src/com/rjmj/capstone/engine/input.txt");
    Scanner sc = new Scanner(System.in);

    public String getInput(String question){
        System.out.println(question);
        String userChoice = sc.nextLine().toLowerCase().trim();
        return userChoice;
    }


    //this pardner prompts the player for precepts (lol... it gets commands)
    public String[] getUserCommand(String question) {
        String command = getInput(question);
        return command.toLowerCase().split("\\s+", 2);
    }



}


