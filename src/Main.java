import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        RubikCube rubikCube = new RubikCube(scanner);
        scanner.close();
        System.out.println("경과시간: ");
        System.out.println("조작갯수: "+rubikCube.getCounter());
        System.out.println("이용해주셔서 감사합니다. 뚜뚜뚜.");
    }
}
