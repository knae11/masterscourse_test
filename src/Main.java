import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        MoveControl moveControl = new MoveControl(scanner);

        final long start = System.currentTimeMillis();
        moveControl.initGame();
        final long end = System.currentTimeMillis();
        scanner.close();

        Printer.printEnding(start, end, moveControl.getCounter());
    }
}
