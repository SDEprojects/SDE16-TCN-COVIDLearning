package com.rjmj.capstone.player;

import com.rjmj.capstone.engine.UserInput;
import com.rjmj.capstone.timer.Countdown;

import java.util.*;

public class Recipe implements PlayerResourceBundle {

    //// For resource bundle ////
    final String FILE_BASE_NAME = "recipe";
    ResourceBundle bundle = ResourceBundle.getBundle(PATH + FILE_BASE_NAME, Locale.US, rbc);
    ////////////////////////////

    public static List<ColorEnum> colorEnumMixes = new ArrayList(3);
    private List<ColorEnum> playerMix = new ArrayList(3);
    private final ColorEnum[] clrEnum = {ColorEnum.RED, ColorEnum.BLUE, ColorEnum.GREEN};
    private boolean isMatch = false;

    public void mixRandomRecipe(){
        while(colorEnumMixes.size() < 3){
            ColorEnum ranColorEnum = clrEnum[(getRandom())];
            if(!colorEnumMixes.contains(ranColorEnum)){
                colorEnumMixes.add(ranColorEnum);
            }
        }
    }

    public void setPlayerMix(Countdown cd) {
        int count = 1;
        UserInput input = new UserInput();
        readStoryLinesOutOfFile("mixIntro", 0);
        while(playerMix.size() < 3){
            String q = "Enter ingredient number " + count +" , choose from: (RED,BLUE,GREEN)";
            String choice = input.getInput(q).toUpperCase();
            if(choice.startsWith("R")){
                playerMix.add(ColorEnum.RED);
            }
            else if(choice.startsWith("B")){
                playerMix.add(ColorEnum.BLUE);
            }
            else if(choice.startsWith("G")){
                playerMix.add(ColorEnum.GREEN);
            }
            else {
                readStoryLinesOutOfFile("invalid", 0);
                continue;
            }
            count++;
        }
        setMatch(isRecipeMatch(getPlayerMix()));
    }

    public boolean isRecipeMatch(List<ColorEnum> formula){
        boolean result = false;
        for(int i = 0; i < colorEnumMixes.size(); i++) {
            if (!formula.get(i).equals(getColorEnumMixes().get(i))) {
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
        for(ColorEnum colorEnum : getColorEnumMixes()){
            String clr = colorEnum.toString().toUpperCase();
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
        return (ANSI_PURPLE + "Zach has given you the recipe to mix the vaccine!\n" +
                "   Mix the ingredients in the order listed\n" + ANSI_RESET +
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

    public static List<ColorEnum> getColorEnumMixes() {
        return colorEnumMixes;
    }

    public List<ColorEnum> getPlayerMix() {
        return playerMix;
    }

    public boolean isMatch() {
        return isMatch;
    }

    public void setMatch(boolean match) {
        isMatch = match;
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
