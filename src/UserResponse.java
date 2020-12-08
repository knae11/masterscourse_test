import java.util.Scanner;

public class UserResponse {

    private final Scanner scanner;
    private Validator validator;
    public UserResponse(Scanner scanner) {
        this.scanner = scanner;
        validator = new Validator();
    }

    public String getInput() {
        while (true) {
            try {
                System.out.print("CUBE> ");
                String input = scanner.nextLine().trim().toUpperCase();
                validator.checkInput(input);
                return input;
            } catch (IllegalArgumentException i) {
                System.out.println(i.getMessage());
            }

        }
    }
}
