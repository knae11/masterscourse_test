import java.util.Scanner;

public class Control {

    private final UserResponse userResponse;
    private final Printer printer;
    private final Cube cube;

    public Control(Scanner scanner){
        userResponse = new UserResponse(scanner);
        cube = new Cube();
        printer = new Printer();
        printer.printCube(cube.getCube());
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
            cube.handleCube(move);
            printer.printCube(cube.getCube());
        }
    }

}
