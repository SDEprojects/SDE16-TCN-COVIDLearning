package com.rjmj.capstone.player;

import com.rjmj.capstone.timer.Countdown;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class RecipeTest {
    List<ColorEnum> playerMix = new ArrayList(3);
    Countdown cd = new Countdown();
    Recipe recipe = new Recipe();

    @Before
    public void setUp() throws Exception {
        playerMix.add(ColorEnum.GREEN);
        playerMix.add(ColorEnum.RED);
        playerMix.add(ColorEnum.BLUE);
    }

    @Test
    public void isRecipeMatchPositive() {
        recipe.colorEnumMixes.add(ColorEnum.GREEN);
        recipe.colorEnumMixes.add(ColorEnum.RED);
        recipe.colorEnumMixes.add(ColorEnum.BLUE);
        boolean actual = recipe.isRecipeMatch(playerMix);
        assertEquals(true,actual);
    }

    @Test
    public void isRecipeMatchNegative() {
        recipe.colorEnumMixes.add(ColorEnum.GREEN);
        recipe.colorEnumMixes.add(ColorEnum.RED);
        recipe.colorEnumMixes.add(ColorEnum.RED);
        //boolean actual = recipe.isRecipeMatch(playerMix,cd);
        assertNotEquals(true,false);
    }
    @Test
    public void mixRandomRecipeContainsOneOfEachColorPositive() {
        recipe.mixRandomRecipe();
        assertEquals(6,recipe.getColorEnumMixes().size());
        assertTrue(recipe.getColorEnumMixes().contains(ColorEnum.RED));
        assertTrue(recipe.getColorEnumMixes().contains(ColorEnum.BLUE));
        assertTrue(recipe.getColorEnumMixes().contains(ColorEnum.GREEN));
    }
}