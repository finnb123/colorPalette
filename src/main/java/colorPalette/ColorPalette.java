package colorPalette;
import java.util.*;

public class ColorPalette {

    ArrayList<ArrayList<Integer>> palette;
    public ColorPalette() throws IllegalArgumentException{
        throw new IllegalArgumentException("Expected 1 parameter, but 0 were provided");
    }
    public ColorPalette(int numberOfColors) throws IllegalArgumentException{
        if (numberOfColors < 2 || numberOfColors > 1025 || !((numberOfColors & (numberOfColors - 1)) == 0)){
            throw new IllegalArgumentException("Input must be greater than 1, a power of 2, and less than 1025.");
        }
        this.palette = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i < numberOfColors; i++){
            this.palette.add(new ArrayList<>());
        }
        //White
        List<Integer> white = Arrays.asList(0, 0, 0);
        this.palette.get(0).addAll(white);
        if(numberOfColors == 2){
            //Black
            List<Integer> black = Arrays.asList(255,255,255);
            this.palette.get(1).addAll(black);
        }
        if(numberOfColors == 4) {
            //Set all values to 0
            for(int i = 1; i<numberOfColors;i++){
                this.palette.get(i).addAll(white);
                switch(i){
                    case 1:
                        //red
                        this.palette.get(i).set(0,255);
                        break;
                    case 2:
                        this.palette.get(i).set(1,255);
                        break;
                    case 3:
                        this.palette.get(i).set(2,255);
                        break;
                }
            }
        }
    }

    public ArrayList<ArrayList<Integer>> getPalette(){
        return this.palette;
    }

    public void addColor(ArrayList<Integer> newColor) throws IllegalArgumentException{
        //Add new Row
        for (Integer value : newColor){
            if(value<0 || value>255){
                throw new IllegalArgumentException("Illegal RGB Value");
            }
        }
        this.palette.add(new ArrayList<Integer>(newColor));
    }


}
