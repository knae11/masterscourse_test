import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class RubikCube {

    private final Map<Faces, CubeFace> rubikCube = new HashMap<>();
    UserResponse userResponse;

    public RubikCube(Scanner scanner) {
        userResponse = new UserResponse(scanner);
        initRubik();
        printRubik();
        startCubeGame();
    }

    private void startCubeGame() {
        while (true) {
            String input = userResponse.getInput();
            if (input.equals("Q")) {
                System.out.println("Bye~");
                return;
            }
            system(input);
            printRubik();
        }
    }

    private void system(String input) {
        StringBuilder line = new StringBuilder();
        if (input.equals("F")) {
            line.append(rubikCube.get(Faces.TOP).getTopAndBottomLine(2));
            line.append(rubikCube.get(Faces.RIGHT).getLeftAndRightLine(0));
            line.append(rubikCube.get(Faces.BOTTOM).getTopAndBottomLine(0));
            line.append(rubikCube.get(Faces.LEFT).getLeftAndRightLine(2));
        }

        String newLine = line.substring(9) + line.substring(0, 9);

        rubikCube.get(Faces.TOP).setTopAndBottomCube(2, newLine.substring(0, 3));
        rubikCube.get(Faces.RIGHT).setLeftAndRightCube(0, newLine.substring(3, 6));
        rubikCube.get(Faces.BOTTOM).setTopAndBottomCube(0, newLine.substring(6, 9));
        rubikCube.get(Faces.LEFT).setLeftAndRightCube(2, newLine.substring(9));
    }

    private void printRubik() {
        printTopAndBottom(Faces.TOP);
        System.out.println();
        printSides();
        System.out.println();
        printTopAndBottom(Faces.BOTTOM);


    }

    private void printSides() {
        for (int i = 0; i < 3; i++) {
            rubikCube.get(Faces.LEFT).printOneLineOfFace(i);
            System.out.printf("%3s", " ");
            rubikCube.get(Faces.FRONT).printOneLineOfFace(i);
            System.out.printf("%3s", " ");
            rubikCube.get(Faces.RIGHT).printOneLineOfFace(i);
            System.out.printf("%3s", " ");
            rubikCube.get(Faces.BACK).printOneLineOfFace(i);
            System.out.println();
        }
    }

    private void printTopAndBottom(Faces face) {
        for (int i = 0; i < 3; i++) {
            System.out.printf("%18s", " ");
            rubikCube.get(face).printOneLineOfFace(i);
            System.out.println();
        }
    }

    private void initRubik() {
        for(Faces face : Faces.values()){
            rubikCube.put(face, new CubeFace(face.getColor()));
        }
    }

}
