package com.rjmj.capstone.character;

import org.junit.Test;

import static org.junit.Assert.*;

public class TomTest {

    @Test
    public void processQuestionAnswerPositivB() throws InterruptedException {
        Tom tom = new Tom();
        assertEquals("Blue Liquid", tom.processQuestionAnswer("B"));
    }

    @Test
    public void processQuestionAnswerNegativeA() throws InterruptedException {
        Tom tom = new Tom();
        assertNotEquals("Blue Liquid", tom.processQuestionAnswer("A"));
    }

    @Test
    public void processQuestionAnswerNegativeC() throws InterruptedException {
        Tom tom = new Tom();
        assertNotEquals("Blue Liquid", tom.processQuestionAnswer("C"));
    }

    @Test
    public void processQuestionAnswerNegativeD() throws InterruptedException {
        Tom tom = new Tom();
        assertNotEquals("Blue Liquid", tom.processQuestionAnswer("D"));
    }

    @Test
    public void getItemPositive() {
        Tom tom = new Tom();
        assertEquals("Blue Liquid", tom.getItem());
    }

    @Test
    public void getQuestionAnswerPositive() {
        Tom tom = new Tom();
        tom.setQuestionAnswer("A");
        assertEquals("A", tom.getQuestionAnswer());
    }
}