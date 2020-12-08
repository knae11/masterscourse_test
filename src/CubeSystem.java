import java.util.ArrayList;
import java.util.Scanner;

public class CubeSystem {

    String[][] cube = {
        {"R", "R", "W"},
        {"G", "C", "W"},
        {"G", "B", "B"}
    };

    private final UserResponse userResponse;
    public CubeSystem(Scanner scanner){
        userResponse = new UserResponse(scanner);
        printCube();
        startCube();
    }

    private void startCube() {
        while(true){
            String[] input = userResponse.getInput();
            if(input[0].equals("Q")){
                System.out.println("Bye~");
                return;
            }
           system(input);
        }
    }

    private void system(String[] input) {
        for(String round: input){
            System.out.println(round);
            printCube();
        }


    }

    private void printCube(){
        for (String[] row : cube) {
            for (String box : row) {
                System.out.printf("%3s", box);
            }
            System.out.println();
        }
    }
}
