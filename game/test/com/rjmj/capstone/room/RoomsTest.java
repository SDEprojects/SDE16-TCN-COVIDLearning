package com.rjmj.capstone.room;

import com.rjmj.capstone.engines.MovementEngine;
import com.rjmj.capstone.player.Inventory;
import com.rjmj.capstone.player.Player;
import com.rjmj.capstone.timer.Countdown;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RoomsTest {
    Rooms room;
    Player p1;
    MovementEngine movementEngine;
    Countdown cd;
    @Before
    public void setUp() throws Exception {
        movementEngine = new MovementEngine();
        cd = new Countdown();
        p1 = new Player();
        room = new Rooms();
    }

    @Test
    public void lookAroundPositive() {
        movementEngine.setCurrentRoom("HALL");
        String msg = room.lookAround(movementEngine.getCurrentRoom(), p1.getInventory());
        assertEquals(161, msg.length());
    }
    @Test
    public void lookAroundBeforeAndAfterItemTakenPositive() {
        movementEngine.setCurrentRoom("STAIRS");
        String beforeMsg = room.lookAround(movementEngine.getCurrentRoom(), p1.getInventory());
        assertEquals(145, beforeMsg.length());
        room.getItem(p1.getInventory(), movementEngine.getCurrentRoom(), cd);
        String afterMsg = room.lookAround(movementEngine.getCurrentRoom(), p1.getInventory());
        assertEquals(129, afterMsg.length());
    }

    @Test
    public void getItemPositive() {
        movementEngine.setCurrentRoom("STAIRS");
        String item = room.getItem(p1.getInventory(), movementEngine.getCurrentRoom(), cd);
        String expectedReturn = "The Box\u001B[0m was added to your inventory\nYou now have 1 items in your inventory:";
        assertEquals(expectedReturn, item);
        assertEquals(1, p1.getInventory().getPlyrInv().size());
    }
    @Test
    public void getItemNegative() {
        movementEngine.setCurrentRoom("HALL");
        room.getItem(p1.getInventory(), movementEngine.getCurrentRoom(), cd);
        assertEquals(0, p1.getInventory().getPlyrInv().size());
    }
    @Test
    public void getItemIfItemInInventoryNegative() {
        movementEngine.setCurrentRoom("STAIRS");
        room.getItem(p1.getInventory(), movementEngine.getCurrentRoom(), cd);
        String item = room.getItem(p1.getInventory(), movementEngine.getCurrentRoom(), cd);
        String expectedReturn = "You already took the Box";
        assertEquals(expectedReturn, item);
        assertEquals(1, p1.getInventory().getPlyrInv().size());
    }
}