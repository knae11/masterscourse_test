import java.util.HashSet;
import java.util.Set;

public class Validator {

    private final Set<Character> validKeys = new HashSet<>();

    public Validator() {
        initKeys();
    }

    private void initKeys() {
        for (ValidKeys key : ValidKeys.values()) {
            validKeys.add(key.getKey());
        }
    }

    public void checkInput(String input) {
        checkEmpty(input);
        checkWhiteSpace(input);
        checkInvalidValue(input);
    }

    private void checkInvalidValue(String input) {
        for (int i = 0; i < input.length(); i++) {
            char letter = input.charAt(i);
            if (!validKeys.contains(letter)) {
                throw new IllegalArgumentException("연산가능한 유효한 문자를 입력해 주세요");
            }
        }
    }

    private void checkEmpty(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("값을 입력해 주세요");
        }
    }

    private void checkWhiteSpace(String input) {
        if (input.split(" ").length > 1) {
            throw new IllegalArgumentException("공백없이 원하는 값을 입력해주세요");
        }
    }
}