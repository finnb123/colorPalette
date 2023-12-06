package colorPalette;
import java.util.*;

public class colorPalette {

    ArrayList<ArrayList<Integer>> palette;
    public colorPalette() throws IllegalArgumentException{
        throw new IllegalArgumentException("Expected 1 parameter, but 0 were provided");
    }
    public colorPalette(int numberOfColors) throws IllegalArgumentException{
        if (numberOfColors < 2 || numberOfColors > 1025 || !((numberOfColors & (numberOfColors - 1)) == 0)){
            throw new IllegalArgumentException("Input must be greater than 1, a power of 2, and less than 1025.");
        }
        this.palette = new ArrayList<ArrayList<Integer>>();
        this.palette.add(new ArrayList<>());
        this.palette.add(new ArrayList<>());

        this.palette.get(0).add(0);
        this.palette.get(0).add(0);
        this.palette.get(0).add(0);

        this.palette.get(1).add(255);
        this.palette.get(1).add(255);
        this.palette.get(1).add(255);
    }

    public ArrayList<ArrayList<Integer>> getPalette(){
        return this.palette;
    }

    public void addColor(ArrayList<Integer> newColor){
        //Add new Row
        this.palette.add(new ArrayList<Integer>());
    }


}
