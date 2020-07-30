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
        recipe.colorMix.add(Color.GREEN);
        recipe.colorMix.add(Color.RED);
        recipe.colorMix.add(Color.BLUE);
        boolean actual = recipe.isRecipeMatch(playerMix,cd);
        assertEquals(true,actual);
    }
    @Test
    public void isRecipeMatchNegative() {
        recipe.colorMix.add(Color.GREEN);
        recipe.colorMix.add(Color.RED);
        recipe.colorMix.add(Color.RED);
        boolean actual = recipe.isRecipeMatch(playerMix,cd);
        assertNotEquals(true,actual);
    }
    @Test
    public void mixRandomRecipeContainsOneOfEachColorPositive() {
        recipe.mixRandomRecipe();
        assertEquals(3,recipe.getColorMix().size());
        assertTrue(recipe.getColorMix().contains(Color.RED));
        assertTrue(recipe.getColorMix().contains(Color.BLUE));
        assertTrue(recipe.getColorMix().contains(Color.GREEN));
    }
}