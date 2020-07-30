package com.rjmj.capstone.character;

import org.junit.Test;

import static org.junit.Assert.*;

public class PeterTest {

    @Test
    public void processQuestionAnswerPositiveD() throws InterruptedException {
        Peter peter = new Peter();
        assertEquals("The Book of Knowledge", peter.processQuestionAnswer("D"));
    }

    @Test
    public void processQuestionAnswerNegativeA() throws InterruptedException {
        Peter peter = new Peter();
        assertNotEquals("The Book of Knowledge", peter.processQuestionAnswer("A"));
    }

    @Test
    public void processQuestionAnswerNegativeB() throws InterruptedException {
        Peter peter = new Peter();
        assertNotEquals("The Book of Knowledge", peter.processQuestionAnswer("B"));
    }

    @Test
    public void processQuestionAnswerNegativeC() throws InterruptedException {
        Peter peter = new Peter();
        assertNotEquals("The Book of Knowledge", peter.processQuestionAnswer("C"));
    }

    @Test
    public void getItemPositive() {
        Peter peter = new Peter();
        assertEquals("The Book of Knowledge", peter.getItem());
    }

    @Test
    public void getQuestionAnswerPositive() {
        Peter peter = new Peter();
        peter.setQuestionAnswer("A");
        assertEquals("A", peter.getQuestionAnswer());
    }
}