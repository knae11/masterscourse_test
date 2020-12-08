import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class UserResponse {

    private final Scanner scanner;
    private Validator validator;

    public UserResponse(Scanner scanner) {
        this.scanner = scanner;
        validator = new Validator();
    }

    public String[] getInput() {
        while (true) {
            try {
                System.out.print("CUBE> ");
                String input = scanner.nextLine().trim().toUpperCase();
                validator.checkInput(input);
                return splitToValidKeys(input);
            } catch (IllegalArgumentException i) {
                System.out.println(i.getMessage());
            }
        }
    }

    private String[] splitToValidKeys(String input) {
        ArrayList<String> validInput = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '\'') {
                validInput.set(i - 1, validInput.get(i - 1) + input.charAt(i));
                continue;
            }
            validInput.add(String.valueOf(input.charAt(i)));
        }
        String[] filteredInput = new String[validInput.size()];
        for (int i = 0; i < validInput.size(); i++) {
            filteredInput[i] = validInput.get(i);
        }
        return filteredInput;
    }
}
