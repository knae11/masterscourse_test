import java.util.Scanner;

public class PushingWords {

    private final Scanner scanner;
    private final Validator validator;
    private String word;
    private int count;
    private boolean directionLeft;

    public PushingWords(Scanner scanner) {
        this.scanner = scanner;
        validator = new Validator();
        init();
    }

    private void init() {
        while (true) {
            System.out.print(">");
            String userLine = scanner.nextLine().trim();
            if (userLine.equals("q")) {
                return;
            }
            if (!parseUserLine(userLine)) {
                continue;
            }
            printResult();
        }
    }

    private void printResult() {
        if (directionLeft) {
            String resultWord = word.substring(count) + word.substring(0, count);
            System.out.println(resultWord);
        } else {
            System.out.println(word);
        }
    }

    private boolean parseUserLine(String line) {
        String[] parsedLine = line.split(" ");
        try {
            validator.checkInput(parsedLine);
            makeValuesFromParsing(parsedLine);
            return true;
        } catch (IllegalArgumentException i) {
            System.out.println(i.getMessage());
            return false;
        }
    }

    private void makeValuesFromParsing(String[] parsedLine) {
        word = parsedLine[0];
        count = Math.abs(Integer.parseInt(parsedLine[1]) % word.length());
        directionLeft = handleDirection(parsedLine[2]);
        if (Integer.parseInt(parsedLine[1])<0){
            directionLeft = !directionLeft;
        }
    }

    private boolean handleDirection(String direction) {
        return direction.toLowerCase().equals("l");
    }


}
