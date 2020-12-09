import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        final long start = System.currentTimeMillis();
        RubikCube rubikCube = new RubikCube(scanner);
        final long end = System.currentTimeMillis();
        scanner.close();
        final int time = (int)((end-start)/1000);

        System.out.printf(Messages.TIME_SPEND, time/60, time%60);
        System.out.println(Messages.MOVE_COUNT+rubikCube.getCounter());
        System.out.println(Messages.THANKS);
    }
}
