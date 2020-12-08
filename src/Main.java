import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        final long start = System.currentTimeMillis();
        RubikCube rubikCube = new RubikCube(scanner);
        final long end = System.currentTimeMillis();
        scanner.close();
        final int time = (int)((end-start)/1000);

        System.out.printf("경과시간: %02d:%02d\n", time/60, time%60);
        System.out.println("조작갯수: "+rubikCube.getCounter());
        System.out.println("이용해주셔서 감사합니다. 뚜뚜뚜.");
    }
}
