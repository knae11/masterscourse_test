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

    private void handleCube(String round) {
        switch (round) {
            case "L":
            case "L'":
                String movedLine = moveLeft(round);
                setLeftLineCube(movedLine);
                break;

        }
    }

    private void setLeftLineCube(String movedLine) {
        for(int i = 0; i<3; i++){
            cube[i][0] = movedLine.charAt(i);
        }
    }

    private String moveLeft(String round) {
        String leftLine = "";
        for (int i = 0; i < 3; i++) {
            leftLine += cube[i][0];
        }
        if (round.contains("'")) {
            return  leftLine.substring(1, 3) + leftLine.substring(0, 1);
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
