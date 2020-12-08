import java.util.Arrays;
import java.util.Scanner;

public class Cube {

    String[][] cube = {
        {"R", "R", "W"},
        {"G", "C", "W"},
        {"G", "B", "B"}
    };
    private final Scanner scanner;
    public Cube(){
        scanner = new Scanner(System.in);
        printCube();
        startCube();
    }

    private void startCube() {
        while(true){
            System.out.print("CUBE> ");
            String input = scanner.nextLine().toUpperCase();
            if(input.contains("Q")){
                System.out.println("Bye~");
                scanner.close();
                return;
            }
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
