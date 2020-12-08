import java.util.Arrays;

public class Cube {

    String[][] cube = {
        {"R", "R", "W"},
        {"G", "C", "W"},
        {"G", "B", "B"}
    };

    public Cube(){
        printCube();
    }

    private void printCube(){
        for (String[] row : cube) {
            for (String box : row) {
                System.out.printf("%3s", box);
            }
            System.out.println();
        }
    }
}
