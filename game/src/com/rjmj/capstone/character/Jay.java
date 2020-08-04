package com.rjmj.capstone.character;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Jay implements Character, Color {

    //// For resource bundle ////
    final String FILE_BASE_NAME = "QuizJay";
    final String PATH = "com.rjmj.capstone.character.files.";
    ResourceBundle.Control rbc = ResourceBundle.Control.getControl(ResourceBundle.Control.FORMAT_DEFAULT);
    ResourceBundle bundle = ResourceBundle.getBundle(PATH + FILE_BASE_NAME, Locale.US, rbc);

    private boolean _max_iteration_not_reached;
    public final int MAX_ITERATION_DISPLAY_STORIES = 10;
    ////////////////////////////

    /// Temporary -> Specifying the quiz base ///
    String QuizBaseKey = "Quiz1";


    private boolean unitTestingActive = false;
    private String questionAnswer;

    @Override
    public String askTheQuestionAndCollectInput() {

        readStoryLinesOutOfFile("Quiz1", SLEEP_DURATION_MS);

        try {
            String url_open = "https://www.youtube.com/watch?v=hyctW2abkY4";
            java.awt.Desktop.getDesktop().browse(java.net.URI.create(url_open));
        }
        catch(Exception e){
            somethingWentWrong(e);
            System.out.println("Please check at : \"java.awt.Desktop.getDesktop().browse(java.net.URI.create(url_open)\"");
        }

        Scanner sc = new Scanner(System.in);
        setQuestionAnswer(sc.next());
        return getQuestionAnswer();
    }

    @Override
    public String processQuestionAnswer(String questionAnswer) {
        String result = "";

        String ansKey = QuizBaseKey + "_answer";
        String answer = null;
        try{
            answer = bundle.getString(ansKey);
            if (questionAnswer.equalsIgnoreCase(answer)){
                System.out.println("Correct");
                result = getItem();
            }
            else{
                System.out.println("Incorrect, please try again.");
            }
        }
        catch(MissingResourceException e){
            somethingWentWrong(e);
            System.out.println("Could not find a key : " + ansKey);
        }

        return result;
    }

    public String getQuestionAnswer() {
        return questionAnswer;
    }

    public void setQuestionAnswer(String questionAnswer) {
        this.questionAnswer = questionAnswer;
    }

    public String getItem() {
        return ANSI_RED +"Red Liquid" + ANSI_CYAN;
    }


    /** For accessing and displaying stories in Resource Bundle file */
    private void readStoryLinesOutOfFile(String key, int SLEEP_DURATION_MS) {
        _max_iteration_not_reached = false;
        String msg = null;
        for (int i = 0; i < MAX_ITERATION_DISPLAY_STORIES; i++) {
            try {
                msg = textPainter(bundle.getString(key + "[" + i + "]"));
                displayStoryLineByLine(msg, SLEEP_DURATION_MS);
            } catch (MissingResourceException e) {
                _max_iteration_not_reached = true;
                if (i == 0){
                    System.out.println("Could not find the key : " + key);
                }
                break;
            }
        }
    }
    private void displayStoryLineByLine(String msg, int SLEEP_DURATION_MS){
        try{
            Thread.sleep(SLEEP_DURATION_MS);
            System.out.println(msg);
        }
        catch (Exception e){
            somethingWentWrong(e);
            System.out.println("Please check at : \"Thread.sleep(SLEEP_DURATION_MS)\"");
        }
    }

}
