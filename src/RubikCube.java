import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RubikCube {

    private final List<CubeFace> rubikCube = new ArrayList<>();
    UserResponse userResponse;
    public RubikCube(Scanner scanner) {
        userResponse = new UserResponse(scanner);
        initRubik();
        printRubik();
        startCubeGame();
    }

    private void startCubeGame() {
        while(true){
            String input = userResponse.getInput();
            if (input.equals("Q")) {
                System.out.println("Bye~");
                return;
            }
            printRubik();
        }
    }

    private void printRubik() {
        printTopAndBottom(0);
        System.out.println();
        printSides();
        System.out.println();
        printTopAndBottom(5);


    }

    private void printSides() {
        for (int i = 0; i < 3; i++) {
            for (int j = 1; j < 5; j++) {
                rubikCube.get(j).printOneLineOfFace(i);
                System.out.printf("%3s", " ");
            }
            System.out.println();
        }
    }

    private void printTopAndBottom(int rubikIndex) {
        for (int i = 0; i < 3; i++) {
            System.out.printf("%18s", " ");
            rubikCube.get(rubikIndex).printOneLineOfFace(i);
            System.out.println();
        }
    }

    private void initRubik() {
        for (Colors color : Colors.values()) {
            rubikCube.add(new CubeFace(color.getColor()));
        }
    }

}
