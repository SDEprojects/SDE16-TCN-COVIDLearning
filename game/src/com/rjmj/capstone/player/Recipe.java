package com.rjmj.capstone.player;

import com.rjmj.capstone.engine.UserInput;
import com.rjmj.capstone.timer.Countdown;

import java.util.ArrayList;
import java.util.List;

public class Recipe {
    public static List<Color> colorMix = new ArrayList(3);
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_BLUE = "\u001B[34m";
    private static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RESET = "\u001B[0m";
    private List<Color> playerMix = new ArrayList(3);
    private final Color[] clrEnum = {Color.RED, Color.BLUE, Color.GREEN};
    private boolean isMatch = false;

    public void mixRandomRecipe(){
        while(colorMix.size() < 3){
            Color ranColor = clrEnum[(getRandom())];
            if(!colorMix.contains(ranColor)){
                colorMix.add(ranColor);
            }
        }
    }

    public void setPlayerMix(Countdown cd) {
        int count = 1;
        UserInput input = new UserInput();
        System.out.println("The recipe needs to be mixed in a specific order.\nEach ingredient is only used once.\n");
        while(playerMix.size() < 3){
            String q = "Enter ingredient number " + count +" , choose from: (RED,BLUE,GREEN)";
            String choice = input.getInput(q).toUpperCase();
            if(choice.startsWith("R")){
                playerMix.add(Color.RED);
            }
            else if(choice.startsWith("B")){
                playerMix.add(Color.BLUE);
            }
            else if(choice.startsWith("G")){
                playerMix.add(Color.GREEN);
            }
            else {
                System.out.println("Invalid ingredient, please try again.");
                continue;
            }
            count++;
        }
        setMatch(isRecipeMatch(getPlayerMix(),cd));
    }

    public boolean isRecipeMatch(List<Color> formula, Countdown cd){
        boolean result = false;
        for(int i = 0; i < colorMix.size(); i++) {
            if (!formula.get(i).equals(getColorMix().get(i))) {
                playerMix = new ArrayList(3);
                return false;
            } else {
                result = true;
            }
        }
        return result;
    }

    public static String recipeArt() {
        List<String> arr = new ArrayList<>();
        for(Color color : getColorMix()){
            String clr = color.toString().toUpperCase();
            if(clr.equals("RED")){
                clr = ANSI_RED + "RED" + ANSI_RESET + "~~";
            }
            else if(clr.equals("BLUE")){
                clr = ANSI_BLUE + "BLUE"+ ANSI_RESET + "~" ;
            }
            else {
                clr = ANSI_GREEN + "GREEN" + ANSI_RESET;
            }
            arr.add(clr);
        }
        String color1 = arr.get(0);
        String color2 = arr.get(1);
        String color3 = arr.get(2);
        return ("Zach has given you the recipe to mix the vaccine!\n" +
                "   Mix the ingredients in the order listed\n" +
                "         __________  \n" +
                "        ()_________)\n" +
                "          \\ ~" + color1 + "~ \\\n" +
                "            \\ ~" + color2 + "  \\\n" +
                "              \\ ~" + color3 + "  \\\n" +
                "                \\_________\\\n" +
                "                ()__________)");
    }

    public int getRandom() {
        return (int) (0 + Math.floor((Math.random() * 3)));
    }

    public static List<Color> getColorMix() {
        return colorMix;
    }

    public List<Color> getPlayerMix() {
        return playerMix;
    }

    public boolean isMatch() {
        return isMatch;
    }

    public void setMatch(boolean match) {
        isMatch = match;
    }
}
