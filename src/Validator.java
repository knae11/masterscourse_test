import constants.Messages;
import constants.StringConstants;
import constants.ValidMoves;
import java.util.HashSet;
import java.util.Set;

public class Validator {

    private final Set<Character> validKeys = new HashSet<>();

    public Validator() {
        initKeys();
    }

    private void initKeys() {
        for (ValidMoves key : ValidMoves.values()) {
            validKeys.add(key.getKey());
        }
    }

    public void checkYesOrNo(String answer) {
        if (!answer.equals(StringConstants.YES) && !answer.equals(StringConstants.NO)) {
            throw new IllegalArgumentException(Messages.YES_NO_ANSWER);
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
                throw new IllegalArgumentException(Messages.VALID_INPUT_NEEDED);
            }
        }
    }

    private void checkEmpty(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(Messages.VALUE_NEEDED);
        }
    }

    private void checkWhiteSpace(String input) {
        if (input.split(StringConstants.SPLIT_DELIMITER).length > 1) {
            throw new IllegalArgumentException(Messages.BAN_WHITESPACE);
        }
    }
}