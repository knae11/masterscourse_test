import java.util.HashSet;

public class Validator {

    private final HashSet<Character> validKeys = new HashSet<>();
    public Validator(){
        initKeys();
    }

    private void initKeys() {
        for(ValidKeys key: ValidKeys.values()){
            validKeys.add(key.getKey());
        }
    }

    public void checkInput(String input){
        checkEmpty(input);
        checkWhiteSpace(input);
        checkInvalidValue(input);
    }

    private void checkInvalidValue(String input) {
       for(int i=0; i<input.length(); i++){
           char letter = input.charAt(i);
           if(!validKeys.contains(letter)){
               throw new IllegalArgumentException(Constants.INVALID_INPUT);
           }
       }
    }

    private void checkEmpty(String input) {
        if(input.isEmpty()){
            throw new IllegalArgumentException(Constants.IS_EMPTY);
        }
    }

    private void checkWhiteSpace(String input) {
        if(input.split(Constants.SPLIT_DELIMITER).length > 1){
            throw new IllegalArgumentException(Constants.BAN_WHITESPACE);
        }
    }
}
