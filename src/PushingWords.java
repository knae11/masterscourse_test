import java.util.Scanner;

public class PushingWords {

    private final Scanner scanner;
    private final Validator validator;
    private String word;
    private int count;
    private String direction;

    public PushingWords(Scanner scanner){
        this.scanner = scanner;
        validator = new Validator();
        init();
    }

    private void init() {
        while(true){
            System.out.print(">");
            String userLine = scanner.nextLine().trim();
            if(userLine.equals("q")){
                return;
            }
            parseUserLine(userLine);
            printResult();
        }
    }

    private void printResult() {
    }

    private void parseUserLine(String line) {
        String[] parsedLine = line.split(" ");
        validator.checkLineLength(parsedLine);
        validator.checkNumber(parsedLine[1]);
        validator.checkDirection(parsedLine[2]);
        word = parsedLine[0];
        count = Integer.parseInt(parsedLine[1]);
        direction = parsedLine[2];

    }


}
