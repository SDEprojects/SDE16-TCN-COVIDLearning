package com.rjmj.capstone.room;

import com.rjmj.capstone.character.*;
import com.rjmj.capstone.engine.ParserTest;
import com.rjmj.capstone.engines.MovementEngineTest;
import com.rjmj.capstone.player.PlayerTest;
import com.rjmj.capstone.timer.CountdownTest;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class RunClassesRoom {

          public static void main(String[] args) {
            Result result = JUnitCore.runClasses(RoomsTest.class);
                  /*  PlayerTest.class,
                    MovementEngineTest.class,
                    ParserTest.class,
                    CountdownTest.class, JayTest.class, JohnTest.class, NellyTest.class, PeterTest.class, TomTest.class, ZachTest.class); */
            for(Failure failure : result.getFailures())
            {
                System.out.println(failure.toString());
            }
            System.out.println("Result== "+result.wasSuccessful() + ";" + "\nRun Time==" +result.getRunTime() + ";" + "\nRun Count==" +result.getRunCount() );
        }
    }


