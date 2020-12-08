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
            if (input[0].equals("Q")) {
                System.out.println("Bye~");
                return;
            }
            system(input);
        }
    }

    private void system(String[] input) {
        for (String round : input) {
            System.out.println(round);
            handleCube(round);
            printCube();
        }
    }

    private void handleCube(String round) {
        String movedLine;
        switch (round) {
            case "L":
            case "L'":
                movedLine = moveLeft(round);
                setLeftAndRightCube(0, movedLine);
                break;
            case "R":
            case "R'":
                movedLine = moveRight(round);
                setLeftAndRightCube(2, movedLine);
                break;
            case "U":
            case "U'":
                movedLine = moveTop(round);
                setTopAndBottomCube(0, movedLine);
                break;
            case "B":
            case "B'":
                movedLine = moveBottom(round);
                setTopAndBottomCube(2, movedLine);
                break;
            default:
                break;
        }
    }

    private String moveTop(String round) {
        StringBuilder line = getTopAndBottomLine(0);
        return pushTopAndRight(line, round);
    }

    private String moveBottom(String round) {
        StringBuilder line = getTopAndBottomLine(2);
        return pushBottomAndLeft(line, round);
    }

    private String moveRight(String round) {
        StringBuilder line = getLeftAndRightLine(2);
        return pushTopAndRight(line, round);
    }

    private String moveLeft(String round) {
        StringBuilder line = getLeftAndRightLine(0);
        return pushBottomAndLeft(line, round);
    }

    private StringBuilder getTopAndBottomLine(int row) {
        StringBuilder line = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            line.append(cube[row][i]);
        }
        return line;
    }

    private StringBuilder getLeftAndRightLine(int column) {
        StringBuilder line = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            line.append(cube[i][column]);
        }
        return line;
    }

    private void setTopAndBottomCube(int row, String movedLine) {
        for (int i = 0; i < 3; i++) {
            cube[row][i] = movedLine.charAt(i);
        }
    }

    private void setLeftAndRightCube(int column, String movedLine) {
        for (int i = 0; i < 3; i++) {
            cube[i][column] = movedLine.charAt(i);
        }
    }

    private String pushBottomAndLeft(StringBuilder line, String round) {
        if (round.contains("'")) {
            return line.substring(1, 3) + line.charAt(0);
        }
        return line.charAt(2) + line.substring(0, 2);
    }

    private String pushTopAndRight(StringBuilder line, String round) {
        if (round.contains("'")) {
            return line.charAt(2) + line.substring(0, 2);
        }
        return line.substring(1, 3) + line.charAt(0);
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
