import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import colorPalette.colorPalette;


public class ColorPaletteTests{
    @Test
    @DisplayName("Testing colorPalette object initialization")
    public void initializeObjectWithTwo(){
        colorPalette colorTwo = new colorPalette(2);
        int[][] expectedPalette = {
                {0,0,0},
                {255,255,255}
        };
        Assertions.assertArrayEquals(expectedPalette, colorTwo.getPalette());
    }

    @Test
    @DisplayName("Testing if constructor with no input results in exception")
    public void testColorPaletteNoInput_throwsIllegalArgumentException(){
        IllegalArgumentException thrown = Assertions.assertThrows( IllegalArgumentException.class, () -> new colorPalette());
        Assertions.assertEquals("Expected 1 parameter, but 0 were provided", thrown.getMessage());
    }
}
