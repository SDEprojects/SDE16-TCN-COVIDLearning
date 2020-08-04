package com.rjmj.capstone;

import com.rjmj.capstone.engine.Parser;
import com.rjmj.capstone.player.Player;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import java.io.IOException;

public class Client {
    public static void main(String[] args) throws IOException, InterruptedException {

        Player player = new Player();
        //player.playGame(player.play());
        player.play();
    }
}