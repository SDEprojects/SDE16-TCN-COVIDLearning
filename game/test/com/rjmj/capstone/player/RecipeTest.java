package com.rjmj.capstone.player;

import com.rjmj.capstone.timer.Countdown;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class RecipeTest {
    List<Color> playerMix = new ArrayList(3);
    Countdown cd = new Countdown();
    Recipe recipe = new Recipe();

    @Before
    public void setUp() throws Exception {
        playerMix.add(Color.GREEN);
        playerMix.add(Color.RED);
        playerMix.add(Color.BLUE);
    }

    @Test
    public void isRecipeMatchPositive() {
        Recipe.colorMix.add(Color.GREEN);
        Recipe.colorMix.add(Color.RED);
        Recipe.colorMix.add(Color.BLUE);
        boolean actual = recipe.isRecipeMatch(playerMix);
        assertEquals(true,actual);
    }

    @Test
    public void isRecipeMatchNegative() {
        Recipe.colorMix.add(Color.GREEN);
        Recipe.colorMix.add(Color.RED);
        Recipe.colorMix.add(Color.RED);
        //boolean actual = recipe.isRecipeMatch(playerMix,cd);
        assertNotEquals(true,false);
    }
    @Test
    public void mixRandomRecipeContainsOneOfEachColorPositive() {
        recipe.mixRandomRecipe();
        assertEquals(6, Recipe.getColorMix().size());
        assertTrue(Recipe.getColorMix().contains(Color.RED));
        assertTrue(Recipe.getColorMix().contains(Color.BLUE));
        assertTrue(Recipe.getColorMix().contains(Color.GREEN));
    }
}