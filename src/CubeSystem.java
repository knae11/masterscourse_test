import java.util.ArrayList;
import java.util.Scanner;

public class CubeSystem {

    char[][] cube = {
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

    //TODO: step-1처럼 boolean 값으로 반대방향 지정해서 가능 할 것 같음 ( 중복 로직제거하기 )
    private void handleCube(String round) {
        String movedLine;
        switch (round) {
            case "L":
            case "L'":
                movedLine = moveLeft(round);
                setLeftLineCube(movedLine);
                break;
            case "R":
            case "R'":
                movedLine = moveRight(round);
                setRightLineCube(movedLine);
                break;
            case "U":
            case "U'":
                movedLine = moveTop(round);
                setTopLineCube(movedLine);
                break;
            case "B":
            case "B'":
                movedLine = moveBottom(round);
                setBottomLineCube(movedLine);
                break;
            default:
                break;


        }
    }

    private String moveTop(String round) {
        String leftLine = "";
        for (int i = 0; i < 3; i++) {
            leftLine += cube[0][i];
        }
        if (round.contains("'")) {
            return leftLine.substring(2, 3) + leftLine.substring(0, 2);
        }

        return leftLine.substring(1, 3) + leftLine.substring(0, 1);
    }

    private void setTopLineCube(String movedLine) {
        for (int i = 0; i < 3; i++) {
            cube[0][i] = movedLine.charAt(i);
        }
    }

    private String moveBottom(String round) {
        String leftLine = "";
        for (int i = 0; i < 3; i++) {
            leftLine += cube[2][i];
        }
        if (round.contains("'")) {
            return leftLine.substring(1, 3) + leftLine.substring(0, 1);
        }
        return leftLine.substring(2, 3) + leftLine.substring(0, 2);
    }

    private void setBottomLineCube(String movedLine) {
        for (int i = 0; i < 3; i++) {
            cube[2][i] = movedLine.charAt(i);
        }

    }

    private String moveRight(String round) {
        String leftLine = "";
        for (int i = 0; i < 3; i++) {
            leftLine += cube[i][2];
        }
        if (round.contains("'")) {
            return leftLine.substring(2, 3) + leftLine.substring(0, 2);
        }
        return leftLine.substring(1, 3) + leftLine.substring(0, 1);
    }

    private void setRightLineCube(String movedLine) {
        for (int i = 0; i < 3; i++) {
            cube[i][2] = movedLine.charAt(i);
        }
    }

    private void setLeftLineCube(String movedLine) {
        for (int i = 0; i < 3; i++) {
            cube[i][0] = movedLine.charAt(i);
        }
    }

    private String moveLeft(String round) {
        String leftLine = "";
        for (int i = 0; i < 3; i++) {
            leftLine += cube[i][0];
        }
        if (round.contains("'")) {
            return leftLine.substring(1, 3) + leftLine.substring(0, 1);
        }
        return leftLine.substring(2, 3) + leftLine.substring(0, 2);

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
