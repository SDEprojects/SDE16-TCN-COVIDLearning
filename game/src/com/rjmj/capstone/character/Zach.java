package com.rjmj.capstone.character;

import java.util.Scanner;

public class Zach implements Character{
    private String questionAnswer;

    @Override
    public String askTheQuestionAndCollectInput() throws InterruptedException {
        String[] zachInput = {
                ANSI_CYAN,
                "Zach: \"What did the crew name the Dragon DEMO 2 capsule?\"",
                "A. Endeavor",
                "B. Atlantis",
                "C. Dragon",
                "D. Enterprise",
                ANSI_RESET
        };

        for (String zach : zachInput) {
            Thread.sleep(sleep);
            System.out.println(zach);
        }

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
}
