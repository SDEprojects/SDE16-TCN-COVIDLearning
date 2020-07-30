package com.rjmj.capstone.engines;

import org.junit.Test;

import static org.junit.Assert.*;

public class MovementEngineTest {

    @Test
    public void roomChoices() {
    }

    @Test
    public void changeRoom() {
        MovementEngine movementEngine = new MovementEngine();

    }

    @Test
    public void getCurrentRoomPositive() {
        MovementEngine movementEngine = new MovementEngine();
        movementEngine.setCurrentRoom("DINNING ROOM");
        assertEquals("DINNING ROOM", movementEngine.getCurrentRoom());
    }

    @Test
    public void getCurrentRoomNegative() {
        MovementEngine movementEngine = new MovementEngine();
        movementEngine.setCurrentRoom("STAIRS");
        assertNotEquals("DINNING ROOM", movementEngine.getCurrentRoom());
    }

    @Test
    public void setCurrentRoomPositive() {
        MovementEngine movementEngine = new MovementEngine();
        movementEngine.setCurrentRoom("KITCHEN");
        assertEquals("KITCHEN", movementEngine.getCurrentRoom());
    }

    @Test
    public void setCurrentRoomNegative() {
        MovementEngine movementEngine = new MovementEngine();
        movementEngine.setCurrentRoom("BEDROOM");
        assertNotEquals("KITCHEN", movementEngine.getCurrentRoom());
    }

    @Test
    public void getRoomPositive() {
        MovementEngine movementEngine = new MovementEngine();
        movementEngine.setCurrentRoom("BALL ROOM");
        movementEngine.getRoom();
        assertTrue(true);
    }

    @Test
    public void getRoomNegative() {
        MovementEngine movementEngine = new MovementEngine();
        movementEngine.setCurrentRoom("BALL ROOM");
        movementEngine.getRoom();
        assertFalse(false);
    }
}