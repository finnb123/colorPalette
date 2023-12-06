package colorPalette;

public class colorPalette {

    int[][] palette;

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
