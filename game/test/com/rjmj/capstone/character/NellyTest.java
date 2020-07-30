package com.rjmj.capstone.character;

import org.junit.Test;

import static org.junit.Assert.*;

public class NellyTest {

    // Getter/Setter Unit Tests
    @Test
    public void getItemPositive() {
        Nelly nelly = new Nelly();
        assertEquals("Syringe", nelly.getItem());
    }

    @Test
    public void getItemNegative() {
        Nelly nelly = new Nelly();
        assertNotEquals("Key", nelly.getItem());
    }

    // No more tests are needed for this as any input is accepted, so only that one input that gives Syringe is needed.
    @Test
    public void setQuestionAnswerPositive() {
        Nelly nelly = new Nelly();
        assertEquals("Syringe", nelly.processQuestionAnswer("Start"));
    }
}