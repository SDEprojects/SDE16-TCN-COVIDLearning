package com.rjmj.capstone.tutorial;

import com.rjmj.capstone.engine.Parser;

public class TutorialParser implements InterfaceTutorial {

    private Parser parser;

    public TutorialParser() {
        try {
            parser = new Parser();
        }
        catch(Exception e){
            somethingWentWrong(e);
            System.out.println("Please check at : \"Parser()\"");
        }
    }

    public String[] parseAvailableActions(String input) {
        String[] commandArray = input.toLowerCase().split("\\s+", 2);
        String command = commandArray[0];
        String argument = commandArray.length > 1 ? commandArray[1] : " ";

        String[] result = new String[2];
        result[1] = argument.toUpperCase();

        if (parser.isMoveSynonym(command)) {
            result[0] = "MOVE";
            if (!(result[1].equalsIgnoreCase("right")
                    ||(result[1].equalsIgnoreCase("left"))
                    ||(result[1].equalsIgnoreCase("up"))
                    ||(result[1].equalsIgnoreCase("down")))) {
                result[0] = "X";
                result[1] = "";
            }
        } else if (parser.isSearchSynonym(command)) {
            result[0] = "LOOK AROUND";
            result[1] = "";

        } else if (parser.isTalkSynonym(command)) {
            result[0] = "TALK";
            result[1] = "";
        }
        else if (parser.isTakeSynonym(command)) {
            result[0] = "TAKE ITEM";
            result[1] = "";
        }
        else {
            System.out.println("Error, please select a valid item.\n");
            result[0] = "X";
        }
    return result;
    }

}
