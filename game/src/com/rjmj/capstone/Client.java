package com.rjmj.capstone;

import com.rjmj.capstone.engine.Parser;
import com.rjmj.capstone.player.Player;

import java.io.IOException;

public class Client{
    public static void main(String[] args) {
        try {
            Player player = new Player();
            player.play();
        }
        catch(Exception e){
            System.out.println("****** Something went wrong ******");
            System.out.println("Place: main() in Client");
            System.out.println("Exception message : " + e.getMessage());
        }
    }
}