import java.util.HashSet;

public class Validator {

    private HashSet<Character> validKeys = new HashSet<>();
    public Validator(){
        initKeys();
    }

    private void initKeys() {
            validKeys.add('U');
            validKeys.add('R');
            validKeys.add('L');
            validKeys.add('B');
            validKeys.add('\'');
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
               throw new IllegalArgumentException("연산가능한 유효한 문자를 입력해 주세요");
           }
       }
    }

    private void checkEmpty(String input) {
        if(input.isEmpty()){
            throw new IllegalArgumentException("값을 입력해 주세요");
        }
    }

    private void checkWhiteSpace(String input) {
        if(input.split(" ").length > 1){
            throw new IllegalArgumentException("공백없이 원하는 값을 입력해주세요");
        }
    }
}
