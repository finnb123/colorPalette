package colorPalette;

public class colorPalette {

    int[][] palette;
    public colorPalette() throws IllegalArgumentException{
        throw new IllegalArgumentException("Expected 1 parameter, but 0 were provided");
    }
    public colorPalette(int numberOfColors){
        this.palette = new int[][]{
                {0, 0, 0},
                {255, 255, 255}
        };
    }

    public int[][] getPalette(){
        return this.palette;
    }



}
