import java.util.Scanner;

public class CubeSystem {

    private char[][] cube = {
        {'R', 'R', 'W'},
        {'G', 'C', 'W'},
        {'G', 'B', 'B'}
    };

    private final UserResponse userResponse;

    public CubeSystem(Scanner scanner) {
        userResponse = new UserResponse(scanner);
        printCube();
        startCube();
    }

    private void startCube() {
        while (true) {
            String[] input = userResponse.getInput();
            if (input[0].equals(ValidKeys.EXIT.getKeyString())) {
                System.out.println(Constants.ENDING_MESSAGE);
                return;
            }
            runSystem(input);
        }
    }

    private void runSystem(String[] input) {
        for (String move : input) {
            System.out.println(move);
            handleCube(move);
            printCube();
        }
    }

    private void handleCube(String move) {
        String movedLine;
        if (move.contains(ValidKeys.LEFT.getKeyString())) {
            movedLine = moveLeft(move);
            setLeftAndRightCube(Constants.TOP_OR_LEFT, movedLine);
        }
        if (move.contains(ValidKeys.RIGHT.getKeyString())) {
            movedLine = moveRight(move);
            setLeftAndRightCube(Constants.BOTTOM_OR_RIGHT, movedLine);
        }
        if (move.contains(ValidKeys.UP.getKeyString())) {
            movedLine = moveTop(move);
            setTopAndBottomCube(Constants.TOP_OR_LEFT, movedLine);
        }
        if (move.contains(ValidKeys.BOTTOM.getKeyString())) {
            movedLine = moveBottom(move);
            setTopAndBottomCube(Constants.BOTTOM_OR_RIGHT, movedLine);
        }
    }

    private String moveTop(String move) {
        StringBuilder line = getTopAndBottomLine(Constants.TOP_OR_LEFT);
        return pushTopAndRight(line, move);
    }

    private String moveBottom(String move) {
        StringBuilder line = getTopAndBottomLine(Constants.BOTTOM_OR_RIGHT);
        return pushBottomAndLeft(line, move);
    }

    private String moveRight(String move) {
        StringBuilder line = getLeftAndRightLine(Constants.BOTTOM_OR_RIGHT);
        return pushTopAndRight(line, move);
    }

    private String moveLeft(String move) {
        StringBuilder line = getLeftAndRightLine(Constants.TOP_OR_LEFT);
        return pushBottomAndLeft(line, move);
    }

    private StringBuilder getTopAndBottomLine(int row) {
        StringBuilder line = new StringBuilder();
        for (int i = 0; i < Constants.CUBE_SIZE; i++) {
            line.append(cube[row][i]);
        }
        return line;
    }

    private StringBuilder getLeftAndRightLine(int column) {
        StringBuilder line = new StringBuilder();
        for (int i = 0; i < Constants.CUBE_SIZE; i++) {
            line.append(cube[i][column]);
        }
        return line;
    }

    private void setTopAndBottomCube(int row, String movedLine) {
        for (int i = 0; i < Constants.CUBE_SIZE; i++) {
            cube[row][i] = movedLine.charAt(i);
        }
    }

    private void setLeftAndRightCube(int column, String movedLine) {
        for (int i = 0; i < Constants.CUBE_SIZE; i++) {
            cube[i][column] = movedLine.charAt(i);
        }
    }

    private String pushBottomAndLeft(StringBuilder line, String move) {
        if (move.contains(ValidKeys.REVERSE.getKeyString())) {
            return line.substring(Constants.FIRST + 1) + line.charAt(Constants.FIRST);
        }
        return line.charAt(Constants.LAST) + line.substring(Constants.FIRST, Constants.LAST);
    }

    private String pushTopAndRight(StringBuilder line, String move) {
        if (move.contains(ValidKeys.REVERSE.getKeyString())) {
            return line.charAt(Constants.LAST) + line.substring(Constants.FIRST, Constants.LAST);
        }
        return line.substring(Constants.FIRST + 1) + line.charAt(Constants.FIRST);
    }

    private void printCube() {
        for (char[] row : cube) {
            for (char box : row) {
                System.out.printf("%3s", box);
            }
            System.out.println();
        }
    }

}
