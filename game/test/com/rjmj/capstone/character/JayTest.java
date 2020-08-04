package com.rjmj.capstone.character;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class JayTest {

    Jay jay = null;

    @Before
    public void setUp(){
        jay = new Jay();
    }

    //@Test
    //public void testLoadQuiz(){
    //    jay.askTheQuestionAndCollectInput();
    //}

//    @Test
//    public void processQuestionAnswerPositiveC() throws IOException, InterruptedException {
//        String input = "C";
//        Jay jay = new Jay();
//        String expectedString = "\u001B[31m" + "Red Liquid" + "\u001B[36m";
//        assertEquals(expectedString, jay.processQuestionAnswer(input));
//    }
//
//    // You will have to comment out the askTheQuestionAndCollectInput() method inside Jay for these tests to pass.
//    // Otherwise, the test will go right into scanner and break.
//    @Test
//    public void processQuestionAnswerNegativeA() throws IOException, InterruptedException {
//        String input = "A";
//        Jay jay = new Jay();
//        assertNotEquals("Red Liquid", jay.processQuestionAnswer(input));
//    }
//
//    @Test
//    public void processQuestionAnswerNegativeB() throws IOException, InterruptedException {
//        String input = "B";
//        Jay jay = new Jay();
//        assertNotEquals("Red Liquid", jay.processQuestionAnswer(input));
//    }
//
//    @Test
//    public void processQuestionAnswerNegativeD() throws IOException, InterruptedException {
//        String input = "D";
//        Jay jay = new Jay();
//        assertNotEquals("Red Liquid", jay.processQuestionAnswer(input));
//    }
//
//    // Simple Getter/Setter Tests
//    @Test
//    public void setQuestionAnswerAPositive() {
//        Jay jay = new Jay();
//        jay.setQuestionAnswer("A");
//        assertEquals("A", jay.getQuestionAnswer());
//    }
//
//    @Test
//    public void setQuestionAnswerBPositive() {
//        Jay jay = new Jay();
//        jay.setQuestionAnswer("B");
//        assertEquals("B", jay.getQuestionAnswer());
//    }
//
//    @Test
//    public void setQuestionAnswerCPositive() {
//        Jay jay = new Jay();
//        jay.setQuestionAnswer("C");
//        assertEquals("C", jay.getQuestionAnswer());
//    }
//
//    @Test
//    public void setQuestionAnswerDPositive() {
//        Jay jay = new Jay();
//        jay.setQuestionAnswer("D");
//        assertEquals("D", jay.getQuestionAnswer());
//    }
//
//    @Test
//    public void getItemPositive() {
//        Jay jay = new Jay();
//        String expectedString = "\u001B[31m" + "Red Liquid" + "\u001B[36m";
//        assertEquals(expectedString, jay.getItem());
//    }
//
//    @Test
//    public void getItemNegative() {
//        Jay jay = new Jay();
//        assertNotEquals("Blue Liquid", jay.getItem());
//    }
}