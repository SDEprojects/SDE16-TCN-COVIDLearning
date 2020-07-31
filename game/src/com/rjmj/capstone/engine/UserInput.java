package com.rjmj.capstone.engine;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class UserInput {
//    File file = new File("/Users/michaellennerblom/tlg-cap/capstone/game/src/com/rjmj/capstone/engine/input.txt");
    private Scanner sc = new Scanner(System.in);


    public String getInput(String question){
        System.out.println(question);
        String userChoice = sc.nextLine().toLowerCase().trim();
        return userChoice;
    }


}


