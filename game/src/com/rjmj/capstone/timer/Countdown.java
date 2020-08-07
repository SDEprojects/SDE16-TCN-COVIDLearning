package com.rjmj.capstone.timer;

import com.rjmj.capstone.Color;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class Countdown implements Color {
    private long delay = 1000; //milliseconds
    private final Timer timer = new Timer();
    private long timeLeft = 600000;
//    public static final String ANSI_PURPLE = "\u001B[35m";
//    public static final String ANSI_RESET = "\u001B[0m";

    public void addTimeBuff(){
        setTimeLeft(getTimeLeft() + getTimeBuff());
    }
    public void subTimePenalty() {
        System.out.println("You mixed the vaccine in the wrong order, 1 minute has been subtracted from your time left.");
        setTimeLeft(getTimeLeft() + getTimePenalty());
    }

    public void updateTimeLeft() {
        setTimeLeft(getTimeLeft() - getDelay());
    }

    public void startTimer() {
        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                updateTimeLeft();
                if (getTimeLeft() <= 0) {
                    System.out.println("Game Over, times up your are dead");
                    timer.cancel();
                    System.exit(1);
                }
            }
        }, 0, 1000);
    }

    public void displayTimeLeft() {
        System.out.println("Time remaining: " + convertTimeLeftToMmSs(getTimeLeft()) + "\n");
    }
    
    public String displayTimeInsideArt() {
        return "Time remaining: " + convertTimeLeftToMmSs(getTimeLeft());
    }

    public String convertTimeLeftToMmSs(long timeLeft) {
        String ms = String.format("%02d:%02d",
                TimeUnit.MILLISECONDS.toMinutes(timeLeft) % TimeUnit.HOURS.toMinutes(1),
                TimeUnit.MILLISECONDS.toSeconds(timeLeft) % TimeUnit.MINUTES.toSeconds(1));
        return ms;
    }

    // This is so the timer will reset when the player starts a new game via Exit - otherwise it will continue.
    public void resetTimerNewGame() {
        setTimeLeft(600000);
    }

    public long getDelay() {
        return delay;
    }

    public long getTimeLeft() {
        return timeLeft;
    }

    public void setTimeLeft(long timeLeft) {
        this.timeLeft = timeLeft;
    }

    public long getTimeBuff() {
        long timeBuff = 60000;
        return timeBuff;
    }
    public long getTimePenalty() {
        long timePenalty = -60000;
        return timePenalty;
    }
}
