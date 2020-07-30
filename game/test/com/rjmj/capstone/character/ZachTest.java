package com.rjmj.capstone.character;

import org.junit.Test;

import static org.junit.Assert.*;

public class ZachTest {

    @Test
    public void processQuestionAnswerPositiveA() throws InterruptedException {
        Zach zach = new Zach();
        assertEquals("Recipe", zach.processQuestionAnswer("A"));
    }

    @Test
    public void processQuestionAnswerNegativeB() throws InterruptedException {
        Zach zach = new Zach();
        assertNotEquals("Recipe", zach.processQuestionAnswer("B"));
    }

    @Test
    public void processQuestionAnswerNegativeC() throws InterruptedException {
        Zach zach = new Zach();
        assertNotEquals("Recipe", zach.processQuestionAnswer("C"));
    }

    @Test
    public void processQuestionAnswerNegativeD() throws InterruptedException {
        Zach zach = new Zach();
        assertNotEquals("Recipe", zach.processQuestionAnswer("D"));
    }

    @Test
    public void getItemPositive() {
        Zach zach = new Zach();
        assertEquals("Recipe", zach.getItem());
    }

    @Test
    public void getQuestionAnswerPositive() {
        Zach zach = new Zach();
        zach.setQuestionAnswer("A");
        assertEquals("A", zach.getQuestionAnswer());
    }
}
