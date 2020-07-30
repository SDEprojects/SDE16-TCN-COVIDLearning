package com.rjmj.capstone.character;

import java.util.Scanner;

public class Tom implements Character {
    private String questionAnswer;

    @Override
    public String askTheQuestionAndCollectInput() throws InterruptedException {
        String[] tomInput = {
                ANSI_CYAN,
                "Tom: \"What Online video game did Tom perform a wedding?\"",
                "A. Dungeons and Dragons",
                "B. World of Warcraft",
                "C. Diablo II",
                "D. Elder Scrolls",
                ANSI_RESET
        };

        for (String tom : tomInput) {
            Thread.sleep(sleep);
            System.out.println(tom);
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
