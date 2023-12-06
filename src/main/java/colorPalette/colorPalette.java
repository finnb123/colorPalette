package colorPalette;

public class colorPalette {

    int[][] palette;
    public colorPalette() throws IllegalArgumentException{
        throw new IllegalArgumentException("Expected 1 parameter, but 0 were provided");
    }
    public colorPalette(int numberOfColors) throws IllegalArgumentException{
        if (numberOfColors < 2 || numberOfColors > 1025 || !((numberOfColors & (numberOfColors - 1)) == 0)){
            throw new IllegalArgumentException("Input must be greater than 1, a power of 2, and less than 1025.");
        }
        this.palette = new int[][]{
                {0, 0, 0},
                {255, 255, 255}
        };
    }

    public int[][] getPalette(){
        return this.palette;
    }



}
