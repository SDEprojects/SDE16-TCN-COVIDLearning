package com.rjmj.capstone.character;

import org.junit.Test;

import static org.junit.Assert.*;

public class JohnTest {

    // You will have to comment out the askTheQuestionAndCollectInput() method inside Jay for these tests to pass.
    // Otherwise, the test will go right into scanner and break.
    @Test
    public void processQuestionAnswerPositiveC() throws InterruptedException {
        John john = new John();
        assertEquals("Key", john.processQuestionAnswer("C"));
    }

    @Test
    public void processQuestionAnswerNegativeA() throws InterruptedException {
        John john = new John();
        assertNotEquals("Key", john.processQuestionAnswer("A"));
    }

    @Test
    public void processQuestionAnswerNegativeB() throws InterruptedException {
        John john = new John();
        assertNotEquals("Key", john.processQuestionAnswer("B"));
    }

    @Test
    public void processQuestionAnswerNegativeD() throws InterruptedException {
        John john = new John();
        assertNotEquals("Key", john.processQuestionAnswer("D"));
    }

    // Simple Getter/Setter Tests
    @Test
    public void getItemPositive() {
        John john = new John();
        assertEquals("Key", john.getItem());
    }

    @Test
    public void getItemNegative() {
        John john = new John();
        assertNotEquals("Blue Liquid", john.getItem());
    }

    @Test
    public void setQuestionAnswerPositive() {
        John john = new John();
        john.setQuestionAnswer("A");
        assertEquals("A", john.getQuestionAnswer());
    }

    @Test
    public void setQuestionAnswerNegative() {
        John john = new John();
        john.setQuestionAnswer("C");
        assertNotEquals("A", john.getQuestionAnswer());
    }
}