import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RubikCube {

    private final Map<Faces, CubeFace> rubikCube = new HashMap<>();
    UserResponse userResponse;
    Printer printer;

    public RubikCube(Scanner scanner) {
        userResponse = new UserResponse(scanner);
        printer = new Printer();
        initRubik();
        printer.rubikCube(rubikCube);
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
            printer.rubikCube(rubikCube);
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


    private void initRubik() {
        for(Faces face : Faces.values()){
            rubikCube.put(face, new CubeFace(face.getColor()));
        }
    }

}
