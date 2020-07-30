package com.rjmj.capstone.timer;

import org.junit.Test;

import static org.junit.Assert.*;

public class CountdownTest {
    Countdown cd = new Countdown();

    @Test
    public void addTimeBuffPositive() {
        cd.addTimeBuff();
        assertEquals("Time remaining: 11:00", cd.displayTimeInsideArt());
    }
    @Test
    public void addTimeBuffPositiveAfterTimeStart() throws InterruptedException {
        cd.startTimer();
        Thread.sleep(1800);
        cd.addTimeBuff();
        assertEquals("Time remaining: 10:58", cd.displayTimeInsideArt());
    }
    @Test
    public void addTimeBuffPositiveTimeAtOneSecond() {
        cd.setTimeLeft(1000);
        cd.addTimeBuff();
        assertEquals("Time remaining: 01:01", cd.displayTimeInsideArt());
    }

    @Test
    public void updateTimeLeftPositive() {
        cd.updateTimeLeft();
        assertEquals(599000, cd.getTimeLeft());
    }

    @Test
    public void startTimerPositive() throws InterruptedException {
        cd.startTimer();
        Thread.sleep(1800);
        long timeFrozen = cd.getTimeLeft();
        assertEquals(598000, timeFrozen);
    }

    @Test
    public void displayTimeInsideArtPositive() {
        cd.setTimeLeft(66000);
        assertEquals("Time remaining: 01:06", cd.displayTimeInsideArt());
    }

    @Test
    public void convertTimeLeftToMmSsPositive() {
        assertEquals("10:00", cd.convertTimeLeftToMmSs(600000));
        assertEquals("07:35", cd.convertTimeLeftToMmSs(455000));
        assertEquals("00:01", cd.convertTimeLeftToMmSs(1000));
        assertEquals("00:00", cd.convertTimeLeftToMmSs(500));
    }
}