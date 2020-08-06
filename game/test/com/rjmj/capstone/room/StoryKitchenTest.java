package com.rjmj.capstone.room;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.Scanner;

import static org.junit.Assert.*;

public class StoryKitchenTest {

    String currentDirectory = null;

    @Before
    public void get_fileDirectory() {
        // Get current directory where a text file is
        currentDirectory = System.getProperty("user.dir");
        System.out.println(currentDirectory);
        currentDirectory = currentDirectory + "/game/test/com/rjmj/capstone/room/files/";
    }

    @Test
    public void testRun(){
        Scanner sc = setUpScanner(currentDirectory, "StoryKitchenTest.txt");
        StoryKitchen storyKitchen = new StoryKitchen();
        storyKitchen.enter(sc);
        assertEquals("move right", storyKitchen.getNextAction());
        //storyKitchen.enter(scanner);
    }

    private Scanner setUpScanner(String fileDirectory, String filename) {
        Scanner sc = null;
        try{
            String path = fileDirectory + filename;
            sc = new Scanner(new File(path));
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return sc;
    }
}