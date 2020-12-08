import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
            String[] input = userResponse.getInput();
            if (input[0].equals("Q")) {
                System.out.println("Bye~");
                return;
            }
            for (String move : input) {
                System.out.println(move);
                system(move);
                printer.rubikCube(rubikCube);

            }
        }
    }

    private void system(String move) {
        switch (move) {
            case "F":
                moveFront();
                break;
            case "U":
                moveTop();
                break;
            case "D":
                moveBottom();
                break;
            case "B":
                moveBack();
                break;
            case "L":
                moveLeft();
                break;
            case "R":
                moveRight();
                break;
            default:
                break;
        }

    }

    //TODO: Make simple methods and implement clockOtherwise conditions
    private void moveRight() {
        StringBuilder line = new StringBuilder();
        line.append(rubikCube.get(Faces.TOP).getLeftAndRightLine(2));
        line.append(rubikCube.get(Faces.BACK).getLeftAndRightLine(0));
        line.append(rubikCube.get(Faces.BOTTOM).getLeftAndRightLine(2));
        line.append(rubikCube.get(Faces.FRONT).getLeftAndRightLine(2));
        String newLine = line.substring(9) + line.substring(0, 9);
        rubikCube.get(Faces.TOP).setLeftAndRightCube(2, newLine.substring(0, 3));
        rubikCube.get(Faces.BACK).setLeftAndRightCube(0, newLine.substring(3, 6));
        rubikCube.get(Faces.BOTTOM).setLeftAndRightCube(2, newLine.substring(6, 9));
        rubikCube.get(Faces.FRONT).setLeftAndRightCube(2, newLine.substring(9));
    }

    private void moveLeft() {
        StringBuilder line = new StringBuilder();
        line.append(rubikCube.get(Faces.TOP).getLeftAndRightLine(0));
        line.append(rubikCube.get(Faces.FRONT).getLeftAndRightLine(0));
        line.append(rubikCube.get(Faces.BOTTOM).getLeftAndRightLine(0));
        line.append(rubikCube.get(Faces.BACK).getLeftAndRightLine(2));
        String newLine = line.substring(9) + line.substring(0, 9);
        rubikCube.get(Faces.TOP).setLeftAndRightCube(0, newLine.substring(0, 3));
        rubikCube.get(Faces.FRONT).setLeftAndRightCube(0, newLine.substring(3, 6));
        rubikCube.get(Faces.BOTTOM).setLeftAndRightCube(0, newLine.substring(6, 9));
        rubikCube.get(Faces.BACK).setLeftAndRightCube(2, newLine.substring(9));
    }

    private void moveBottom() {
        StringBuilder line = new StringBuilder();
        line.append(rubikCube.get(Faces.FRONT).getTopAndBottomLine(2));
        line.append(rubikCube.get(Faces.RIGHT).getTopAndBottomLine(2));
        line.append(rubikCube.get(Faces.BACK).getTopAndBottomLine(2));
        line.append(rubikCube.get(Faces.LEFT).getTopAndBottomLine(2));
        String newLine = line.substring(9) + line.substring(0, 9);
        rubikCube.get(Faces.FRONT).setTopAndBottomCube(2, newLine.substring(0, 3));
        rubikCube.get(Faces.RIGHT).setTopAndBottomCube(2, newLine.substring(3, 6));
        rubikCube.get(Faces.BACK).setTopAndBottomCube(2, newLine.substring(6, 9));
        rubikCube.get(Faces.LEFT).setTopAndBottomCube(2, newLine.substring(9));
    }

    private void moveTop() {
        StringBuilder line = new StringBuilder();
        line.append(rubikCube.get(Faces.FRONT).getTopAndBottomLine(0));
        line.append(rubikCube.get(Faces.LEFT).getTopAndBottomLine(0));
        line.append(rubikCube.get(Faces.BACK).getTopAndBottomLine(0));
        line.append(rubikCube.get(Faces.RIGHT).getTopAndBottomLine(0));
        String newLine = line.substring(9) + line.substring(0, 9);
        rubikCube.get(Faces.FRONT).setTopAndBottomCube(0, newLine.substring(0, 3));
        rubikCube.get(Faces.LEFT).setTopAndBottomCube(0, newLine.substring(3, 6));
        rubikCube.get(Faces.BACK).setTopAndBottomCube(0, newLine.substring(6, 9));
        rubikCube.get(Faces.RIGHT).setTopAndBottomCube(0, newLine.substring(9));
    }

    private void moveFront() {
        StringBuilder line = new StringBuilder();
        line.append(rubikCube.get(Faces.TOP).getTopAndBottomLine(2));
        line.append(rubikCube.get(Faces.RIGHT).getLeftAndRightLine(0));
        line.append(rubikCube.get(Faces.BOTTOM).getTopAndBottomLine(0));
        line.append(rubikCube.get(Faces.LEFT).getLeftAndRightLine(2));
        String newLine = line.substring(9) + line.substring(0, 9);
        rubikCube.get(Faces.TOP).setTopAndBottomCube(2, newLine.substring(0, 3));
        rubikCube.get(Faces.RIGHT).setLeftAndRightCube(0, newLine.substring(3, 6));
        rubikCube.get(Faces.BOTTOM).setTopAndBottomCube(0, newLine.substring(6, 9));
        rubikCube.get(Faces.LEFT).setLeftAndRightCube(2, newLine.substring(9));
    }

    private void moveBack() {
        StringBuilder line = new StringBuilder();
        line.append(rubikCube.get(Faces.TOP).getTopAndBottomLine(0));
        line.append(rubikCube.get(Faces.LEFT).getLeftAndRightLine(0));
        line.append(rubikCube.get(Faces.BOTTOM).getTopAndBottomLine(2));
        line.append(rubikCube.get(Faces.RIGHT).getLeftAndRightLine(2));
        String newLine = line.substring(9) + line.substring(0, 9);
        rubikCube.get(Faces.TOP).setTopAndBottomCube(0, newLine.substring(0, 3));
        rubikCube.get(Faces.LEFT).setLeftAndRightCube(0, newLine.substring(3, 6));
        rubikCube.get(Faces.BOTTOM).setTopAndBottomCube(2, newLine.substring(6, 9));
        rubikCube.get(Faces.RIGHT).setLeftAndRightCube(2, newLine.substring(9));
    }


    private void initRubik() {
        for (Faces face : Faces.values()) {
            rubikCube.put(face, new CubeFace(face.getColor()));
        }
    }

}
