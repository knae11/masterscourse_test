import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RubikCube {

    private final Map<Faces, CubeFace> rubikCube = new HashMap<>();
    UserResponse userResponse;
    Printer printer;
    private int counter = 0;

    public RubikCube(Scanner scanner) {
        userResponse = new UserResponse(scanner);
        printer = new Printer();
        initRubik();
        printer.rubikCube(rubikCube);
        askRandomMix();
        startCubeGame();
    }
    //TODO: 무작위 섞기 구현하기
    private void askRandomMix() {
        if(userResponse.askRandomMix()){
            RandomMix mixer = new RandomMix();
            String[] randomMix = mixer.getRandomMove();
            for(String move : randomMix){
                system(move);
            }
            printer.rubikCube(rubikCube);
        }
    }

    public int getCounter() {
        return counter;
    }

    private void startCubeGame() {
        while (true) {
            String[] input = userResponse.getInput();
            if (input[0].equals("Q")) {
                return;
            }
            counter += input.length;
            for (String move : input) {
                System.out.println(move);
                system(move);
                printer.rubikCube(rubikCube);
            }
            if (checkSuccess()) {
                System.out.println("\n큐브를 맞추시다니 대단합니다. 축하드려요!🎉");
                return;
            }
        }
    }

    private boolean checkSuccess() {
        for (CubeFace face : rubikCube.values()) {
            if (!face.completeFace()) {
                return false;
            }
        }
        return true;
    }

    private void system(String move) {
        if (move.contains("F")) {
            moveFront(move);
        }
        if (move.contains("U")) {
            moveTop(move);
        }
        if (move.contains("D")) {
            moveBottom(move);
        }
        if (move.contains("B")) {
            moveBack(move);
        }
        if (move.contains("L")) {
            moveLeft(move);
        }
        if (move.contains("R")) {
            moveRight(move);
        }
    }

    private void moveRight(String move) {
        StringBuilder line = new StringBuilder();
        line.append(rubikCube.get(Faces.TOP).getLeftAndRightLine(2));
        line.append(rubikCube.get(Faces.BACK).getLeftAndRightLine(0));
        line.append(rubikCube.get(Faces.BOTTOM).getLeftAndRightLine(2));
        line.append(rubikCube.get(Faces.FRONT).getLeftAndRightLine(2));
        String newLine = clockwiseOrCounter(move, line);
        rubikCube.get(Faces.TOP).setLeftAndRightCube(2, newLine.substring(0, 3));
        rubikCube.get(Faces.BACK).setLeftAndRightCube(0, newLine.substring(3, 6));
        rubikCube.get(Faces.BOTTOM).setLeftAndRightCube(2, newLine.substring(6, 9));
        rubikCube.get(Faces.FRONT).setLeftAndRightCube(2, newLine.substring(9));
    }

    private void moveLeft(String move) {
        StringBuilder line = new StringBuilder();
        line.append(rubikCube.get(Faces.TOP).getLeftAndRightLine(0));
        line.append(rubikCube.get(Faces.FRONT).getLeftAndRightLine(0));
        line.append(rubikCube.get(Faces.BOTTOM).getLeftAndRightLine(0));
        line.append(rubikCube.get(Faces.BACK).getLeftAndRightLine(2));
        String newLine = clockwiseOrCounter(move, line);
        rubikCube.get(Faces.TOP).setLeftAndRightCube(0, newLine.substring(0, 3));
        rubikCube.get(Faces.FRONT).setLeftAndRightCube(0, newLine.substring(3, 6));
        rubikCube.get(Faces.BOTTOM).setLeftAndRightCube(0, newLine.substring(6, 9));
        rubikCube.get(Faces.BACK).setLeftAndRightCube(2, newLine.substring(9));
    }

    private void moveBottom(String move) {
        StringBuilder line = new StringBuilder();
        line.append(rubikCube.get(Faces.FRONT).getTopAndBottomLine(2));
        line.append(rubikCube.get(Faces.RIGHT).getTopAndBottomLine(2));
        line.append(rubikCube.get(Faces.BACK).getTopAndBottomLine(2));
        line.append(rubikCube.get(Faces.LEFT).getTopAndBottomLine(2));
        String newLine = clockwiseOrCounter(move, line);
        rubikCube.get(Faces.FRONT).setTopAndBottomCube(2, newLine.substring(0, 3));
        rubikCube.get(Faces.RIGHT).setTopAndBottomCube(2, newLine.substring(3, 6));
        rubikCube.get(Faces.BACK).setTopAndBottomCube(2, newLine.substring(6, 9));
        rubikCube.get(Faces.LEFT).setTopAndBottomCube(2, newLine.substring(9));
    }

    private void moveTop(String move) {
        StringBuilder line = new StringBuilder();
        line.append(rubikCube.get(Faces.FRONT).getTopAndBottomLine(0));
        line.append(rubikCube.get(Faces.LEFT).getTopAndBottomLine(0));
        line.append(rubikCube.get(Faces.BACK).getTopAndBottomLine(0));
        line.append(rubikCube.get(Faces.RIGHT).getTopAndBottomLine(0));
        String newLine = clockwiseOrCounter(move, line);
        rubikCube.get(Faces.FRONT).setTopAndBottomCube(0, newLine.substring(0, 3));
        rubikCube.get(Faces.LEFT).setTopAndBottomCube(0, newLine.substring(3, 6));
        rubikCube.get(Faces.BACK).setTopAndBottomCube(0, newLine.substring(6, 9));
        rubikCube.get(Faces.RIGHT).setTopAndBottomCube(0, newLine.substring(9));
    }

    private void moveFront(String move) {
        StringBuilder line = new StringBuilder();
        line.append(rubikCube.get(Faces.TOP).getTopAndBottomLine(2));
        line.append(rubikCube.get(Faces.RIGHT).getLeftAndRightLine(0));
        line.append(rubikCube.get(Faces.BOTTOM).getTopAndBottomLine(0));
        line.append(rubikCube.get(Faces.LEFT).getLeftAndRightLine(2));
        String newLine = clockwiseOrCounter(move, line);
        rubikCube.get(Faces.TOP).setTopAndBottomCube(2, newLine.substring(0, 3));
        rubikCube.get(Faces.RIGHT).setLeftAndRightCube(0, newLine.substring(3, 6));
        rubikCube.get(Faces.BOTTOM).setTopAndBottomCube(0, newLine.substring(6, 9));
        rubikCube.get(Faces.LEFT).setLeftAndRightCube(2, newLine.substring(9));
    }

    private void moveBack(String move) {
        StringBuilder line = new StringBuilder();
        line.append(rubikCube.get(Faces.TOP).getTopAndBottomLine(0));
        line.append(rubikCube.get(Faces.LEFT).getLeftAndRightLine(0));
        line.append(rubikCube.get(Faces.BOTTOM).getTopAndBottomLine(2));
        line.append(rubikCube.get(Faces.RIGHT).getLeftAndRightLine(2));
        String newLine = clockwiseOrCounter(move, line);
        rubikCube.get(Faces.TOP).setTopAndBottomCube(0, newLine.substring(0, 3));
        rubikCube.get(Faces.LEFT).setLeftAndRightCube(0, newLine.substring(3, 6));
        rubikCube.get(Faces.BOTTOM).setTopAndBottomCube(2, newLine.substring(6, 9));
        rubikCube.get(Faces.RIGHT).setLeftAndRightCube(2, newLine.substring(9));
    }

    private String clockwiseOrCounter(String move, StringBuilder line) {
        if (move.contains("2")) {
            return line.substring(6) + line.substring(0, 6);
        }
        if (move.contains("'")) {
            return line.substring(3) + line.substring(0, 3);
        }
        return line.substring(9) + line.substring(0, 9);
    }

    private void initRubik() {
        for (Faces face : Faces.values()) {
            rubikCube.put(face, new CubeFace(face.getColor()));
        }
    }

}
