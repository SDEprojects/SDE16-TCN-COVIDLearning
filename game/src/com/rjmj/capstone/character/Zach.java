package com.rjmj.capstone.character;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Zach implements Character{

    //// For resource bundle ////
    final String FILE_BASE_NAME = "QuizZach";
    ResourceBundle bundle = ResourceBundle.getBundle(PATH + FILE_BASE_NAME, Locale.US, rbc);
    ////////////////////////////

    /// Temporary -> Specifying the quiz base ///
    String QuizBaseKey = "Quiz1";

    private String questionAnswer;

    @Override
    public String askTheQuestionAndCollectInput() {
        readStoryLinesOutOfFile(QuizBaseKey, SLEEP_DURATION_MS);

        Scanner sc = new Scanner(System.in);
        setQuestionAnswer(sc.next());
        return getQuestionAnswer();
    }

    @Override
    public String processQuestionAnswer(String questionAnswer) {
        String result = "";
        if (questionAnswer.toUpperCase().equals("A")) {
            System.out.println("Correct");
            result = getItem();
        } else {
            System.out.println("Incorrect, please try again.");
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
        return "Recipe";
    }

    /** For accessing and displaying stories in Resource Bundle file */
    public void readStoryLinesOutOfFile(String key, int SLEEP_DURATION_MS) {
        String msg = null;
        for (int i = 0; i < MAX_ITERATION_DISPLAY_STORIES; i++) {
            try {
                msg = textPainter(bundle.getString(key + "[" + i + "]"));
                displayStoryLineByLine(msg, SLEEP_DURATION_MS);
            } catch (MissingResourceException e) {
                if (i == 0){
                    System.out.println("Could not find the key : " + key);
                }
                break;
            }
        }
    }
}
