package com.rjmj.capstone.character;

import java.util.*;

public class Tom implements Character {

    //// For resource bundle ////
    final String FILE_BASE_NAME = "QuizTom";
    ResourceBundle bundle = ResourceBundle.getBundle(PATH + FILE_BASE_NAME, Locale.US, rbc);
    ////////////////////////////

    /// Temporary -> Specifying the quiz base ///
    String QuizBaseKey = "Quiz1";
    private Random random = new Random();
    private String questionAnswer;

    public Boolean askQuestionCollectAndProcessResponse() {
        int quizNumber = random.nextInt(3) + 1;
        askQuestion(quizNumber);
        String userResponse = collectUserInput();
        return processAnswer(quizNumber, userResponse);
    }

    public void askQuestion(Integer quizNumber) {
        String quizIdentifier = "Quiz" + String.valueOf(quizNumber);
        readStoryLinesOutOfFile(quizIdentifier, SLEEP_DURATION_MS);
    }

    public String collectUserInput() {
        Scanner sc = new Scanner(System.in);
        setQuestionAnswer(sc.next());
        return getQuestionAnswer();
    }

    public Boolean processAnswer(Integer quizNumber, String questionAnswer) {
        String result = "";
        Boolean finalResult = false;
        String ansKey = "Quiz" + String.valueOf(quizNumber) + "_answer";
        String answer = null;
        try{
            answer = bundle.getString(ansKey);
            if (questionAnswer.equalsIgnoreCase(answer)){
                System.out.println("\nCorrect");
                finalResult = true;
            }
            else{
                System.out.println("\nIncorrect, please try again.");
            }
        }
        catch(MissingResourceException e){
            somethingWentWrong(e);
            System.out.println("Could not find a key : " + ansKey);
        }

        return finalResult;
    }


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

        String ansKey = QuizBaseKey + "_answer";
        String answer = null;
        try{
            answer = bundle.getString(ansKey);
            if (questionAnswer.equalsIgnoreCase(answer)){
                System.out.println("\nCorrect");
                result = getItem();
            }
            else{
                System.out.println("\nIncorrect, please try again.");
            }
        }
        catch(MissingResourceException e){
            somethingWentWrong(e);
            System.out.println("\nCould not find a key : " + ansKey);
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
        return ANSI_BLUE + "Blue Liquid" + ANSI_RESET;
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
            catch (Exception e){
                somethingWentWrong(e);
            }
        }
    }
}