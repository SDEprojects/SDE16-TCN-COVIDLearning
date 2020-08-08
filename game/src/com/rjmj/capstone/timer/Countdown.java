package com.rjmj.capstone.timer;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class Countdown implements TimerResourceBundle {

    //// For resource bundle ////
    final String FILE_BASE_NAME = "countdown";
    ResourceBundle bundle = ResourceBundle.getBundle(PATH + FILE_BASE_NAME, Locale.US, rbc);
    ////////////////////////////

    private long delay = 1000; //milliseconds
    private final Timer timer = new Timer();
    private long timeLeft = 600000;

    public void addTimeBuff(){
        setTimeLeft(getTimeLeft() + getTimeBuff());
    }
    public void subTimePenalty() {
        readStoryLinesOutOfFile("mixture", 0);
        //System.out.println("You mixed the vaccine in the wrong order, 1 minute has been subtracted from your time left.");
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
                    readStoryLinesOutOfFile("timeup", 0);
                    //System.out.println("Game Over, times up your are dead");
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
        return convertTimeLeftToMmSs(getTimeLeft());
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
    /** For accessing and displaying stories in Resource Bundle file */
    public void readStoryLinesOutOfFile(String key, int SLEEP_DURATION_MS) {
        String msg = null;
        for (int i = 0; i < MAX_ITERATION_DISPLAY_STORIES; i++) {
            try {
                msg = textPainter(bundle.getString(key + "[" + i + "]"));
                displayStoryLineByLine(msg, SLEEP_DURATION_MS);
            }
            catch (MissingResourceException e) {
                if (i == 0){
                    System.out.println("Could not find the key : " + key);
                }
                break;
            }
            catch (Exception e){
                somethingWentWrong(e);
            }
        }
    }
}
