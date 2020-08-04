package com.rjmj.capstone.character;

import java.util.Scanner;

public class Tom implements Character, Color {
    private String questionAnswer;

    @Override
    public String askTheQuestionAndCollectInput() {
        String[] tomInput = {
                ANSI_CYAN,
                "Tom: \"What Online video game did Tom perform a wedding?\"",
                "A. Dungeons and Dragons",
                "B. World of Warcraft",
                "C. Diablo II",
                "D. Elder Scrolls",
                ANSI_RESET
        };

        try {
            for (String tom : tomInput) {
                Thread.sleep(SLEEP_DURATION_MS);
                System.out.println(tom);
            }
        }
        catch(Exception e){
            somethingWentWrong(e);
            System.out.println("Please check at : \"Thread.sleep(SLEEP_DURATION_MS);\"");
        }

        Scanner sc = new Scanner(System.in);
        setQuestionAnswer(sc.next());
        return getQuestionAnswer();
    }

    @Override
    public String processQuestionAnswer(String questionAnswer) {
        String result = "";
        if (questionAnswer.toUpperCase().equals("B")) {
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
        return ANSI_BLUE + "Blue Liquid" + ANSI_CYAN;
    }
}
