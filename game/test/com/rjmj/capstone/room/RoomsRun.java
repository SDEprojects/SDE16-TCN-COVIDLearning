package com.rjmj.capstone.room;

import com.rjmj.capstone.player.Player;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import java.sql.SQLOutput;

public class RoomsRun {

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(RoomsTest.class);
        for(Failure failure : result.getFailures())
        {
            System.out.println(failure.toString());
        }
        System.out.println("Result== "+result.wasSuccessful() + ";" + "\nRun Time==" +result.getRunTime() + ";" + "\nRun Count==" +result.getRunCount() );
            }
    }

