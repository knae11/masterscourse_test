import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserResponse {

    private final Scanner scanner;

    private final Validator validator;

    public UserResponse(Scanner scanner) {
        this.scanner = scanner;
        validator = new Validator();
    }

    //TODO : validator check
    public boolean askRandomMix(){
        System.out.println("\n랜덤 믹스를 원하시면 Y를 아니면 N를 입력해 주세요");
        String answer = scanner.nextLine().trim().toUpperCase();
        if(answer.equals("Y")){
            return true;
        }
        return false;
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
        List<String> validInput = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '\'') {
                validInput.set(validInput.size()- 1, validInput.get(validInput.size()- 1) + input.charAt(i));
                continue;
            }
            if(input.charAt(i) == '2'){
                validInput.set(validInput.size()- 1, validInput.get(validInput.size()- 1) + input.charAt(i));
                continue;
            }
            validInput.add(String.valueOf(input.charAt(i)));
        }
        return makeToStringArray(validInput);
    }

    private String[] makeToStringArray(List<String> validInput) {
        String[] filteredInput = new String[validInput.size()];
        for (int i = 0; i < validInput.size(); i++) {
            filteredInput[i] = validInput.get(i);
        }
        return filteredInput;
    }
}
