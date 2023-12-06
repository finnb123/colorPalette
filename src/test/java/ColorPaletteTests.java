import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import colorPalette.colorPalette;

import java.util.ArrayList;
import java.util.Arrays;


public class ColorPaletteTests{
    @Test
    @DisplayName("Testing colorPalette object initialization")
    public void initializeObjectWithTwo(){
        colorPalette colorTwo = new colorPalette(2);
        ArrayList<ArrayList<Integer>> expectedPalette = new ArrayList<ArrayList<Integer>>();
        expectedPalette.add(new ArrayList<>());
        expectedPalette.add(new ArrayList<>());
        expectedPalette.get(0).add(0);
        expectedPalette.get(0).add(0);
        expectedPalette.get(0).add(0);
        expectedPalette.get(1).add(255);
        expectedPalette.get(1).add(255);
        expectedPalette.get(1).add(255);

        Assertions.assertEquals(expectedPalette, colorTwo.getPalette());
    }

    @Test
    @DisplayName("Testing if constructor with no input results in exception")
    public void testColorPaletteNoInput_throwsIllegalArgumentException(){
        IllegalArgumentException thrown = Assertions.assertThrows( IllegalArgumentException.class, () -> new colorPalette());
        Assertions.assertEquals("Expected 1 parameter, but 0 were provided", thrown.getMessage());
    }

    @Test
    @DisplayName("Testing if constructor with incorrect input results in exception")
    public void testColorPaletteIllegalInput_throwsIllegalArgumentException(){
        IllegalArgumentException thrown = Assertions.assertThrows( IllegalArgumentException.class, () -> new colorPalette(3));
        Assertions.assertEquals("Input must be greater than 1, a power of 2, and less than 1025.", thrown.getMessage());
    }

    @Test
    @DisplayName("Test for adding a color to the palette")
    public void testAddColorToPalette(){
        colorPalette colorTwo = new colorPalette(2);
        ArrayList<Integer> newColor = new ArrayList<Integer>();
        newColor.add(255);
        newColor.add(0);
        newColor.add(255);
        colorTwo.addColor(newColor);
        ArrayList<ArrayList<Integer>> palette = colorTwo.getPalette();
        Assertions.assertTrue(colorTwo.getPalette().contains(newColor));
    }

    @Test
    @DisplayName("Test for validity of color added to palette")
    public void testValidityAddColor(){
        colorPalette colorTwo = new colorPalette(2);
        ArrayList<Integer> newColor = new ArrayList<Integer>();
        newColor.add(300);
        newColor.add(20);
        newColor.add(255);
        IllegalArgumentException thrown = Assertions.assertThrows( IllegalArgumentException.class, () -> colorTwo.addColor(newColor));
        Assertions.assertEquals("Illegal RGB Value", thrown.getMessage());
    }
}
