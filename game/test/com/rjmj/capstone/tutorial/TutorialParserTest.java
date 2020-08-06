package com.rjmj.capstone.tutorial;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TutorialParserTest {

    TutorialParser tutorialParser = null;

    @Before
    public void setUp(){
        tutorialParser = new TutorialParser();
    }
    @Test
    public void test_invalid_move(){
        String[] result = tutorialParser.parseAvailableActions("move");
        assertEquals(result[0], "X");
        assertEquals(result[1], "");
    }
    @Test
    public void test_valid_move_input_run(){
        String[] result = tutorialParser.parseAvailableActions("run left");
        assertEquals(result[0], "MOVE");
        assertEquals(result[1], "LEFT");
    }
    @Test
    public void test_valid_move_input_enter(){
        String[] result = tutorialParser.parseAvailableActions("enter right");
        assertEquals(result[0], "MOVE");
        assertEquals(result[1], "RIGHT");
    }
    @Test
    public void test_invalid_move_direction_input_move(){
        String[] result = tutorialParser.parseAvailableActions("enter south");
        assertEquals(result[0], "X");
        assertEquals(result[1], "");
    }
    @Test
    public void test_valid_examine(){
        String[] result = tutorialParser.parseAvailableActions("examine");
        assertEquals(result[0], "LOOK AROUND");
    }
    @Test
    public void test_valid_lookAround(){
        String[] result = tutorialParser.parseAvailableActions("look around");
        assertEquals(result[0], "LOOK AROUND");
    }

}