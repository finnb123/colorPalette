import colorPalette.ListSizeExceededException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import colorPalette.ColorPalette;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ColorPaletteTests {

    private ColorPalette colorTwo;
    private ArrayList<Integer> newColor;
    private ArrayList<ArrayList<Integer>> testPalette;
    private ColorPalette colorEight;

    @BeforeEach
    public void setUp() {
        colorTwo = new ColorPalette(2);
        newColor = new ArrayList<Integer>();
        testPalette = new ArrayList<ArrayList<Integer>>();
        colorEight = new ColorPalette(8);
    }

    @Test
    @DisplayName("Testing colorPalette object initialization")
    public void initializeObjectWithTwo() {
//        colorPalette colorTwo = new colorPalette(2);
        testPalette.add(new ArrayList<>());
        testPalette.add(new ArrayList<>());
        testPalette.get(0).add(0);
        testPalette.get(0).add(0);
        testPalette.get(0).add(0);
        testPalette.get(1).add(255);
        testPalette.get(1).add(255);
        testPalette.get(1).add(255);

        Assertions.assertEquals(testPalette, colorTwo.getPalette());
    }

    @Test
    @DisplayName("Testing if constructor with no input results in exception")
    public void testColorPaletteNoInput_throwsIllegalArgumentException() {
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> new ColorPalette());
        Assertions.assertEquals("Expected 1 parameter, but 0 were provided", thrown.getMessage());
    }

    @Test
    @DisplayName("Testing if constructor with incorrect input results in exception")
    public void testColorPaletteIllegalInput_throwsIllegalArgumentException() {
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> new ColorPalette(3));
        Assertions.assertEquals("Input must be greater than 1, a power of 2, and less than 1025.", thrown.getMessage());
    }

    @Test
    @DisplayName("Test for adding a color to the palette")
    public void testAddColorToPalette() {
        newColor.add(255);
        newColor.add(0);
        newColor.add(255);
        colorTwo.addColor(newColor);
        Assertions.assertTrue(colorTwo.getPalette().contains(newColor));
    }

    @Test
    @DisplayName("Test for validity of color added to palette")
    public void testValidityAddColor() {
        newColor.add(300);
        newColor.add(20);
        newColor.add(255);
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> colorTwo.addColor(newColor));
        Assertions.assertEquals("Illegal RGB Value", thrown.getMessage());
    }

    @Test
    @DisplayName("Test for generating variable number of ArrayLists to contain the RGB values")
    public void testSizeOfOuterArrayList() {
        ColorPalette colorPalette = new ColorPalette(1024);
        Assertions.assertEquals(1024, colorPalette.getPalette().size());
    }

    @Test
    @DisplayName("Test for generating palette of 4 values")
    public void testFourColorPalette() {
        testPalette.add(new ArrayList<>());
        testPalette.add(new ArrayList<>());
        testPalette.add(new ArrayList<>());
        testPalette.add(new ArrayList<>());
        List<Integer> black = Arrays.asList(0,0,0);
        List<Integer> red = Arrays.asList(255, 0, 0);
        List<Integer> green = Arrays.asList(0, 255, 0);
        List<Integer> blue = Arrays.asList(0, 0, 255);

        testPalette.get(0).addAll(black);
        testPalette.get(1).addAll(red);
        testPalette.get(2).addAll(green);
        testPalette.get(3).addAll(blue);

        ColorPalette colorFour = new ColorPalette(4);

        Assertions.assertEquals(testPalette, colorFour.getPalette());

    }

    @Test
    @DisplayName("Test for adding color value that would put palette size over limit of 1025")
    public void testAddOverSizeLimit(){
        ColorPalette color1024 = new ColorPalette(1024);
        List<Integer> black = Arrays.asList(0,0,0);
        newColor.addAll(black);
        color1024.addColor(newColor);
        List<Integer> red = Arrays.asList(255,0,0);
        ArrayList<Integer> colorTwo = new ArrayList<Integer>(red);
        ListSizeExceededException thrown = Assertions.assertThrows(ListSizeExceededException.class, () -> color1024.addColor(colorTwo));
        Assertions.assertEquals("Palette Size Exceeded", thrown.getMessage());
    }

    @Test
    @DisplayName("Test for exception if color has already been added to palette")
    public void testColorAlreadyAdded(){
        ColorPalette colorFour = new ColorPalette(4);
        List<Integer> red = Arrays.asList(255,0,0);
        ArrayList<Integer> colorTwo = new ArrayList<Integer>(red);
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> colorFour.addColor(colorTwo));
        Assertions.assertEquals("Color Already Exists", thrown.getMessage());
    }

}