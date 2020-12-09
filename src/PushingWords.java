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
            System.out.print(Constants.PRINT_PREFIX);
            String userLine = scanner.nextLine().trim();
            if (userLine.toLowerCase().equals(Constants.EXIT)) {
                return;
            }
            if (!handleUserLine(userLine)) {
                continue;
            }
            printResult();
        }
    }

    private boolean handleUserLine(String line) {
        String[] parsedLine = line.split(Constants.SPLIT_DELIMITER);
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
        word = parsedLine[Constants.WORD];
        count = Math.abs(Integer.parseInt(parsedLine[Constants.COUNT]) % word.length());
        directionLeft = handleDirection(parsedLine[Constants.DIRECTION]);
        if (Integer.parseInt(parsedLine[Constants.COUNT]) < 0) {
            directionLeft = !directionLeft;
        }
    }

    private boolean handleDirection(String direction) {
        return direction.toLowerCase().equals(Constants.LEFT);
    }

    private void printResult() {
        if (directionLeft) {
            String resultWord = word.substring(count) + word.substring(0, count);
            System.out.println(resultWord);
        } else {
            System.out.println(word);
        }
    }

}
