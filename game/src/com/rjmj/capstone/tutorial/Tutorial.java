package com.rjmj.capstone.tutorial;

public class Tutorial {
    private TalkingTutorial talkingTutorial = new TalkingTutorial();
    private MovingTutorial movingTutorial = new MovingTutorial();
    private LookAroundItemTutorial lookAroundItemTutorial = new LookAroundItemTutorial();

    public void startTutorial() {
        talkingTutorial.startTalkingTutorial();
        movingTutorial.startMovingTutorial();
        lookAroundItemTutorial.startLookAroundTutorial();
    }
}
