import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import colorPalette.colorPalette;
import org.junit.jupiter.api.Assertions;

public class ColorPaletteTests{
    @Test
    @DisplayName("Testing colorPalette object initialization")
    public void initializeObject(){
        colorPalette colorTwo = new colorPalette(2);
        int[][] expectedPalette = {
                {0,0,0},
                {255,255,255}
        };
        Assertions.assertArrayEquals(expectedPalette, colorTwo.getPalette());
    }
}
