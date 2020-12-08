import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RubikCube {

    private final List<CubeFace> rubikCube = new ArrayList<>();

    public RubikCube(){
        initRubik();
        printRubik();
    }
    private void printRubik() {
        for (CubeFace cubeFace : rubikCube) {
            cubeFace.printFace();
            System.out.println();
        }
    }

    private void initRubik() {
        for(Colors color : Colors.values()){
            rubikCube.add(new CubeFace(color.getColor()));
        }
    }

}
