import constants.Messages;
import constants.ValidMoves;
import java.util.Scanner;

public class MoveControl {

    UserResponse userResponse;
    Printer printer;
    RubikCube rubikCube;
    RandomMix randomMix;

    private int counter = 0;


    public MoveControl(Scanner scanner) {
        userResponse = new UserResponse(scanner);
        printer = new Printer();
        rubikCube = new RubikCube();
        randomMix = new RandomMix();
    }

    public int getCounter() {
        return counter;
    }

    public void initGame() {
        printer.rubikCube(rubikCube.getRubikCube());
        handleRandomMix();
        startCubeGame();
    }

    private void handleRandomMix() {
        if (userResponse.askRandomMix()) {
            RandomMix mixer = new RandomMix();
            String[] randomMix = mixer.getRandomMove();
            /*
            * Print random mix info. Reversed move is answer.
            System.out.println(Arrays.toString(randomMix));
             */
            for (String move : randomMix) {
                system(move);
            }
            printer.rubikCube(rubikCube.getRubikCube());
        }
    }

    private void system(String move) {
        if (move.contains(ValidMoves.FRONT.getKeyString())) {
            rubikCube.moveFront(move);
        }
        if (move.contains(ValidMoves.UP.getKeyString())) {
            rubikCube.moveTop(move);
        }
        if (move.contains(ValidMoves.DOWN.getKeyString())) {
            rubikCube.moveBottom(move);
        }
        if (move.contains(ValidMoves.BACK.getKeyString())) {
            rubikCube.moveBack(move);
        }
        if (move.contains(ValidMoves.LEFT.getKeyString())) {
            rubikCube.moveLeft(move);
        }
        if (move.contains(ValidMoves.RIGHT.getKeyString())) {
            rubikCube.moveRight(move);
        }
    }

    private void startCubeGame() {
        while (true) {
            String[] input = userResponse.getInput();
            if (input[0].equals(ValidMoves.EXIT.getKeyString())) {
                return;
            }
            counter += input.length;
            for (String move : input) {
                System.out.println(move);
                system(move);
                printer.rubikCube(rubikCube.getRubikCube());
            }
            if (rubikCube.checkSuccess()) {
                System.out.println(Messages.WOW_GREAT);
                return;
            }
        }
    }


}
